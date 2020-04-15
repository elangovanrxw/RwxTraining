package com.reactiveworks.stocktrade.reader.impl;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.*;

import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.exception.AccessFailureException;
import com.reactiveworks.stocktrade.exception.OperationFailureException;
import com.reactiveworks.stocktrade.pojo.StockTrade;
import com.reactiveworks.stocktrade.reader.impl.StockTradeReaderImpl;

/**
 * A test class to test the business logic of the code.
 * @author Elangovan
 *
 */
public class StockTradeReaderImplTest {

	private static final Logger LOGGER = Logger.getLogger(StockTradeReaderImpl.class);
	StockTradeReaderImpl reader = new StockTradeReaderImpl();
	ArrayList<StockTrade> list1 = new ArrayList<>();

	/**
	 * Test1 - to ensure that the difference is not negative.
	 * @throws StockTradeInValidFormatException if there is any error in data format.
	 * @throws AccessFailureException if access to any resource leads to a failure.
	 * @throws OperationFailureException if performing any operation on resource leads to failure.
	 */
	@Test
	public void testGetDailyTradingDifferential()
			throws StockTradeInValidFormatException, AccessFailureException, OperationFailureException {
		LOGGER.debug("Testing daily differential method.");
		list1 = (ArrayList<StockTrade>) reader.readStockTrades();
		double diff = 1d, difference = 0d;
		for (int i = 0; i < list1.size(); i++) {
			difference = list1.get(i).getHigh() - list1.get(i).getOpen();
			if (diff <= difference)
				assertTrue(false);
		}
	}

	/**
	 * Test 2 - Input the maximum value and check whether the code returns the same value.
	 * @throws StockTradeInValidFormatException if there is any error in data format.
	 * @throws AccessFailureException if access to any resource leads to a failure.
	 * @throws OperationFailureException if performing any operation on resource leads to failure.
	 */
	@Test
	public void testGetMaxVolumeTrade_forGetMax()
			throws StockTradeInValidFormatException, AccessFailureException, OperationFailureException {
		list1 = (ArrayList<StockTrade>) reader.readStockTrades();
		Double max = 2.432554E8;
		assertEquals(max, reader.getMaxVolumeTrade(list1).getVolume());
	}

	/**
	 * Test 3 - Input the minimum value and check whether the code returns the same value.
	 * @throws StockTradeInValidFormatException if there is any error in data format.
	 * @throws AccessFailureException if access to any resource leads to a failure.
	 * @throws OperationFailureException if performing any operation on resource leads to failure.
	 */
	@Test
	public void testGetMinVolumeTrade_forGetMin()
			throws StockTradeInValidFormatException, AccessFailureException, OperationFailureException {
		list1 = (ArrayList<StockTrade>) reader.readStockTrades();
		Double min = 1.25507E7;
		assertEquals(min, reader.getMinVolumeTrade(list1).getVolume());
	}

	/**
	 * Test 4 - Check how many fields/columns returning from database or file.
	 * @throws StockTradeInValidFormatException if there is any error in data format.
	 * @throws AccessFailureException if access to any resource leads to a failure.
	 * @throws OperationFailureException if performing any operation on resource leads to failure.
	 */
	@Test
	public void testReadStockTrades_1()
			throws StockTradeInValidFormatException, AccessFailureException, OperationFailureException {
		list1 = (ArrayList<StockTrade>) reader.readStockTrades();
		assertEquals(8, list1.get(2).toString().split(" ").length);
	}

}