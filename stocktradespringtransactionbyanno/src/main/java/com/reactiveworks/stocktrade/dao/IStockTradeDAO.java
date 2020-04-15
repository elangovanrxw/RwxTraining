package com.reactiveworks.stocktrade.dao;

import java.util.List;
import com.reactiveworks.stocktrade.dao.exception.StockTradeDAOException;
import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.pojo.StockTrade;

/**
 * An interface which gives the structure of the Data Access Object.
 * @author Elangovan
 *
 */
public interface IStockTradeDAO {

	/**
	 * Reads the source and convert it to a {@link List}
	 * @return a list of all trades.
	 * @throws StockTradeInValidFormatException if any error in data format.
	 * @throws StockTradeDAOException if any DAO operations leads to failure.
	 */
	public List<StockTrade> getAllStockTrades() throws StockTradeInValidFormatException, StockTradeDAOException;
	
	/**
	 * Insert the object into database.
	 * @param stockTrade business object for insertion.
	 * @return an integer which gives the number of rows updated in database.
	 * @throws StockTradeDAOException if any DAO operations leads to failure.
	 */
	public int insertStockTrade(StockTrade stockTrade) throws StockTradeDAOException;

	/**
	 * Read the trade data for the given trade id.
	 * @param tradeId specific trade id.
	 * @return object of the stocktrade containing trade data.
	 * @throws StockTradeInValidFormatException if any error in data format.
	 * @throws StockTradeDAOException if any DAO operations leads to failure.
	 */
	public StockTrade getStockTradeById(int tradeId) throws StockTradeInValidFormatException, StockTradeDAOException;

	/**
	 * Delete the entire row taking tradeId as a condition.
	 * @param tradeId delete occurs in this tradeId.
	 * @return number of rows deleted
	 * @throws StockTradeDAOException if any DAO operations leads to failure.
	 */
	public int deleteStockTradeById(int tradeId) throws StockTradeDAOException;

	/**
	 * To update the security of the trade by passing the tradeId.
	 * @param tradeId for which the record needs to be updated.
	 * @param security new security which is to be updated.
	 * @return number of rows updated.
	 * @throws StockTradeDAOException if any DAO operations leads to failure.
	 */
	public int updateStockTradeSecurity(int tradeId, String security) throws StockTradeDAOException;

	/**
	 * To insert the data by batch operations into the database.
	 * @param list list of objects to insert into database.
	 * @param batchSize size of each batch.
	 * @return an array of int that contains the number of rows updated.
	 * @throws StockTradeDAOException if any DAO operations leads to failure.
	 */
	public int[] performBatchInsertStockTrade(List<StockTrade> list, int batchSize) throws StockTradeDAOException;
	
	/**
	 * A method to clean up(truncate) the database
	 * @throws StockTradeDAOException if any DAO operations leads to failure.
	 */
	public void cleanUp() throws StockTradeDAOException;
}
