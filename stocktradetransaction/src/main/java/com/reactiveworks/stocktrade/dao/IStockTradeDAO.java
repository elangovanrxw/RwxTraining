package com.reactiveworks.stocktrade.dao;

import java.util.List;
import com.reactiveworks.stocktrade.dao.exception.OperationNotSupportedException;
import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.exception.AccessFailureException;
import com.reactiveworks.stocktrade.exception.OperationFailureException;
import com.reactiveworks.stocktrade.pojo.StockTrade;

/**
 * An interface which gives the structure of the Data Access Object.
 * @author Elangovan
 *
 */
public interface IStockTradeDAO {

	/**
	 * Insert the object into database.
	 * @param stockTrade business object for insertion.
	 * @return an integer which gives the number of rows updated in database.
	 * @throws AccessFailureException if any access in resource is failure.
	 * @throws OperationFailureException if operation perform lead to failure.
	 * @throws OperationNotSupportedException the operation is not supported for particular DAO.
	 */
	public int insert(StockTrade stockTrade) throws AccessFailureException, OperationFailureException, OperationNotSupportedException;

	/**
	 * Read the trade data for the given trade id.
	 * @param tradeId specific trade id.
	 * @return object of the stocktrade containing trade data.
	 * @throws AccessFailureException if any access in resource is failure.
	 * @throws OperationFailureException if operation perform lead to failure.
	 * @throws StockTradeInValidFormatException if any error in data format.
	 */
	public StockTrade readById(int tradeId) throws AccessFailureException, OperationFailureException, StockTradeInValidFormatException;

	/**
	 * Update the security by passing the value of tradeId.
	 * 
	 * @param tradeId the tradeId which is to be updated.
	 * @param security type of security need to be updated.
	 * @throws AccessFailureException if any access in resource is failure.
	 * @throws OperationFailureException if operation perform lead to failure.
	 * @throws OperationNotSupportedException the operation is not supported for particular DAO.
	 */
	public int update(int tradeId, String security) throws AccessFailureException, OperationFailureException, OperationNotSupportedException;

	/**
	 * Delete the entire row taking tradeId as a condition.
	 * @param tradeId delete occurs in this tradeId.
	 * @return number of rows deleted
	 * @throws AccessFailureException if any access in resource is failure.
	 * @throws OperationFailureException if operation perform lead to failure.
	 * @throws OperationNotSupportedException the operation is not supported for particular DAO.
	 */
	public int deleteById(int tradeId) throws AccessFailureException, OperationFailureException, OperationNotSupportedException;

	/**
	 * Reads the entire database and convert it to a {@link List}
	 * @return a list of all trades
	 * @throws AccessFailureException if any access in resource is failure.
	 * @throws OperationFailureException if operation perform lead to failure.
	 * @throws StockTradeInValidFormatException if any error in data format.
	 */
	public List<StockTrade> readAsList() throws AccessFailureException, OperationFailureException, StockTradeInValidFormatException;

}
