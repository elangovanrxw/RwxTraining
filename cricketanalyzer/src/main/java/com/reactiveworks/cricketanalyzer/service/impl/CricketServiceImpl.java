package com.reactiveworks.cricketanalyzer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.reactiveworks.cricketanalyzer.pojo.CompleteFieldCountDetail;
import com.reactiveworks.cricketanalyzer.pojo.CompleteRunRateDetail;
import com.reactiveworks.cricketanalyzer.pojo.CompleteScoreDetail;
import com.reactiveworks.cricketanalyzer.pojo.Deliveries;
import com.reactiveworks.cricketanalyzer.pojo.Matches;
import com.reactiveworks.cricketanalyzer.pojo.RunRateParameters;
import com.reactiveworks.cricketanalyzer.pojo.ScoreDetailParameters;
import com.reactiveworks.cricketanalyzer.service.ICricketService;


public class CricketServiceImpl implements ICricketService {
	
	/**
	 * Implementation of the logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(CricketServiceImpl.class);

	/**
	 * A helper method to provide the list of deliveries for the particular match id.
	 * @param deliveryList list that contains all delivery details.
	 * @param matchId the match id for that we have to get all the deliveries.
	 * @return a list of deliveries only containing that given match id.
	 */
	private  List<Deliveries> iterateDeliveriesForMatchID(List<Deliveries> deliveryList,int matchId) {
		
		List<Deliveries> deliveryForMatchId 
		 	= deliveryList.stream()
		 				  .filter(delivery -> delivery.getMatchId()==matchId)
		 				  .collect(Collectors.toList());
		
		return deliveryForMatchId;
	}
	
