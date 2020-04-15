package com.reactiveworks.stocktrade.job;

import org.apache.log4j.Logger;
import com.reactiveworks.stocktrade.dao.IStockTradeDAO;
import com.reactiveworks.stocktrade.dao.exception.OperationNotSupportedException;
import com.reactiveworks.stocktrade.dao.factory.StockTradeDAOFactory;
import com.reactiveworks.stocktrade.db.exception.DatabaseAccessFailureException;
import com.reactiveworks.stocktrade.db.exception.DatabaseOperationFailureException;
import com.reactiveworks.stocktrade.pojo.StockTrade;

/**
 * A simple job class which is used to carry out the job we required to perform.
 * @author Elangovan
 *
 */
public class StockTradeJob implements Runnable {

	/**
	 * Implementation of the logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(StockTradeJob.class);
	
	/**
	 * Instance of {@link StockTrade}
	 */
	private StockTrade trade;
	
	/**
	 * Instance of {@link StockTradeDAOFactory}
	 */
	private IStockTradeDAO writeDAO;
	
	/**
	 * Parameterized constructor for initialization.
	 * @param trade details of the single trade happened.
	 * @param writeDAO instance of {@link StockTradeDAOFactory} to do operations.
	 */
	public StockTradeJob(IStockTradeDAO writeDAO, StockTrade trade) {
		this.trade = trade;
		this.writeDAO = writeDAO;
	}
	
	/**
	 * Overridden method - Job implementation.
	 * 
	 */
	@Override
	public void run() {

		LOGGER.debug(Thread.currentThread().getName());
		try {
			writeDAO.insertStockTrade(trade);
		} catch (DatabaseAccessFailureException | DatabaseOperationFailureException
				| OperationNotSupportedException e) {
			LOGGER.debug("Exception occured when doing job : ",e);
		}
	}

}
