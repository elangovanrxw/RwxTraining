package com.reactiveworks.stocktrade.reader.impl;


import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import com.reactiveworks.stocktrade.dao.IStockTradeDAO;
import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.dao.factory.StockTradeDAOFactory;
import com.reactiveworks.stocktrade.exception.AccessFailureException;
import com.reactiveworks.stocktrade.exception.OperationFailureException;
import com.reactiveworks.stocktrade.pojo.StockTrade;
import com.reactiveworks.stocktrade.reader.IStockTradeReader;

/**
 * A class implementing the service methods for 
 * business logic to do the required operations.
 * @author Elangovan
 *
 */
public class StockTradeReaderImpl  implements IStockTradeReader{

	/**
	 * Implementation of Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(StockTradeReaderImpl.class);

	/**
	 * A method to read all the trade details from the file.
	 * @return the list of total trades.
	 * @throws OperationFailureException 
	 * @throws AccessFailureException 
	 *
	 */
	public List<StockTrade> readStockTrades() throws StockTradeInValidFormatException, AccessFailureException, OperationFailureException
	{
		LOGGER.debug("Reading Stocktrade data from the database.");
		IStockTradeDAO dao = StockTradeDAOFactory.getStockTradeDAOInstance();			//sql or csv
		return dao.readAsList();
	}
	
	/**
	 * Method to get the maximum volume trade in all trades.
	 * @param a list of all trades happened.
	 */
	public StockTrade getMaxVolumeTrade(List<StockTrade> list)
	{
		 StockTrade max = Collections.max(list);
		 return max;
	}
	
	/**
	 * Method to get the minimum volume trade in all trades.
	 * @param a list of all trades happened.
	 */
	public StockTrade getMinVolumeTrade(List<StockTrade> list)
	{
		StockTrade min = Collections.min(list);
		return min;
	}
	
	/**
	 * Method to get the difference in daily trades.
	 * @param a list of all trades happened.
	 */
	public Map<Date,Double> getDailyTradingDifferential(List<StockTrade> list)
	{
		Double difference=0d;
		Map<Date,Double> map = new LinkedHashMap<Date,Double>();
		for(int i=0;i<list.size();i++)
		{
			difference=list.get(i).getHigh() - list.get(i).getOpen();
			map.put(list.get(i).getDate(), difference);
		}
	//	System.out.println(map);
		return map;
	} 
}
