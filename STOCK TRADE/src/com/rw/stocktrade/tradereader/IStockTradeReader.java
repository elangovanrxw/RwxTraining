package com.rw.stocktrade.tradereader;

import java.util.*;

import com.rw.stocktrade.exceptions.FileHandlingException;
import com.rw.stocktrade.exceptions.StockTradeInValidFormatException;
import com.rw.stocktrade.trade.StockTrade;
	
public interface IStockTradeReader {
	public List<StockTrade> readStockTrades() throws StockTradeInValidFormatException,FileHandlingException;
	
	public StockTrade getMaxVolumeTrade(List<StockTrade> list);
	
	public StockTrade getMinVolumeTrade(List<StockTrade> list);
	
	public Map<Date,Double> getDailyTradingDifferential(List<StockTrade> list);
	
	
}
