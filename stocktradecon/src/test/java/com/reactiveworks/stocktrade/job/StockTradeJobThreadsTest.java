package com.reactiveworks.stocktrade.job;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.exception.AccessFailureException;
import com.reactiveworks.stocktrade.exception.OperationFailureException;
import com.reactiveworks.stocktrade.job.impl.StockTradeJobThreadsImpl;
/**
 * A test class to check own threadpool implementation.
 * @author Elangovan
 *
 */
public class StockTradeJobThreadsTest {

	/**
	 * Test 1 - This method is used to test whether jobs 
	 * 			are assigned perfectly and insertion operation to 
	 * 			database is achieved successfully.
	 * @throws OperationFailureException  if any failure in perfoming some operations.
	 * @throws AccessFailureException	if any failure accessing any resources.
	 * @throws StockTradeInValidFormatException	if there is an error in any data format is wrong
	 */
	@Test
	public void test_checkJob() throws OperationFailureException, AccessFailureException, StockTradeInValidFormatException {
		new StockTradeJobThreadsImpl().doInsertionUsingThreads();
		assertTrue(true);
	}
}
