package com.reactiveworks.stocktrade.reader;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.exception.AccessFailureException;
import com.reactiveworks.stocktrade.exception.OperationFailureException;
import com.reactiveworks.stocktrade.pojo.StockTrade;

/**
 * An interface which gives the structure of the business logic of the code.
 * @author Elangovan
 *
 */
public interface IStockTradeReader {
	
	/**
	 * Reads stocktrade data from the database.
	 * @return a complete list of trades
	 * @throws AccessFailureException if there is any failure when accessing any resource.
	 * @throws OperationFailureException if there is any failure when 
	 * performing operations on any resource.
	 * @throws StockTradeInValidFormatException if there is any error in any file formats.
	 */
	public List<StockTrade> readStockTrades() throws AccessFailureException, OperationFailureException, StockTradeInValidFormatException;
	
	/**
	 * Getting maximum trade happened from the list
	 * @param list complete list which is to be passed to find maximum trade.
	 * @return complete data of maximum trade present.
	 */
	public StockTrade getMaxVolumeTrade(List<StockTrade> list);
	
	/**
	 * Getting minimum trade happened from the list
	 * @param list complete list which is to be passed to find minimum trade.
	 * @return complete data of minimum trade present.
	 */
	public StockTrade getMinVolumeTrade(List<StockTrade> list);
	
	/**
	 * For getting the daily trading differential as map
	 * @param listcomplete list which is to be passed to find differences.
	 * @return a map of differences in the form of Date as key, difference as value.
	 */
	public Map<Date,Double> getDailyTradingDifferential(List<StockTrade> list);
	
	
}