	/**
	 * A helper method to get the four count, six count and runs of the two innings.
	 * @param deliveries list of deliveries for only one match id.
	 * @return a map which is storing the four count, six count and total runs.
	 */
	private ScoreDetailParameters getScoresAndCounts(List<Deliveries> deliveries){
		
		int teamOneTotalRuns=0;
		int teamOneSixCount=0;
		int teamOneFourCount=0;
		
		int teamTwoTotalRuns=0;
		int teamTwoSixCount=0;
		int teamTwoFourCount=0;
		String teamOneName=null;
		String teamTwoName=null;
		boolean inning2happened=false;
		
		int t1superOverFourCount=0;
		int t1superOverSixCount=0;
		int t1superOverTotalRuns=0;
		
		int t2superOverFourCount=0;
		int t2superOverSixCount=0;
		int t2superOverTotalRuns=0;
		
		//Getting 1st Innings.
		List<Deliveries> firstInningsList = deliveries.stream()
				  									  .filter(delivery -> delivery.getInning()==1)
				  									  .collect(Collectors.toList());
		
		//Getting 2nd Innings.
		List<Deliveries> secondInningsList = deliveries.stream()
				  									   .filter(delivery -> delivery.getInning()==2)
				  									   .collect(Collectors.toList());
		//Getting 3rd Innings
		List<Deliveries> thirdInningsList = deliveries.stream()
											.filter(delivery -> delivery.getInning()==3)
											.collect(Collectors.toList());
		
		//Getting 4th Innings
		List<Deliveries> fourthInningsList = deliveries.stream()
											.filter(delivery -> delivery.getInning()==4)
											.collect(Collectors.toList());
		//Team 1 - Getting four count
		teamOneFourCount = (int) firstInningsList.stream()
										   .filter(delivery -> delivery.getBatsmanRuns()==4)
										   .count();
		
		//Team 1 - Getting six count
		teamOneSixCount = (int) firstInningsList.stream()
										  .filter(delivery -> delivery.getBatsmanRuns()==6)
										  .count();
		
		//Team 1 - Getting total runs.
		teamOneTotalRuns = firstInningsList.stream()
										   .map(delivery -> delivery.getTotalRuns())
										   .collect(Collectors.summingInt(Integer::intValue));

		// Getting Team 1 name.
		teamOneName = firstInningsList.get(0).getBattingTeam();
		
		int matchId = firstInningsList.get(0).getMatchId();
		
//		LOGGER.debug(matchId+" "+teamOneName+" "+teamOneFourCount+" "+teamOneSixCount+" "+teamOneTotalRuns);
		
		if(secondInningsList.size()!=0) {	 //Checking if 2nd inning has happened.
			
			inning2happened=true;
			
			//Team 2 - Getting four count
			teamTwoFourCount = (int) secondInningsList.stream()
												 .filter(delivery -> delivery.getBatsmanRuns()==4)
												 .count();
			
			//Team 2 - Getting six count
			teamTwoSixCount = (int) secondInningsList.stream()
												.filter(delivery -> delivery.getBatsmanRuns()==6)
												.count();
			
			//Team 2 - Getting total runs
			teamTwoTotalRuns = secondInningsList.stream()
												.map(delivery -> delivery.getTotalRuns())
												.collect(Collectors.summingInt(Integer::intValue));
			
			// Getting Team 2 name.
			teamTwoName= secondInningsList.get(0).getBattingTeam();
//			LOGGER.debug(matchId+" "+teamTwoName+" "+teamTwoFourCount+" "+teamTwoSixCount+" "+teamTwoTotalRuns);
		}
		ScoreDetailParameters scoreParameters = new ScoreDetailParameters();
		
		if(inning2happened && thirdInningsList.size()!=0 && fourthInningsList.size()!=0) {
			
			//Third innings has to be played by second batting team.
			
			t2superOverFourCount = (int) thirdInningsList.stream()
												   .filter(delivery -> delivery.getBatsmanRuns()==4)
												   .count();
			t2superOverSixCount = (int) thirdInningsList.stream()
												   .filter(delivery -> delivery.getBatsmanRuns()==6)
												   .count();
			
			t2superOverTotalRuns= thirdInningsList.stream()
													.map(delivery -> delivery.getTotalRuns())
													.collect(Collectors.summingInt(Integer::intValue));	
			//Fourth innings has to be played by first batting team.
			
			t1superOverFourCount = (int) fourthInningsList.stream()
												   .filter(delivery -> delivery.getBatsmanRuns()==4)
												   .count();
			t1superOverSixCount = (int) fourthInningsList.stream()
												   .filter(delivery -> delivery.getBatsmanRuns()==6)
												   .count();
			t1superOverTotalRuns= fourthInningsList.stream()
													.map(delivery -> delivery.getTotalRuns())
													.collect(Collectors.summingInt(Integer::intValue));	
			scoreParameters.setTeamOneName(teamOneName);
			scoreParameters.setTeamOneFourCount(teamOneFourCount + t1superOverFourCount);
			scoreParameters.setTeamOneSixCount(teamOneSixCount + t1superOverSixCount);
			scoreParameters.setTeamOneTotalRuns(teamOneTotalRuns + t1superOverTotalRuns);
			
//			LOGGER.debug(teamOneName+","+t1superOverFourCount+","+t1superOverSixCount+","+t1superOverTotalRuns);
			
			scoreParameters.setTeamTwoName(teamTwoName);
			scoreParameters.setTeamTwoFourCount(teamTwoFourCount + t2superOverFourCount);
			scoreParameters.setTeamTwoSixCount(teamTwoSixCount + t2superOverSixCount);
			scoreParameters.setTeamTwoTotalRuns(teamTwoTotalRuns + t2superOverTotalRuns);
			
//			LOGGER.debug(teamTwoName+","+t2superOverFourCount+","+t2superOverSixCount+","+t2superOverTotalRuns);
		}
		else if(inning2happened)
		{
			scoreParameters.setTeamOneName(teamOneName);
			scoreParameters.setTeamOneFourCount(teamOneFourCount);
			scoreParameters.setTeamOneSixCount(teamOneSixCount);
			scoreParameters.setTeamOneTotalRuns(teamOneTotalRuns);
			
			scoreParameters.setTeamTwoName(teamTwoName);
			scoreParameters.setTeamTwoFourCount(teamTwoFourCount);
			scoreParameters.setTeamTwoSixCount(teamTwoSixCount);
			scoreParameters.setTeamTwoTotalRuns(teamTwoTotalRuns);
		}
		else
		{
			scoreParameters.setTeamOneName(teamOneName);
			scoreParameters.setTeamOneFourCount(teamOneFourCount);
			scoreParameters.setTeamOneSixCount(teamOneSixCount);
			scoreParameters.setTeamOneTotalRuns(teamOneTotalRuns);
		}
		return scoreParameters;
	}
	/**
	 * This method is used to get the complete score details of the teams played
	 * in the respective years.
	 * @param list of deliveries which contains all the deliveries details.
	 * @param list of matches which contains all the matches details.
	 */
	@Override
	public List<CompleteScoreDetail> getScoreDetails(List<Deliveries> deliveries, List<Matches> matches) {
		
	
		List<CompleteScoreDetail> finalList= new ArrayList<CompleteScoreDetail>();
		
		matches.stream().forEach(
									match -> {
										int matchId = match.getMatchId();
										int year = match.getSeason();
									
								//		LOGGER.debug("Iterating match id : "+matchId);
										List<Deliveries> deliveriesForMatchId = iterateDeliveriesForMatchID(deliveries, matchId);
										ScoreDetailParameters scoreParameters = getScoresAndCounts(deliveriesForMatchId);
								//		LOGGER.debug(matchId+","+scoreParameters);
										boolean updated1=false;
										boolean updated2=false;
										
										for(int j=0 ;j<finalList.size(); j++)
										{
											if(finalList.get(j).getYear()== year &&
													finalList.get(j).getTeamName().equals(scoreParameters.getTeamOneName()))
											{ 
												updated1= true;
//												LOGGER.debug("Updating existing as TeamOne : "+year+finalList.get(j).getTeamName());
//												LOGGER.debug("OLD VALUE TeamOne: "+finalList.get(j).getYear()+","+finalList.get(j).getTeamName()+","+finalList.get(j).getFourCount()
//														+","+finalList.get(j).getSixCount()+","+finalList.get(j).getTotalScore());
//												LOGGER.debug("ADDING THIS TO OLD TeamOne: "+year+","+scoreParameters.get("teamOneName")+","+scoreParameters.get("teamOneFourCount")
//														+","+scoreParameters.get("teamOneSixCount")+","+scoreParameters.get("teamOneTotalRuns"));
//												
//												LOGGER.debug("NEW VALUE TeamOne: "+year+","+scoreParameters.get("teamOneName")+","+
//														(finalList.get(j).getFourCount() + (int)scoreParameters.get("teamOneFourCount"))+","+
//														(finalList.get(j).getSixCount() + (int)scoreParameters.get("teamOneSixCount"))+","+
//														(finalList.get(j).getTotalScore() + (int)scoreParameters.get("teamOneTotalRuns")));
												
												finalList.get(j).setYear(year);
												finalList.get(j).setTeamName(scoreParameters.getTeamOneName());
												finalList.get(j).setFourCount(finalList.get(j).getFourCount() + scoreParameters.getTeamOneFourCount());
												finalList.get(j).setSixCount(finalList.get(j).getSixCount() + scoreParameters.getTeamOneSixCount());
												finalList.get(j).setTotalScore(finalList.get(j).getTotalScore() + scoreParameters.getTeamOneTotalRuns());
											}
											else if(finalList.get(j).getYear() == year &&
													finalList.get(j).getTeamName().equals(scoreParameters.getTeamTwoName()))
											{
												updated2=true;
//												LOGGER.debug("Updating existing as TeamTwo : "+year+finalList.get(j).getTeamName());
//												
//												LOGGER.debug("OLD VALUE TeamOne: "+finalList.get(j).getYear()+","+finalList.get(j).getTeamName()+","+finalList.get(j).getFourCount()
//														+","+finalList.get(j).getSixCount()+","+finalList.get(j).getTotalScore());
//												LOGGER.debug("ADDING THIS TO OLD TeamTwo: "+year+","+scoreParameters.get("teamTwoName")+","+scoreParameters.get("teamTwoFourCount")
//														+","+scoreParameters.get("teamTwoSixCount")+","+scoreParameters.get("teamTwoTotalRuns"));
//												
//												LOGGER.debug("NEW VALUE TeamTwo: "+year+","+scoreParameters.get("teamTwoName")+","+
//														(finalList.get(j).getFourCount() + (int)scoreParameters.get("teamTwoFourCount"))+","+
//														(finalList.get(j).getSixCount() + (int)scoreParameters.get("teamTwoSixCount"))+","+
//														(finalList.get(j).getTotalScore() + (int)scoreParameters.get("teamTwoTotalRuns")));
												finalList.get(j).setYear(year);
												finalList.get(j).setTeamName(scoreParameters.getTeamTwoName());
												finalList.get(j).setFourCount(finalList.get(j).getFourCount() + scoreParameters.getTeamTwoFourCount());
												finalList.get(j).setSixCount(finalList.get(j).getSixCount() + scoreParameters.getTeamTwoSixCount());
												finalList.get(j).setTotalScore(finalList.get(j).getTotalScore() + scoreParameters.getTeamTwoTotalRuns());
											}
										}
										if(updated1==false && scoreParameters.ifInningTwoHappened())  {
												CompleteScoreDetail scoreDetails = new CompleteScoreDetail();
												scoreDetails.setYear(year);
												scoreDetails.setTeamName(scoreParameters.getTeamOneName());
												scoreDetails.setFourCount(scoreParameters.getTeamOneFourCount());
												scoreDetails.setSixCount(scoreParameters.getTeamOneSixCount());
												scoreDetails.setTotalScore(scoreParameters.getTeamOneTotalRuns());
												finalList.add(scoreDetails);
									//			LOGGER.debug("Freshly adding up1: "+scoreDetails);
		
										}
										if(updated2==false && scoreParameters.ifInningTwoHappened()) {
												CompleteScoreDetail scoreDetails = new CompleteScoreDetail();
												scoreDetails.setYear(year);
												scoreDetails.setTeamName(scoreParameters.getTeamTwoName());
												scoreDetails.setFourCount(scoreParameters.getTeamTwoFourCount());
												scoreDetails.setSixCount(scoreParameters.getTeamTwoSixCount());
												scoreDetails.setTotalScore(scoreParameters.getTeamTwoTotalRuns());
												finalList.add(scoreDetails);
									//			LOGGER.debug("Freshly adding up2: "+scoreDetails);
										}										
										
									}
								);
		
		
	//	finalList.stream().forEach(LOGGER::debug);
		return finalList;
		
		
	}

