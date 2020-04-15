package com.reactiveworks.stocktrade.service.impl;

import java.util.ArrayList; 

import java.util.List;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;

import com.reactiveworks.stocktrade.dao.IStockTradeDAO;
import com.reactiveworks.stocktrade.dao.StockTradeDAOFactory;
import com.reactiveworks.stocktrade.dao.exception.StockTradeDAOException;
import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.pojo.DailyTradingDifferential;
import com.reactiveworks.stocktrade.pojo.StockTrade;
import com.reactiveworks.stocktrade.service.IStockTradeService;
import com.reactiveworks.stocktrade.service.exception.NullValueOccurenceException;
import com.reactiveworks.stocktrade.service.exception.ServiceOperationFailureException;
import com.reactiveworks.stocktrade.service.exception.StockTradeServiceException;


/**
 * A class implementing the service methods for 
 * business logic to do the required operations.
 * @author Elangovan
 *
 */
public class StockTradeServiceImpl  implements IStockTradeService {

	/**
	 * Implementation of Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(StockTradeServiceImpl.class);
	
	/**
	 * A method to read all the trade details from the file.
	 * @return the list of total trades.
	 * @throws ServiceOperationFailureException if any operation performed by service class leads to failure.
	 * @throws NullValueOccurenceException if any null value occurs (preventing from {@link NullPointerException})
	 */
	public List<StockTrade> readStockTrades() throws StockTradeServiceException {
		LOGGER.debug("Reading the complete stocktrade data..");
		IStockTradeDAO dao = StockTradeDAOFactory.daoInstance;
		List<StockTrade> allStockTrades= null;
		try {
			allStockTrades = dao.getAllStockTrades();
		} catch (StockTradeDAOException daoExp) {
			LOGGER.error("Reading all StockTrade failure because its corresponding DAO operation failure.",daoExp);
			throw new ServiceOperationFailureException("Reading all StockTrade failure because its corresponding DAO operation failure.",daoExp);
		} 
		return allStockTrades;
	}
	
	/**
	 * Method to get the maximum volume trade in all trades from all the trades list.
	 * @param a list of all trades happened.
	 * @throws NullValueOccurenceException if any null value occurs.
	 */
	public StockTrade getMaxVolumeTrade(List<StockTrade> list) throws StockTradeServiceException
	{
		try {
			StockTrade maxTrade=list.parallelStream()
					   		  .sorted((a,b) -> a.getVolume()>b.getVolume()?-1 :
							   				 a.getVolume()<b.getVolume()? 1 : 0)
					   		  .limit(1)
					   		  .collect(Collectors.toList()).get(0);
			return maxTrade;
		}catch (NullPointerException npe) {
			LOGGER.error("Getting Max trade service failure because there's been an occurence of null value.",npe);
			throw new NullValueOccurenceException("Getting Max trade service failure because there's been an occurence of null value.",npe);
		}
		catch (Exception exp) {
			LOGGER.error("Exception Occured when getting Max Trade",exp);
			throw new StockTradeServiceException("Exception Occured when getting Max Trade",exp);
		}
		
	}
	
	/**
	 * Method to get the minimum volume trade in all trades from all the trades list.
	 * @param list a list of all trades happened.
	 * @throws NullValueOccurenceException if any null value occurs.
	 */
	public StockTrade getMinVolumeTrade(List<StockTrade> list) throws StockTradeServiceException
	{
		try {
			StockTrade minTrade = list.parallelStream()
					   				 .sorted((a,b) -> a.getVolume()>b.getVolume()? 1 :
					   					 			  a.getVolume()<b.getVolume()? -1 : 0)
					   				 .limit(1)
					   				 .collect(Collectors.toList()).get(0);
			return minTrade;
		}catch (NullPointerException npe) {
			LOGGER.error("Getting Min trade service failure because there's been an occurence of null value.",npe);
			throw new NullValueOccurenceException("Getting Min trade service failure because there's been an occurence of null value.",npe);
		}
		catch (Exception exp) {
			LOGGER.error("Exception Occured when getting Min Trade",exp);
			throw new StockTradeServiceException("Exception Occured when getting Min Trade",exp);
		}
	}
	
	/**
	 * Method to get the difference in daily trades from all the trades list.
	 * @param list a list of all trades happened.
	 * @throws NullValueOccurenceException 
	 */
	public List<DailyTradingDifferential> getDailyTradingDifferential(List<StockTrade> list) throws StockTradeServiceException
	{
		List<DailyTradingDifferential> differenceList = new ArrayList<>();
		try {
			list.stream().forEach( l -> {
				DailyTradingDifferential dtd = new DailyTradingDifferential();
				double diff = l.getHigh() - l.getOpen();
				dtd.setDate(l.getDate());
				dtd.setDifference(diff);
				differenceList.add(dtd);
			});
		}catch (NullPointerException npe) {
			LOGGER.error("Getting daily trading differential service failure because there's been an occurence of null value.",npe);
			throw new NullValueOccurenceException("Getting daily trading differential service failure because there's been an occurence of null value.",npe);
		}
		catch (Exception exp) {
			LOGGER.error("Exception Occured when getting daily trading differential",exp);
			throw new StockTradeServiceException("Exception Occured when getting Max Trade",exp);
		}
		return differenceList;
	} 
}
