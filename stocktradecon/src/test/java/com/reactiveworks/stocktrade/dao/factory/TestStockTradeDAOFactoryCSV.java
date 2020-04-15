package com.reactiveworks.stocktrade.dao.factory;

import static org.junit.Assert.assertEquals;
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
 * A test class to check the implementation of the CSV implementation.
 * @author Elangovan
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)		// to execute test methods in alphabetic order.
public class TestStockTradeDAOFactoryCSV {

	/**
	 * Implementation of the Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(TestStockTradeDAOFactoryCSV.class);
	
	/**
	 * Test 1 - checking insert with CSV implementation, expected to throw exception.
	 * @throws OperationFailureException if operation perform lead to failure.
	 * @throws AccessFailureException if any access in resource is failure
	 * @throws OperationNotSupportedException the operation is not supported for particular DAO
	 */
	@Test(expected=OperationNotSupportedException.class)
	public void test1_checkInsert() throws OperationFailureException, AccessFailureException, OperationNotSupportedException {
		LOGGER.debug("Testing Insert method of CSV implementation...");
		IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance("csv");
		dao.insertStockTrade(new StockTrade());
	}
	
	
	/**
	 * Test 2 - Reading from the CSV File.
	 * @throws OperationFailureException if operation perform lead to failure.
	 * @throws AccessFailureException if any access in resource is failure
	 * @throws OperationNotSupportedException the operation is not supported for particular DAO
	 * @throws StockTradeInValidFormatException if there is error in any format.
	 */
	@Test
	public void test2_checkReadData() throws OperationFailureException, AccessFailureException, OperationNotSupportedException, StockTradeInValidFormatException {
		LOGGER.debug("Testing Read data method of CSV implementation...");
		IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance("csv");
		List<StockTrade> tradeList = dao.getAllStockTrades();
		LOGGER.debug("After reading all data, total size of list : "+tradeList.size());
		for(StockTrade trade : tradeList)
			System.out.println(trade);
	}
	
	
}