	/**
	 * This is a private helper method to get the team which has highest run rate 
	 * among all the teams for the given year
	 * @param runRateList a complete list of all teams and its run rate.
	 * @param year the year for which highest run rate team has to be computed.
	 * @return an object of {@link CompleteRunRateDetail} which has the highest run rate team details.
	 */
	private CompleteRunRateDetail getHighestRunRateForYear(List<CompleteRunRateDetail> runRateList,int year) {
		
		List<CompleteRunRateDetail> highestRunRateTeam = runRateList.stream().filter(list -> list.getYear() == year)
							.sorted((a,b) -> a.getRunRate()>b.getRunRate()?-1:
											 a.getRunRate()<b.getRunRate()?1:0)
							.collect(Collectors.toList());
		return highestRunRateTeam.get(0);
	}
	
	private double convertToExactOvers(double dOvers) {
		
		LOGGER.debug("Converting overs to exact : "+dOvers);
		String overs = String.format("%.1f",dOvers);
		
		//	 System.out.println(overs);
			String split[] = overs.split("\\.");
			double iOvers = Integer.parseInt(split[0]);
			double balls  = Integer.parseInt(split[1]);
			
			if(balls > 5) {
				iOvers++;
				balls-=6;
				iOvers += (0.1*balls);
			}
			else {
				iOvers += (0.1*balls);
			}
			LOGGER.debug("Returning exact overs as : "+iOvers);
			return iOvers;
	}
	
