package com.reactiveworks.stocktrade.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.reactiveworks.stocktrade.dao.IStockTradeDAO;
import com.reactiveworks.stocktrade.dao.exception.FileAccessFailureException;
import com.reactiveworks.stocktrade.dao.exception.FileOperationFailureException;
import com.reactiveworks.stocktrade.dao.exception.OperationNotSupportedException;
import com.reactiveworks.stocktrade.dao.exception.StockTradeInValidFormatException;
import com.reactiveworks.stocktrade.pojo.StockTrade;

/**
 * DAO implementation class for the CSV file.
 * @author Elangovan
 *
 */
public class StockTradeDAOCSVImpl implements IStockTradeDAO	{

	private static final Logger LOGGER = Logger.getLogger(StockTradeDAOCSVImpl.class);
	
	private static final String STOCK_FILE_NAME = "CISCO.txt";
	
	//Helper method to split data.
	private StockTrade parseStockCSVLine(String csLine) throws StockTradeInValidFormatException {
		
		String pieces[] = csLine.split(",");
		StockTrade std = new StockTrade();	
		
		try 
		{
	//		std.setTradeId(Integer.parseInt(pieces[0]));
			std.setSecurity(pieces[0]);
			std.setDate(new Date(new SimpleDateFormat("MM/dd/yyyy").parse(pieces[1]).getTime()));  //PARSING DATE
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
		} catch (ParseException parseExp) {
			LOGGER.error("Error occured in parsing date.",parseExp);
			throw new StockTradeInValidFormatException("Error occured in parsing date.",parseExp);
		}
		
		return std;
}
	/**
	 * method to read the entire data and convert it to a list
	 * @return A list of CSV file data.
	 * @throws FileAccessFailureException If there is an error in accessing the resource.
	 * @throws FileOperationFailureException If there is an error in performing some operation.
	 * @throws StockTradeInValidFormatException if there is any error in format of the given data.
	 */
	@Override
	public List<StockTrade> getAllStockTrades() throws FileAccessFailureException, StockTradeInValidFormatException, FileOperationFailureException{
					
		ArrayList<StockTrade> list = new ArrayList<StockTrade>();
		try
		{		
			String file = this.getClass().getResource("/"+STOCK_FILE_NAME).getFile();			
			BufferedReader br= new BufferedReader(new FileReader(file));
			
			String st = null;
			br.readLine();
			while((st=br.readLine())!=null)
			{
				StockTrade trade = parseStockCSVLine(st);
				list.add(trade);
			}
			br.close();
		}
		
     	catch(FileNotFoundException fnfexp)
		{
     		LOGGER.error("File is not found in the given location.",fnfexp);
     		throw new FileAccessFailureException("File is not found in the given location.",fnfexp);
		}
		catch(IOException ioexp)
		{
			LOGGER.error("Cannot read the given file.",ioexp);
			throw new FileOperationFailureException("Cannot read the given file.",ioexp);
		}
		LOGGER.debug("FILE READING COMPLETE... Returning list with size : "+list.size());
		return list;
	}
	@Override
	public int insertStockTrade(StockTrade trade) throws OperationNotSupportedException {
		throw new OperationNotSupportedException("This operation is not supported");
		
	}
	
	@Override
	public void cleanUp() throws OperationNotSupportedException {
		throw new OperationNotSupportedException("This operation is not supported");
		
	}

}
