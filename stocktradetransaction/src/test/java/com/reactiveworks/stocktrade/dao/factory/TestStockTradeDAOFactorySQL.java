package com.reactiveworks.stocktrade.dao.factory;

import static org.junit.Assert.assertEquals;
import java.sql.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.reactiveworks.stocktrade.dao.IStockTradeDAO;
import com.reactiveworks.stocktrade.dao.exception.OperationNotSupportedException;
import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.dao.factory.StockTradeDAOFactory;
import com.reactiveworks.stocktrade.exception.AccessFailureException;
import com.reactiveworks.stocktrade.exception.OperationFailureException;
import com.reactiveworks.stocktrade.pojo.StockTrade;

/**
 * A test class to check the implementation of the SQL implementation.
 * @author Elangovan
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestStockTradeDAOFactorySQL {

	 private static final Logger LOGGER = Logger.getLogger(TestStockTradeDAOFactorySQL.class);
	 
	  /**
	   * This test case is used to check the total number of rows fetched from database.
	   * Total value is 481 rows. Input this value and check with the fetched result.
	   * @throws OperationFailureException if operation perform lead to failure.
	   * @throws AccessFailureException  if any access in resource is failure
	   */
	  @Test
	  public void test1_totalRowsFetched() throws AccessFailureException, OperationFailureException, StockTradeInValidFormatException {
		  LOGGER.debug("Testing testTotalRowsFetched() method ");
		  IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance();
		  List<StockTrade> listOfTrades = dao.readAsList();
		  assertEquals(481, listOfTrades.size());
	  }
 
	  /**
	   * Used to check the insert function of DAO class. 
	   * @throws OperationNotSupportedException the operation is not supported for particular DAO
	   * @throws OperationFailureException if operation perform lead to failure.
	   * @throws AccessFailureException if any access in resource is failure
	   */
	  @Test
	  public void test2_checkInsert() throws AccessFailureException, OperationFailureException, OperationNotSupportedException {
		  
		  IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance();
		  StockTrade trade = new StockTrade();
		  trade.setSecurity("NORTON");
		  trade.setDate(Date.valueOf("2014-01-01"));
		  trade.setOpen(15.5);
		  trade.setHigh(16.224);
		  trade.setLow(15.2533);
		  trade.setClose(15.94323);
		  trade.setVolume(41105000d);
		  trade.setAdjClose(15.92);		
		  LOGGER.debug("Testing inserting data : "+trade);
		  assertEquals(1, dao.insert(trade));
	  }
  
	  /**
	   * Used to check the update function of the DAO class.
	   * @throws OperationNotSupportedException the operation is not supported for particular DAO
	   * @throws OperationFailureException if operation perform lead to failure.
	   * @throws AccessFailureException if any access in resource is failure
	   */
	  @Test
	  public void test3_checkUpdate() throws AccessFailureException, OperationFailureException, OperationNotSupportedException {
		  LOGGER.debug("Testing updating data.");
		  IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance();
		  int rows = dao.update(482, "AVAST");
		  assertEquals(1, rows);
	  }
	  
	  /**
	   * Used to check the delete function of the DAO class by passing the date.
	   * @throws OperationNotSupportedException the operation is not supported for particular DAO
	   * @throws OperationFailureException if operation perform lead to failure.
	   * @throws AccessFailureException if any access in resource is failure
	   */
	  @Test
	  public void test4_checkDelete() throws AccessFailureException, OperationFailureException, OperationNotSupportedException {
		  LOGGER.debug("Test deleting data.");
		  IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance();
		  int rows = dao.deleteById(482);
		  assertEquals(1, rows);
	  }
	  /**
	   * Used to check the function which reads entries for the specific date.
	   * @throws OperationFailureException if operation perform lead to failure.
	   * @throws AccessFailureException if any access in resource is failure
	   * 
	   */
	  @Test
	  public void test5_checkReadById() throws AccessFailureException, OperationFailureException, StockTradeInValidFormatException {
		  LOGGER.debug("Testing read by specific id.");
		  IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance();
		  StockTrade trade = dao.readById(123);
		  assertEquals(trade.getHigh(),Double.valueOf(24.780001));
	  }	  
}
