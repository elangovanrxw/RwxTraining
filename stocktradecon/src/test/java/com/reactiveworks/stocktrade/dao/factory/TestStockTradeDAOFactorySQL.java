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
		  IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance("sql");
		  List<StockTrade> listOfTrades = dao.getAllStockTrades();
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
		  
		  IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance("sql");
		  StockTrade trade = new StockTrade();
		  trade.setSecurity("NORTON");
		  trade.setDate(Date.valueOf("2014-01-01"));
		  trade.setOpen(15.5);
		  trade.setHigh(16.224);
		  trade.setLow(15.2533);
		  trade.setClose(15.94323);
		  trade.setVolume(41105000d);
		  trade.setAdjClose(15.92);		
		  LOGGER.debug("Testing inserting data...");
		  assertEquals(1, dao.insertStockTrade(trade));
	  }
}
