package com.reactiveworks.stocktrade.dao.factory;

import static org.junit.Assert.assertEquals;
import java.util.List;
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
	 * Test 1 - Checking whether all the data is being read from CSV file.
	 * @throws OperationFailureException if operation perform lead to failure.
	 * @throws AccessFailureException if any access in resource is failure
	 * @throws StockTradeInValidFormatException if incorrect format in data.
	 */
	@Test
	public void test1_checkReadAsList() throws AccessFailureException, OperationFailureException, StockTradeInValidFormatException 
	{
		IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance();
		List<StockTrade> stockList = dao.readAsList();
		assertEquals(481, stockList.size());
	}
	
	/**
	 * Test 2 - By passing the specific date fetch the data.
	 * @throws OperationFailureException if operation perform lead to failure.
	 * @throws AccessFailureException if any access in resource is failure
	 * @throws StockTradeInValidFormatException if incorrect format in data.
	 */
	@Test
	public void test2_checkReadByDate() throws AccessFailureException, OperationFailureException, StockTradeInValidFormatException {
		IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance();
		StockTrade trade = dao.readById(123);
		System.out.println(trade);
	}
	
	/**
	 * Test 3 - checking update with CSV implementation, expected to throw exception.
	 * @throws OperationFailureException if operation perform lead to failure.
	 * @throws AccessFailureException if any access in resource is failure
	 * @throws OperationNotSupportedException the operation is not supported for particular DAO
	 */
	@Test(expected=OperationNotSupportedException.class)
	public void test3_checkUpdate() throws OperationFailureException, AccessFailureException, OperationNotSupportedException {
		IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance();
		dao.update(12, "NORTON");
	}
	
	/**
	 * Test 4 - checking insert with CSV implementation, expected to throw exception.
	 * @throws OperationFailureException if operation perform lead to failure.
	 * @throws AccessFailureException if any access in resource is failure
	 * @throws OperationNotSupportedException the operation is not supported for particular DAO
	 */
	@Test(expected=OperationNotSupportedException.class)
	public void test4_checkInsert() throws OperationFailureException, AccessFailureException, OperationNotSupportedException {
		IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance();
		dao.insert(new StockTrade());
	}
	
	/**
	 * Test 5 - checking delete with CSV implementation, expected to throw exception.
	 * @throws OperationFailureException if operation perform lead to failure.
	 * @throws AccessFailureException if any access in resource is failure
	 * @throws OperationNotSupportedException the operation is not supported for particular DAO
	 */
	@Test(expected=OperationNotSupportedException.class)
	public void test5_checkDeleteById() throws OperationFailureException, AccessFailureException, OperationNotSupportedException {
		IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance();
		dao.deleteById(1);
	}
}
