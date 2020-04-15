package com.reactiveworks.stocktrade.dao;

import java.util.List;
import com.reactiveworks.stocktrade.dao.exception.OperationNotSupportedException;
import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.db.exception.DatabaseAccessFailureException;
import com.reactiveworks.stocktrade.db.exception.DatabaseOperationFailureException;
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
	 * Reads the source and convert it to a {@link List}
	 * @return a list of all trades
	 * @throws AccessFailureException if any access in resource is failure.
	 * @throws OperationFailureException if operation perform lead to failure.
	 * @throws StockTradeInValidFormatException if any error in data format.
	 */
	public List<StockTrade> getAllStockTrades() throws AccessFailureException, OperationFailureException, StockTradeInValidFormatException;
	
	/**
	 * Insert the data into database.
	 * @return number of rows modified.
	 * @throws DatabaseAccessFailureException if any access in database is failure.
	 * @throws DatabaseOperationFailureException if operation performing in database lead to failure.
	 * @throws OperationNotSupportedException in case if this not supported.
	 */
	public int insertStockTrade(StockTrade trade) throws OperationNotSupportedException, DatabaseAccessFailureException, DatabaseOperationFailureException;
	
	/**
	 * This method is used to truncate the database.
	 * @throws OperationNotSupportedException if the operation is not supported.
	 * @throws DatabaseAccessFailureException if any failure when accessing the database.
	 * @throws DatabaseOperationFailureException if any failure when performing operation database.
	 */
	public void cleanUp() throws OperationNotSupportedException, DatabaseAccessFailureException, DatabaseOperationFailureException;

}
