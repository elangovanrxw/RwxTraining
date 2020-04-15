package com.reactiveworks.stocktrade.dao.impl;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import com.reactiveworks.stocktrade.dao.IStockTradeDAO;
import com.reactiveworks.stocktrade.dao.exception.OperationNotSupportedException;
import com.reactiveworks.stocktrade.dao.exception.StockTradeDAOFileException;
import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.pojo.StockTrade;

/**
 * DAO implementation class for the CSV file.
 * @author Elangovan
 *
 */
public class StockTradeDAOCSVImpl implements IStockTradeDAO	{

	/**
	 * Implementation of the logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(StockTradeDAOCSVImpl.class);
	
	/**
	 * File name of the stocktrade data file.
	 */
	private static final String STOCK_FILE_NAME = "CISCO.txt";
	
	private static int TRADE_ID = 1;
	//Helper method to split data.
	private StockTrade parseStockCSVLine(String csLine) throws StockTradeInValidFormatException  {
		
		String pieces[] = csLine.split(",");
		StockTrade std = new StockTrade();	
		try 
		{
			std.setTradeId(TRADE_ID++);
			std.setSecurity(pieces[0]);
			
			String date[] = pieces[1].split("/");
			int dayOfMonth = Integer.parseInt(date[1]);
			int month = Integer.parseInt(date[0]);
			int year = Integer.parseInt(date[2]);		
			std.setDate(LocalDate.of(year, month, dayOfMonth));  //PARSING DATE
			
			std.setOpen(Double.parseDouble(pieces[2]));
			std.setHigh(Double.parseDouble(pieces[3]));
			std.setLow(Double.parseDouble(pieces[4]));
			std.setClose(Double.parseDouble(pieces[5]));
			std.setVolume(Double.parseDouble(pieces[6]));
			std.setAdjClose(Double.parseDouble(pieces[7]));
		} 

		catch(NumberFormatException nfe)
		{
			LOGGER.error("Invalid Number.",nfe);
			throw new StockTradeInValidFormatException("Invalid Number.",nfe);
		} 
		return std;
}
	/**
	 * method to read the entire data and convert it to a list
	 * @return A list of StockTrade data.
	 * @throws StockTradeInValidFormatException if there is any error in format of the given data.
	 * @throws StockTradeDAOFileException if any file related DAO exceptions occur.
	 */
	@Override
	public List<StockTrade> getAllStockTrades() throws StockTradeDAOFileException {
					
		try
		{		
			URI file = this.getClass().getResource("/"+STOCK_FILE_NAME).toURI();	
			LOGGER.info("StockTrade file is found at the location : "+STOCK_FILE_NAME);
			BufferedReader br= Files.newBufferedReader(Paths.get(file));
		
			br.readLine();		//TO AVOID HEADING (Ex: Security,Date,Open,High, etc...)
				
			List<StockTrade> stockTradeList = br.lines().map(line -> {
														try {
															return parseStockCSVLine(line);
														} catch (StockTradeInValidFormatException e) {
															LOGGER.error("Exception occured when parsing : ",e);											
														}
														return null;
													}).collect(Collectors.toList());
					  
			br.close();			//Closing bufferedreader.
			LOGGER.debug("FILE READING COMPLETE... Returning list with size : "+stockTradeList.size());
			return stockTradeList;
		}
		
     	catch(FileNotFoundException fnfexp)
		{
     		LOGGER.error("File is not found in the given location.",fnfexp);
     		throw new StockTradeDAOFileException("File is not found in the given location.",fnfexp);
		}
		catch(IOException ioexp)
		{
			LOGGER.error("Cannot read the given file.",ioexp);
			throw new StockTradeDAOFileException("Cannot read the given file.",ioexp);
		} catch (URISyntaxException uriExp) {
			LOGGER.error("Given path string could not be parsed as a URI reference. ",uriExp);
			throw new StockTradeDAOFileException("Given path string could not be parsed as a URI reference. ",uriExp);
		}
	}
	
	/**
	 * A method to insert the stocktrade object into the database.
	 * @param stockTrade the stocktrade object is to be inserted.
	 * @throws OperationNotSupportedException in case the operation is not supported.
	 */
	@Override
	public int insertStockTrade(StockTrade stockTrade)  throws OperationNotSupportedException {
		LOGGER.error("This operation is not supported by this implementation...");
		throw new OperationNotSupportedException("This operation is not supported by this implementation...");
	}
	
	/**
	 * A method to get the stocktrade data from the database for the required tradeid passed.
	 * @param tradeId the trade id whose trade data has to be fetched.
	 * @throws StockTradeDAOFileException if any file related DAO exceptions occur.
	 * @throws StockTradeInValidFormatException if there is any error in format of the given data.
	 */
	@Override
	public StockTrade getStockTradeById(int tradeId) throws StockTradeInValidFormatException, StockTradeDAOFileException {
		List<StockTrade> completeList = getAllStockTrades();
		
		List<StockTrade> filteredList = completeList.stream().filter(trade -> trade.getTradeId()==tradeId)
													.collect(Collectors.toList());
		
		return filteredList.get(0);	
	}
	
	/**
	 * A method to delete the specific Stock trade
	 * @param tradeId trade id whose stock trade data want to be deleted.
	 */
	@Override
	public int deleteStockTradeById(int tradeId) throws OperationNotSupportedException {
		LOGGER.error("This operation is not supported by this implementation...");
		throw new OperationNotSupportedException("This operation is not supported by this implementation...");
	}
	
	/**
	 * A method to update the Stock trade security for particular tradeId.
	 * @param tradeId trade id whose data want to be updated.
	 * @param security the new security data which needs to be updated. 
	 */
	@Override
	public int updateStockTradeSecurity(int tradeId, String security) throws OperationNotSupportedException {
		LOGGER.error("This operation is not supported by this implementation...");
		throw new OperationNotSupportedException("This operation is not supported by this implementation...");
	}

	/**
	 * A method to perform the batch insert operation to the database
	 * @param list the list of stock trade objects need to be inserted.
	 * @return an array of integers with number of rows updated.
	 * @throws OperationNotSupportedException in case if the method is not supported for the implementation.
	 */
	@Override
	public int[] performBatchInsertStockTrade(List<StockTrade> list,int batchSize) throws OperationNotSupportedException {
		LOGGER.error("This operation is not supported by this implementation...");
		throw new OperationNotSupportedException("This operation is not supported by this implementation...");
	}
	
	/**
	 * Clean up the database (truncate command).
	 * @throws OperationNotSupportedException in case if the method is not supported.
	 */
	@Override
	public void cleanUp() throws OperationNotSupportedException {
		LOGGER.error("This operation is not supported by this implementation...");
		throw new OperationNotSupportedException("This operation is not supported by this implementation...");		
	}


}
