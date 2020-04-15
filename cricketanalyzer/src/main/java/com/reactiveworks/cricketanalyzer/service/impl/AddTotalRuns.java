package com.reactiveworks.cricketanalyzer.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.reactiveworks.cricketanalyzer.dao.IReaderDAO;
import com.reactiveworks.cricketanalyzer.dao.exception.FileAccessFailureException;
import com.reactiveworks.cricketanalyzer.dao.exception.FileOperationFailureException;
import com.reactiveworks.cricketanalyzer.dao.exception.InputFormatException;
import com.reactiveworks.cricketanalyzer.dao.factory.CricketDataReaderDAOFactory;
import com.reactiveworks.cricketanalyzer.pojo.Deliveries;
import com.reactiveworks.cricketanalyzer.pojo.Matches;

public class AddTotalRuns {

	public static final String TEAM_NAME ="Gujarat Lions";
	
	public static final int YEAR =2017;
	
	public static final Logger LOGGER = Logger.getLogger(AddTotalRuns.class);
	
	public static void main(String[] args) throws FileAccessFailureException, FileOperationFailureException, InputFormatException {
		
		IReaderDAO<Deliveries> daoDelivery =  CricketDataReaderDAOFactory.getDeliveryInstance();
		List<Deliveries> deliveriesList = daoDelivery.readFromCSVFile();
		
		IReaderDAO<Matches> daoMatches =  CricketDataReaderDAOFactory.getMatchesInstance();
		List<Matches> matchesList = daoMatches.readFromCSVFile();

		
		int fourCount=0;
		int sixCount=0;
		int totalRuns=0;
		
		List<Integer> matchIds = matchesList.stream().filter(m -> m.getSeason()==YEAR)
				.map(match -> match.getMatchId()).collect(Collectors.toList());
		
		System.out.println(matchIds);
		
		for(int i=0;i <matchIds.size();i++) {
			
			int matchid = matchIds.get(i);
			List<Deliveries> collect = deliveriesList.stream().filter(d -> d.getMatchId()==matchid && d.getBattingTeam().equals(TEAM_NAME))
							.collect(Collectors.toList());
			
			if(collect.size() != 0) {
				
				int fc = (int)collect.stream().filter(c -> c.getBatsmanRuns()==4).count();
								
				int sc = (int)collect.stream().filter(c -> c.getBatsmanRuns()==6).count();
						
				int tr = collect.stream().map(c -> c.getTotalRuns())
								.collect(Collectors.summingInt(Integer::intValue));
				
				fourCount += fc;
				sixCount += sc;
				totalRuns += tr;
				System.out.println(YEAR+","+matchid+","+TEAM_NAME+","+fc+","+sc+","+tr);
			}	
		}
		System.out.println();
	System.out.println(YEAR +","+TEAM_NAME+","+fourCount+","+sixCount+","+totalRuns);
}
}
