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
import com.reactiveworks.cricketanalyzer.pojo.Deliveries;

/**
 * A Test class to test the implementation of the interface in
 * the deliveries file.
 * @author Elangovan
 *
 */
public class TestDeliveriesDAOCSVImpl {

	/**
	 * Implementation of the logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(TestDeliveriesDAOCSVImpl.class);
	
	/**
	 * Test 1 - This test is used to check whether the function is reading
	 * all deliveries data by checking its actual size with the list of deliveries
	 * we got after reading.
	 * @throws FileAccessFailureException if there is any accessing of file leads to failure.
	 * @throws FileOperationFailureException when performing operation on file leads to failure.
	 * @throws InputFormatException if any format mismatch occurs when parsing.
	 */
	@Test
	public void test1_checkIfAllDeliveriesAreReading() throws FileAccessFailureException, FileOperationFailureException, InputFormatException {
		LOGGER.debug("Test 1, Checking whether all the deliveries are reading.");
		IReaderDAO<Deliveries> dao =  CricketDataReaderDAOFactory.getDeliveryInstance();
		List<Deliveries> deliveriesList = dao.readFromCSVFile();
		assertEquals(150460,deliveriesList.size());
	}
	
	/**
	 * Test 2 - This test is used to check whether all the deliveries data
	 * from  the deliveries file are readable.
	 * @throws FileAccessFailureException if there is any accessing of file leads to failure.
	 * @throws FileOperationFailureException when performing operation on file leads to failure.
	 * @throws InputFormatException if any format mismatch occurs when parsing.
	 */
	@Test
	public void test2_checkDeliveriesDataAreReadable_first() throws FileAccessFailureException, FileOperationFailureException, InputFormatException {
		LOGGER.debug("Test 2, Checking whether deliveries data are readable - first element.");
		IReaderDAO<Deliveries> dao =  CricketDataReaderDAOFactory.getDeliveryInstance();
		List<Deliveries> deliveriesList = dao.readFromCSVFile();
		assertEquals(deliveriesList.get(0).getBattingTeam(),"Sunrisers Hyderabad");
	}
	
	/**
	 * Test 3 - This test is used to check whether all the deliveries data
	 * from  the deliveries file are readable.
	 * @throws FileAccessFailureException if there is any accessing of file leads to failure.
	 * @throws FileOperationFailureException when performing operation on file leads to failure.
	 * @throws InputFormatException if any format mismatch occurs when parsing.
	 */
	@Test
	public void test3_checkDeliveriesDataAreReadable_middle() throws FileAccessFailureException, FileOperationFailureException, InputFormatException {
		LOGGER.debug("Test 3, Checking whether deliveries data are readable - middle element.");
		IReaderDAO<Deliveries> dao =  CricketDataReaderDAOFactory.getDeliveryInstance();
		List<Deliveries> deliveriesList = dao.readFromCSVFile();
		assertEquals(deliveriesList.get(77576).getBowler(),"MN Samuels");
	}
	
	/**
	 * Test 4 - This test is used to check whether all the deliveries data
	 * from  the deliveries file are readable.
	 * @throws FileAccessFailureException if there is any accessing of file leads to failure.
	 * @throws FileOperationFailureException when performing operation on file leads to failure.
	 * @throws InputFormatException if any format mismatch occurs when parsing.
	 */
	@Test
	public void test4_checkDeliveriesDataAreReadable_last() throws FileAccessFailureException, FileOperationFailureException, InputFormatException {
		LOGGER.debug("Test 3, Checking whether deliveries data are readable - last element.");
		IReaderDAO<Deliveries> dao =  CricketDataReaderDAOFactory.getDeliveryInstance();
		List<Deliveries> deliveriesList = dao.readFromCSVFile();
		assertEquals(deliveriesList.get(deliveriesList.size()-1).getBatsman(),"Iqbal Abdulla");
	}
	
}
