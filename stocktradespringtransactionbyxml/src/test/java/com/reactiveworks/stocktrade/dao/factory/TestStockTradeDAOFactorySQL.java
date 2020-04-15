package com.reactiveworks.stocktrade.dao.factory;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.reactiveworks.stocktrade.StockTradeApplication;
import com.reactiveworks.stocktrade.dao.IStockTradeDAO;
import com.reactiveworks.stocktrade.dao.exception.StockTradeDAOException;
import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.exception.StockTradeSpringException;
import com.reactiveworks.stocktrade.pojo.StockTrade;

/**
 * A test class to check the implementation of the SQL implementation.
 * @author Elangovan
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestStockTradeDAOFactorySQL {

	 private static final Logger LOGGER = Logger.getLogger(TestStockTradeDAOFactorySQL.class);
	 
	 private static ApplicationContext context;
	 /**
	  * Starting the spring container.
	  * @throws SpringException In case the application is not able to start the spring container.
	  */
	 @BeforeClass
	 public static void executeStart() throws StockTradeSpringException {
		context = StockTradeApplication.startAndGetContext();
	 }
	 
	 @AfterClass
	 public static void closeContainer() throws StockTradeSpringException {
		StockTradeApplication.closeContainer(context);
	 }
	  /**
	   * Test 4 - This test case is used to check the total number of rows fetched from database.
	   * Total value is 484 rows. Input this value and check with the fetched result.
	   * @throws StockTradeDAOException if any DAO operations leads to failure.
	   * @throws StockTradeInValidFormatException if any error in the data format.
	   */
	  @Test
	  public void test1_totalRowsFetched() throws StockTradeInValidFormatException, StockTradeDAOException {
		  LOGGER.debug("Testing testTotalRowsFetched() method ");
		  IStockTradeDAO dao = (IStockTradeDAO) context.getBean("daoInstance");
		  List<StockTrade> listOfTrades = dao.getAllStockTrades();
		  assertEquals(481, listOfTrades.size());
	  }
 
	  /**
	   * Test 4 - Used to check the insert function of DAO class. 
	   * @throws StockTradeDAOException if any DAO operations in database leads to failure.
	   */
	  @Test
	  public void test2_checkInsert() throws StockTradeDAOException {
		  
		  IStockTradeDAO dao = (IStockTradeDAO) context.getBean("daoInstance");
		  StockTrade trade = new StockTrade();
		  trade.setTradeId(482);
		  trade.setSecurity("NORTON");
		  trade.setDate(Date.valueOf("2014-04-04").toLocalDate());
		  trade.setOpen(45.5);
		  trade.setHigh(46.444);
		  trade.setLow(45.4544);
		  trade.setClose(45.94444);
		  trade.setVolume(44405000d);
		  trade.setAdjClose(45.94);		
		  LOGGER.debug("Testing inserting data : "+trade);
		  assertEquals(1, dao.insertStockTrade(trade));
	  }
  
	  /**
	   * Test 4 - Used to check the update function of the DAO class.
	   * @throws StockTradeDAOException if any DAO operations leads to failure.
	   */
	  @Test
	  public void test3_checkUpdate() throws StockTradeDAOException {
		  LOGGER.debug("Testing updating data.");
		  IStockTradeDAO dao = (IStockTradeDAO) context.getBean("daoInstance");
		  int rows = dao.updateStockTradeSecurity(482, "AVAST");
		  assertEquals(1, rows);
	  }
	  
	  /**
	   * Test 4 - Used to check the delete function of the DAO class by passing the date.
	   * @throws StockTradeDAOException  if any DAO operations leads to failure.
	   */
	  @Test
	  public void test4_checkDelete() throws StockTradeDAOException {
		  LOGGER.debug("Test deleting data.");
		  IStockTradeDAO dao = (IStockTradeDAO) context.getBean("daoInstance");
		  int rows = dao.deleteStockTradeById(482);
		  assertEquals(1, rows);
	  }
	  
	  /**
	   * Test 5 - Used to check the function which reads entries for the specific date.
	   * @throws StockTradeInValidFormatException if any error in the data format.
	   * @throws StockTradeDAOException  if any DAO operations leads to failure.
	   * 
	   */
	  @Test
	  public void test5_checkReadById() throws StockTradeInValidFormatException, StockTradeDAOException {
		  LOGGER.debug("Testing read by specific id.");
		  IStockTradeDAO dao = (IStockTradeDAO) context.getBean("daoInstance");
		  StockTrade trade = dao.getStockTradeById(124);
		  assertEquals(trade.getHigh(),Double.valueOf(24.780001));
	  }
	  
	  /**
	   * Test 6 - Used to check the batch operations that is to be performed on the database.
	   * We are manually creating a list with 4 stock trade instances and we are
	   * checking whether that 4 data are successfully inserted on the database
	   * as batch operations.
	   * @throws StockTradeDAOException  if any DAO operations leads to failure.
	   */
	  @Test
	  public void test6_checkBatchOperations() throws StockTradeDAOException {
		  LOGGER.debug("Testing batch operations function...");
		  IStockTradeDAO dao = (IStockTradeDAO) context.getBean("daoInstance");
		  List<StockTrade> list = new ArrayList<StockTrade>();
		  	StockTrade trade1 = new StockTrade();
		  	trade1.setTradeId(483);
			trade1.setSecurity("SYMANTEC");
			trade1.setDate(LocalDate.now()); 
			trade1.setOpen(11.489999);					
			trade1.setHigh(11.440001);
			trade1.setLow(11.100001);
			trade1.setClose(11.15);
			trade1.setVolume(15044700d);
			trade1.setAdjClose(19.470891);
			list.add(trade1);
			
			StockTrade trade2 = new StockTrade();
		  	trade2.setTradeId(484);
			trade2.setSecurity("SYMANTEC");
			trade2.setDate(LocalDate.now()); 
			trade2.setOpen(22.289999);					
			trade2.setHigh(22.220002);
			trade2.setLow(22.200002);
			trade2.setClose(22.25);
			trade2.setVolume(25022700d);
			trade2.setAdjClose(29.270892);
			list.add(trade2);
			
			StockTrade trade3 = new StockTrade();
		  	trade3.setTradeId(485);
			trade3.setSecurity("SYMANTEC");
			trade3.setDate(LocalDate.now()); 
			trade3.setOpen(33.389999);					
			trade3.setHigh(33.330003);
			trade3.setLow(33.300003);
			trade3.setClose(33.35);
			trade3.setVolume(35033700d);
			trade3.setAdjClose(39.370893);
			list.add(trade3);
			
			StockTrade trade4 = new StockTrade();
		  	trade4.setTradeId(485);
			trade4.setSecurity("SYMANTEC");
			trade4.setDate(LocalDate.now()); 
			trade4.setOpen(44.489999);					
			trade4.setHigh(44.440004);
			trade4.setLow(44.400004);
			trade4.setClose(44.45);
			trade4.setVolume(45044700d);
			trade4.setAdjClose(49.470894);
			list.add(trade4);
						
			dao.performBatchInsertStockTrade(list,2);
			
	  }
}
