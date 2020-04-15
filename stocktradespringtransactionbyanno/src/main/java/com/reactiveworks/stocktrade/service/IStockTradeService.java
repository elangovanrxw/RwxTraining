package com.reactiveworks.stocktrade.service;

import java.util.List;
import com.reactiveworks.stocktrade.dao.exception.StockTradeDAOException;
import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.pojo.DailyTradingDifferential;
import com.reactiveworks.stocktrade.pojo.StockTrade;
import com.reactiveworks.stocktrade.service.exception.StockTradeServiceException;

/**
 * An interface which gives the structure of the business logic of the code.
 * @author Elangovan
 *
 */
public interface IStockTradeService {
	
	/**
	 * Reads stocktrade data from the database.
	 * @return a complete list of trades
	 * @throws StockTradeInValidFormatException if there is any error in any file formats.
	 * @throws StockTradeDAOException if any DAO operations leads to failure.
	 */
	public List<StockTrade> readStockTrades() throws StockTradeServiceException;
	
	/**
	 * Getting maximum trade happened from the list
	 * @param list complete list which is to be passed to find maximum trade.
	 * @return complete data of maximum trade present.
	 */
	public StockTrade getMaxVolumeTrade(List<StockTrade> list) throws StockTradeServiceException;
	
	/**
	 * Getting minimum trade happened from the list
	 * @param list complete list which is to be passed to find minimum trade.
	 * @return complete data of minimum trade present.
	 */
	public StockTrade getMinVolumeTrade(List<StockTrade> list) throws StockTradeServiceException;
	
	/**
	 * For getting the daily trading differential as map
	 * @param listcomplete list which is to be passed to find differences.
	 * @return a map of differences in the form of Date as key, difference as value.
	 */
	public List<DailyTradingDifferential> getDailyTradingDifferential(List<StockTrade> list) throws StockTradeServiceException;
	
	
}