	/**
	 * 
	 * This service method is used to get the highest run rate team name 
	 * with respective to the year.
	 * @param list of deliveries which contains all the deliveries details.
	 * @param list of matches which contains all the matches details.
	 */
	@Override
	public List<CompleteRunRateDetail> getHighestRunRateTeamName(List<Deliveries> deliveries, List<Matches> matches) {
		
		List<CompleteRunRateDetail> finalRunRateList = new ArrayList<>();
		List<RunRateParameters> runRateParams = new ArrayList<>();
		
		double overI1=0;
		double overI2=0;
		double ballsI1=0;
		double ballsI2=0;
		String I1BattingTeam=null;
		String I2BattingTeam=null;
		int totalRunsI1=0;
		int totalRunsI2=0;
		
		for(Matches match : matches) 
		{
			int year = match.getSeason();
			int matchId = match.getMatchId();
			
			List<Deliveries> deliveriesForMatchId = iterateDeliveriesForMatchID(deliveries, matchId);
			
			List<Deliveries> firstInnings = deliveriesForMatchId.stream().filter(delivery -> delivery.getInning()==1)
																.collect(Collectors.toList());
			
			boolean updated1= false;
			boolean updated2= false;
			
			totalRunsI1 = firstInnings.stream()
										.map(d -> d.getTotalRuns())
										.collect(Collectors.summingInt(Integer::intValue));
			
			overI1 = firstInnings.get(firstInnings.size()-1).getOver() - 1;
			ballsI1 = firstInnings.get(firstInnings.size()-1).getBall();
			I1BattingTeam = firstInnings.get(0).getBattingTeam();
			
			overI1 = (ballsI1 > 5)? (overI1 + 1) : (overI1+(0.1*ballsI1));
			
//			LOGGER.debug(matchId+", "+I1BattingTeam+", "+overI1+", "+totalRunsI1+", RRI1: "+(totalRunsI1/overI1));
			
			List<Deliveries> secondInnings = deliveriesForMatchId.stream().filter(delivery -> delivery.getInning()==2)
																		  .collect(Collectors.toList());
			if(secondInnings.size() != 0) {
				totalRunsI2 = secondInnings.stream()
						.map(d -> d.getTotalRuns())
						.collect(Collectors.summingInt(Integer::intValue));
	
				overI2 = secondInnings.get(secondInnings.size()-1).getOver() - 1;
				ballsI2 = secondInnings.get(secondInnings.size()-1).getBall();
				I2BattingTeam = secondInnings.get(0).getBattingTeam();
				
				overI2 = (ballsI2 > 5)? (overI2 + 1) : (overI2+(0.1*ballsI2));
				
//				LOGGER.debug(matchId+", "+I2BattingTeam+", "+overI2+", "+totalRunsI2+", RRI2: "+(totalRunsI2/overI2));
			}
			for(int i=0;i<runRateParams.size();i++) {
				
				if(runRateParams.get(i).getYear()==year && runRateParams.get(i).getTeamName().equals(I1BattingTeam)) {
					updated1 = true;
					runRateParams.get(i).setTeamName(I1BattingTeam);
					runRateParams.get(i).setYear(year);
//					LOGGER.debug("I1B OLD OVER : "+runRateParams.get(i).getTotalOvers()+","+I1BattingTeam+","+year);
//					LOGGER.debug("I1B NEW OVER : "+overI1+","+I1BattingTeam+","+year);
					double cOvers = convertToExactOvers(runRateParams.get(i).getTotalOvers() + overI1);
//					LOGGER.debug("I1B UPDATED OVER : "+cOvers+","+I1BattingTeam+","+year);
					runRateParams.get(i).setTotalOvers(cOvers);
					runRateParams.get(i).setTotalRuns(runRateParams.get(i).getTotalRuns() + totalRunsI1);					
				}
				if(runRateParams.get(i).getYear()==year && runRateParams.get(i).getTeamName().equals(I2BattingTeam)) {
					updated2 = true;
					runRateParams.get(i).setTeamName(I2BattingTeam);
					runRateParams.get(i).setYear(year);
//					LOGGER.debug("I2B OLD OVER : "+runRateParams.get(i).getTotalOvers()+","+I2BattingTeam+","+year);
//					LOGGER.debug("I2B NEW OVER : "+overI2+","+I2BattingTeam+","+year);
					double cOvers = convertToExactOvers(runRateParams.get(i).getTotalOvers() + overI2);
//					LOGGER.debug("I2B UPDATED OVER : "+cOvers+","+I2BattingTeam+","+year);
					runRateParams.get(i).setTotalOvers(cOvers);
					runRateParams.get(i).setTotalRuns(runRateParams.get(i).getTotalRuns() + totalRunsI2);					
				}
			}
			
			if(updated1==false) {
				RunRateParameters rrp = new RunRateParameters();
				rrp.setYear(year);
				rrp.setTeamName(I1BattingTeam);
				rrp.setTotalOvers(overI1);
				rrp.setTotalRuns(totalRunsI1);
				runRateParams.add(rrp);
			}
			if(updated2==false) {
				RunRateParameters rrp = new RunRateParameters();
				rrp.setYear(year);
				rrp.setTeamName(I2BattingTeam);
				rrp.setTotalOvers(overI2);
				rrp.setTotalRuns(totalRunsI2);
				runRateParams.add(rrp);
			}
		}
	//	runRateParams.stream().forEach(LOGGER::debug);
		
		for(RunRateParameters runRateObj : runRateParams) {
			CompleteRunRateDetail crd = new CompleteRunRateDetail();
			crd.setYear(runRateObj.getYear());
			crd.setTeamName(runRateObj.getTeamName());
			double runrate = runRateObj.getTotalRuns()/runRateObj.getTotalOvers();
			crd.setRunRate(Double.parseDouble(String.format("%.2f", runrate)));
			finalRunRateList.add(crd);
		}
	//	finalRunRateList.stream().forEach(LOGGER::debug);
		
		Set<Integer> years = finalRunRateList.stream().map(CompleteRunRateDetail::getYear)
								 .collect(Collectors.toSet());
		
		List<CompleteRunRateDetail> highestRunRateTeamList = new ArrayList<>();
		
		years.stream().forEach(year -> {
			CompleteRunRateDetail highestRunRateForYear = getHighestRunRateForYear(finalRunRateList, year);
			highestRunRateTeamList.add(highestRunRateForYear);
		});
		
	//	highestRunRateTeamList.stream().forEach(LOGGER::debug);
		return highestRunRateTeamList;
	}

