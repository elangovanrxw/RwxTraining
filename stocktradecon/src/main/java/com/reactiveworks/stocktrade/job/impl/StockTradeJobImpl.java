package com.reactiveworks.stocktrade.job.impl;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import com.reactiveworks.stocktrade.dao.IStockTradeDAO;
import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.dao.factory.StockTradeDAOFactory;
import com.reactiveworks.stocktrade.exception.AccessFailureException;
import com.reactiveworks.stocktrade.exception.OperationFailureException;
import com.reactiveworks.stocktrade.job.StockTradeJob;
import com.reactiveworks.stocktrade.pojo.StockTrade;

/**
 * An implementation class for the job assigned to the threads.
 * @author Elangovan
 *
 */
public class StockTradeJobImpl {
 
	/**
	 * Logger implementation for the class.
	 */
	private static final Logger LOGGER = Logger.getLogger(StockTradeJobImpl.class);
	
	/**
	 * Number of threads to initialize in the thread pool.
	 */
	private static final int NUMBER_OF_THREADS = 10;
	
	/**
	 * This method is used to assign the job to the threads.
	 * @throws OperationFailureException  if any failure in perfoming some operations.
	 * @throws AccessFailureException	if any failure accessing any resources.
	 * @throws StockTradeInValidFormatException	if there is an error in any data format is wrong
	 */
	public void doInsertionJob() throws OperationFailureException, AccessFailureException, StockTradeInValidFormatException {
		long startTiming = System.currentTimeMillis();
		
		IStockTradeDAO readDAO = StockTradeDAOFactory.getStockTradeDAOInstance("csv");
		LOGGER.debug("Retrieving files as list...");
		List<StockTrade> list = readDAO.getAllStockTrades();
		LOGGER.debug("Getting SQL Instance for job...");
		IStockTradeDAO writeDAO = StockTradeDAOFactory.getStockTradeDAOInstance("sql");
	
		ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		LOGGER.debug("Executor service is created with "+NUMBER_OF_THREADS+" threads");
		for(StockTrade trade : list)
		{
			service.execute(new StockTradeJob(writeDAO,trade));
		}
		service.shutdown();			//Initiating shutdown
		
		try {
			
			//Wait for all threads to complete its execution
			if(!service.awaitTermination(120, TimeUnit.SECONDS)) {		
				service.shutdownNow();
			}
		}catch(InterruptedException ie) {
			LOGGER.debug("Exception occured when shutting down : ",ie);
		}
		finally {
			long endTime = System.currentTimeMillis();
			LOGGER.debug("Total time taken by  'doInsertionJob()' :" +(endTime-startTiming));
		}
	}
}
