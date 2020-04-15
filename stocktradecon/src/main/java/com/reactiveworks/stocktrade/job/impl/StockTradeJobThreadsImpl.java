package com.reactiveworks.stocktrade.job.impl;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.reactiveworks.stocktrade.dao.IStockTradeDAO;
import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.dao.factory.StockTradeDAOFactory;
import com.reactiveworks.stocktrade.exception.AccessFailureException;
import com.reactiveworks.stocktrade.exception.OperationFailureException;
import com.reactiveworks.stocktrade.job.StockTradeJob;
import com.reactiveworks.stocktrade.pojo.StockTrade;
import com.reactiveworks.stocktrade.pool.StockTradeJobExecutor;
/**
 * A job implementation class for own thread pool implementation.
 * @author Elangovan
 *
 */
public class StockTradeJobThreadsImpl {

	/**
	 * Logger implementation
	 */
	private static final Logger LOGGER = Logger.getLogger(StockTradeJobThreadsImpl.class);
	
	
	/**
	 * This method is used to assign the splitted job to the threads.
	 * @throws OperationFailureException if any failure occur when performing opeartion.
	 * @throws AccessFailureException if any failure in getting access to a source.
	 * @throws StockTradeInValidFormatException	if any format errors.
	 */
	public void doInsertionUsingThreads() throws OperationFailureException, AccessFailureException, StockTradeInValidFormatException {

		IStockTradeDAO readDAO = StockTradeDAOFactory.getStockTradeDAOInstance("csv");
		LOGGER.debug("Retrieving files as list...");
		List<StockTrade> list = readDAO.getAllStockTrades();
		LOGGER.debug("Getting SQL Instance for job...");
		IStockTradeDAO writeDAO = StockTradeDAOFactory.getStockTradeDAOInstance("sql");
		
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
		for(StockTrade trade : list) {
			queue.add(new StockTradeJob(writeDAO,trade));
		}
		StockTradeJobExecutor tp = new StockTradeJobExecutor(queue, 4);
		tp.executeJobsParallely();
	}
}
