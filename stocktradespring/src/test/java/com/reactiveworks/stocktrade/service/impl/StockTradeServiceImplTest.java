package com.reactiveworks.stocktrade.service.impl;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import com.reactiveworks.stocktrade.application.StockTradeApplication;
import com.reactiveworks.stocktrade.dao.exception.StockTradeDAOException;
import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.dao.exception.StockTradeSpringException;
import com.reactiveworks.stocktrade.pojo.DailyTradingDifferential;
import com.reactiveworks.stocktrade.pojo.StockTrade;
import com.reactiveworks.stocktrade.service.IStockTradeService;
import com.reactiveworks.stocktrade.service.exception.NullValueOccurenceException;
import com.reactiveworks.stocktrade.service.exception.StockTradeServiceException;

/**
 * A test class to test the business logic of the code.
 * @author Elangovan
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)	// to execute the test case methods in alphabetic order
public class StockTradeServiceImplTest {

	/**
	 * Implementation of the Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(StockTradeServiceImplTest.class);
	
	/**
	 * Application context to get the service class object
	 * which spring has created and maintained.
	 */
	private static ApplicationContext context;
	
	/**
	 * Starting the spring container.
	 * @throws SpringException In case the application is not able to start the spring container.
	 */
	@BeforeClass
	public static void startApplication() throws StockTradeSpringException {
		context = StockTradeApplication.startAndGetContext();
	}
	
	/**
	 *  Test 1 - This method is used to check whether it is reading all the data from the
	 *  file and we are checking the size of the returned list.
	 *  @throws ServiceException if any service class operations leads to failure.
	 */
	@Test
	public void test1_checkReadAllStockTrades() throws StockTradeServiceException {
		LOGGER.debug("Testing readAllStockTrades() method..");
		IStockTradeService service = (IStockTradeService) context.getBean("service");
		List<StockTrade>list1 = service.readStockTrades();		
		assertEquals(481, list1.size());
	}
	
	/**
	 * Test 2 - Input the maximum value and check whether the code returns the same value.
	 * @throws StockTradeInValidFormatException if there is any error in data format.
	 * @throws StockTradeDAOException if any DAO operations leads to failure.
	 */
	@Test
	public void test2_checkGetMaxVolumeTrade() throws StockTradeServiceException {
			
		LOGGER.debug("Testing getMaxVolumeTrade() method..");
		IStockTradeService service = (IStockTradeService) context.getBean("service");
		List<StockTrade> list1 = service.readStockTrades();
		StockTrade tradeObj = service.getMaxVolumeTrade(list1);
		LOGGER.debug("MAX TRADE : "+tradeObj);
		Double max = 2.432554E8;
		assertEquals(max, tradeObj.getVolume());
	}

	/**
	 * Test 3 - Input the minimum value and check whether the code returns the same value.
	 * @throws StockTradeInValidFormatException if there is any error in data format.
	 * @throws StockTradeDAOException if any DAO operations leads to failure.
	 */
	@Test
	public void test3_checkGetMinVolumeTrade() throws StockTradeServiceException {
		LOGGER.debug("Testing getMinVolumeTrade() method..");
		IStockTradeService service = (IStockTradeService) context.getBean("service");
		List<StockTrade> list1 = service.readStockTrades();
		StockTrade tradeObj = service.getMinVolumeTrade(list1);
		LOGGER.debug("MIN TRADE : "+tradeObj);
		Double min = 1.25507E7;
		assertEquals(min, tradeObj.getVolume());
	}

	/**
	 * Test 4 - This method is used to test the trading differential method and 
	 * @throws StockTradeInValidFormatException if there is any error in data format.
	 * @throws StockTradeDAOException if any DAO operations leads to failure.
	 */
	@Test
	public void test4_checkGetDailyTradingDifferential() throws StockTradeServiceException {
		LOGGER.debug("Testing getDailyTradingDifferential() method..");
		IStockTradeService service = (IStockTradeService) context.getBean("service");
		List<StockTrade>list1 = service.readStockTrades();
		List<DailyTradingDifferential> differentialList = service.getDailyTradingDifferential(list1);
	//	differentialList.stream().forEach(LOGGER::debug);
		
	}
	
	@Test(expected=NullValueOccurenceException.class)
	public void test5_checkIfNullValueHandled() throws StockTradeServiceException {
		LOGGER.debug("Testing NullValueException..");
		IStockTradeService service = (IStockTradeService) context.getBean("service");
		List<StockTrade> list1 = service.readStockTrades();
		list1.add(null);
		service.getMaxVolumeTrade(list1);
	}

}