package com.reactiveworks.cricketanalyzer.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.reactiveworks.cricketanalyzer.dao.IReaderDAO;
import com.reactiveworks.cricketanalyzer.dao.exception.FileAccessFailureException;
import com.reactiveworks.cricketanalyzer.dao.exception.FileOperationFailureException;
import com.reactiveworks.cricketanalyzer.dao.exception.InputFormatException;
import com.reactiveworks.cricketanalyzer.dao.factory.CricketDataReaderDAOFactory;
import com.reactiveworks.cricketanalyzer.pojo.Matches;

public class TestMatchesDAOCSVImpl {

	/**
	 * Implementation of the logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(TestMatchesDAOCSVImpl.class);
	
	/**
	 * Test 1 - This test is used to check whether the function is reading
	 * all matches data by checking its actual size with the list of matches
	 * we got after reading.
	 * @throws FileAccessFailureException if there is any accessing of file leads to failure.
	 * @throws FileOperationFailureException when performing operation on file leads to failure.
	 * @throws InputFormatException if any format mismatch occurs when parsing.
	 */
	@Test
	public void test1_checkAllMatchesAreReading() throws FileAccessFailureException, FileOperationFailureException, InputFormatException {
		LOGGER.debug("Test 1, Checking whether all the matches are reading.");
		IReaderDAO<Matches> dao =  CricketDataReaderDAOFactory.getMatchesInstance();
		List<Matches> matchesList = dao.readFromCSVFile();
		assertEquals(636, matchesList.size());
	}
	
	/**
	 * Test 2 - This test is used to check whether all the matches data
	 * from  the matches file are readable.
	 * @throws FileAccessFailureException if there is any accessing of file leads to failure.
	 * @throws FileOperationFailureException when performing operation on file leads to failure.
	 * @throws InputFormatException if any format mismatch occurs when parsing.
	 */
	@Test
	public void test2_checkMatchesDataAreReadable_first() throws FileAccessFailureException, FileOperationFailureException, InputFormatException {
		LOGGER.debug("Test 2, Checking whether matches data are readable - first element.");
		IReaderDAO<Matches> dao =  CricketDataReaderDAOFactory.getMatchesInstance();
		List<Matches> matchesList = dao.readFromCSVFile();
		assertEquals(matchesList.get(0).getCity(),"Hyderabad");
	}
	
	/**
	 * Test 3 - This test is used to check whether all the matches data
	 * from  the matches file are readable.
	 * @throws FileAccessFailureException if there is any accessing of file leads to failure.
	 * @throws FileOperationFailureException when performing operation on file leads to failure.
	 * @throws InputFormatException if any format mismatch occurs when parsing.
	 */
	@Test
	public void test3_checkMatchesDataAreReadable_middle() throws FileAccessFailureException, FileOperationFailureException, InputFormatException {
		LOGGER.debug("Test 3, Checking whether matches data are readable - middle element.");
		IReaderDAO<Matches> dao =  CricketDataReaderDAOFactory.getMatchesInstance();
		List<Matches> matchesList = dao.readFromCSVFile();
		assertEquals(matchesList.get(397).getWinner(),"Rajasthan Royals");
	}
	
	/**
	 * Test 4 - This test is used to check whether all the matches data
	 * from  the matches file are readable.
	 * @throws FileAccessFailureException if there is any accessing of file leads to failure.
	 * @throws FileOperationFailureException when performing operation on file leads to failure.
	 * @throws InputFormatException if any format mismatch occurs when parsing.
	 */
	@Test
	public void test4_checkMatchesDataAreReadable_middle() throws FileAccessFailureException, FileOperationFailureException, InputFormatException {
		LOGGER.debug("Test 4, Checking whether matches data are readable - last element.");
		IReaderDAO<Matches> dao =  CricketDataReaderDAOFactory.getMatchesInstance();
		List<Matches> matchesList = dao.readFromCSVFile();
		assertEquals(matchesList.get(matchesList.size()-1).getTossDecision(),"bat");
	}
}