	/**
	 * This service method is used to calculate the fielding count 
	 * of the teams who won the toss and chooses to field by 
	 * year-wise.
	 * 
	 * @param matches the complete match details.
	 */
	@Override
	public List<CompleteFieldCountDetail> getFieldCountOfTeams(List<Matches> matches) {
		
		List<CompleteFieldCountDetail> finalList= new ArrayList<CompleteFieldCountDetail>();
	
		matches.stream().forEach(match-> {
							
							int year = match.getSeason();
							String tossResult = match.getTossDecision();
							String tossWinner = match.getTossWinner();
							boolean updated = false;
							
							for(int i=0; i<finalList.size(); i++) {
								
								if(tossResult.equals("field")) {
									if(finalList.get(i).getYear() == year && finalList.get(i).getTeamName().equals(tossWinner)) {
										updated = true;
										finalList.get(i).setYear(year);
										finalList.get(i).setTeamName(tossWinner);
										finalList.get(i).setFieldCount(finalList.get(i).getFieldCount() + 1);
									}									
								}
							}
							
							if(updated ==false && tossResult.equals("field")) {
							
								CompleteFieldCountDetail fieldDetails = new CompleteFieldCountDetail();
								fieldDetails.setYear(year);
								fieldDetails.setTeamName(tossWinner);
								fieldDetails.setFieldCount(1);
								finalList.add(fieldDetails);
							}
							
						}
				);
	//	finalList.stream().forEach(LOGGER::debug);
		
		//TOP 4 FIELD COUNT.
				
		return finalList.stream().sorted((a,b) -> a.getFieldCount()>b.getFieldCount()?-1:
									   a.getFieldCount()<b.getFieldCount()?1:0).limit(4).collect(Collectors.toList());
	//	return finalList;
	}
}
