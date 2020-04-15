package com.reactiveworks.cricketanalyzer.service.impl;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.reactiveworks.cricketanalyzer.dao.IReaderDAO;
import com.reactiveworks.cricketanalyzer.dao.exception.FileAccessFailureException;
import com.reactiveworks.cricketanalyzer.dao.exception.FileOperationFailureException;
import com.reactiveworks.cricketanalyzer.dao.exception.InputFormatException;
import com.reactiveworks.cricketanalyzer.dao.factory.CricketDataReaderDAOFactory;
import com.reactiveworks.cricketanalyzer.pojo.CompleteFieldCountDetail;
import com.reactiveworks.cricketanalyzer.pojo.CompleteRunRateDetail;
import com.reactiveworks.cricketanalyzer.pojo.CompleteScoreDetail;
import com.reactiveworks.cricketanalyzer.pojo.Deliveries;
import com.reactiveworks.cricketanalyzer.pojo.Matches;

public class TestCricketServiceImpl {

	/**
	 * Logger implementation for the test class.
	 */
	private static final Logger LOGGER = Logger.getLogger(TestCricketServiceImpl.class);
	

	/**
	 * Test 1 - This is used to test the first service method by collecting all the
	 * 			score details year wise with respect to teams.
	 * @throws FileAccessFailureException if there is any accessing of file leads to failure.
	 * @throws FileOperationFailureException when performing operation on file leads to failure.
	 * @throws InputFormatException if any format mismatch occurs when parsing.
	 */
	@Test
	public void test1_TestGetScoreDetails() throws FileAccessFailureException, FileOperationFailureException, InputFormatException {
		
		IReaderDAO<Deliveries> daoDelivery =  CricketDataReaderDAOFactory.getDeliveryInstance();
		List<Deliveries> deliveriesList = daoDelivery.readFromCSVFile();
		
		IReaderDAO<Matches> daoMatches =  CricketDataReaderDAOFactory.getMatchesInstance();
		List<Matches> matchesList = daoMatches.readFromCSVFile();
		
		CricketServiceImpl impl = new CricketServiceImpl();
		long stTime = System.currentTimeMillis();
		
		List<CompleteScoreDetail> scoreDetails = impl.getScoreDetails(deliveriesList, matchesList);
		long endTime = System.currentTimeMillis();
		LOGGER.info("Method getScoreDetails() Completed in :"+(endTime-stTime));
		
		LOGGER.debug("SCORE DETAILS LIST SIZE : "+scoreDetails.size());
		
		scoreDetails.stream().forEach(LOGGER::debug);
		
		int totalScore = scoreDetails.stream().map(CompleteScoreDetail::getTotalScore)
					.collect(Collectors.summingInt(Integer::intValue));
		
		LOGGER.debug("TOTAL ALL SCORES : "+totalScore);
		
	//	scoreDetails.stream().map(m -> m.getTotalScore())
	//						 .forEach(LOGGER::debug);
	}
	
	/**
	 * Test 2 - This is used to test the second service method by collecting all the
	 * 			highest run rate details of the teams, year wise.
	 * @throws FileAccessFailureException if there is any accessing of file leads to failure.
	 * @throws FileOperationFailureException when performing operation on file leads to failure.
	 * @throws InputFormatException if any format mismatch occurs when parsing.
	 */
	@Test
	public void test2_TestGetHighestRunRateTeamName() throws FileAccessFailureException, FileOperationFailureException, InputFormatException {
		IReaderDAO<Deliveries> daoDelivery =  CricketDataReaderDAOFactory.getDeliveryInstance();
		List<Deliveries> deliveriesList = daoDelivery.readFromCSVFile();
		
		IReaderDAO<Matches> daoMatches =  CricketDataReaderDAOFactory.getMatchesInstance();
		List<Matches> matchesList = daoMatches.readFromCSVFile();
		
		CricketServiceImpl impl = new CricketServiceImpl();
		long stTime = System.currentTimeMillis();
		List<CompleteRunRateDetail> highestRunRateDetails = impl.getHighestRunRateTeamName(deliveriesList, matchesList);
		long endTime = System.currentTimeMillis();
		LOGGER.info("Method getHighestRunRateTeamName() Completed in :"+(endTime-stTime));
		
		LOGGER.debug("HIGHEST RUN RATE LIST SIZE: "+highestRunRateDetails.size());
		highestRunRateDetails.stream().forEach(LOGGER::debug);
	}
	
	/**
	 * Test 3 - This is used to test the third service method by collecting all the
	 * 			counts of the teams who won the toss and chooses to field, year wise.
	 * @throws FileAccessFailureException if there is any accessing of file leads to failure.
	 * @throws FileOperationFailureException when performing operation on file leads to failure.
	 * @throws InputFormatException if any format mismatch occurs when parsing.
	 */
	@Test
	public void test3_TestGetFieldCountOfTeams() throws FileAccessFailureException, FileOperationFailureException, InputFormatException {
		IReaderDAO<Matches> daoMatches =  CricketDataReaderDAOFactory.getMatchesInstance();
		List<Matches> matchesList = daoMatches.readFromCSVFile();
		
		CricketServiceImpl impl = new CricketServiceImpl();
		long stTime = System.currentTimeMillis();
		List<CompleteFieldCountDetail> fieldCountDetails = impl.getFieldCountOfTeams(matchesList);
		long endTime = System.currentTimeMillis();
		LOGGER.info("Method getFieldCountOfTeams() Completed in :"+(endTime-stTime));
		LOGGER.debug("FIELD COUNT LIST SIZE : "+fieldCountDetails.size());
		fieldCountDetails.stream().forEach(LOGGER::debug);
	}

}
