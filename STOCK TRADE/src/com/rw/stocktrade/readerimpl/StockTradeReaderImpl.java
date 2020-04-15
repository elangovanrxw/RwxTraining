package com.rw.stocktrade.readerimpl;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.rw.stocktrade.exceptions.FileHandlingException;
import com.rw.stocktrade.exceptions.StockTradeInValidFormatException;
import com.rw.stocktrade.trade.StockTrade;
import com.rw.stocktrade.tradereader.IStockTradeReader;

public class StockTradeReaderImpl  implements IStockTradeReader{

	private StockTrade parseStockCSVLine(String csLine) throws StockTradeInValidFormatException, FileHandlingException
	{
		  String pieces[] = csLine.split(",");
			StockTrade std = new StockTrade();	
			std.setSecurity(pieces[0]);
			try 
			{
				std.setDate(new SimpleDateFormat("MM/dd/yyyy").parse(pieces[1]));  //PARSING DATE
				std.setOpen(Double.parseDouble(pieces[2]));
				std.setHigh(Double.parseDouble(pieces[3]));
				std.setLow(Double.parseDouble(pieces[4]));
				std.setClose(Double.parseDouble(pieces[5]));
				std.setVolume(Double.parseDouble(pieces[6]));
				std.setAdjClose(Double.parseDouble(pieces[7]));
			} 
			catch (ParseException parseExp)
			{
				throw new StockTradeInValidFormatException("Error occured in parsing date.",parseExp);
			}
			catch(NumberFormatException nfe)
			{
				throw new StockTradeInValidFormatException("Invalid Number.",nfe);
			}
			
			return std;
	}
	public List<StockTrade> readStockTrades() throws StockTradeInValidFormatException, FileHandlingException
	{
		ArrayList<StockTrade> list = new ArrayList<StockTrade>();
		try
		{
			String filename = "CISCO.txt";
			File file = new File(filename);
		
		//	String file = this.getClass().getResource("/CISCO.txt").getFile();
		//	File file2= new File(file);
			
		//	InputStream stream = this.getClass().getClassLoader().getResourceAsStream("/CISCO.txt");
			BufferedReader br= new BufferedReader(new FileReader(file));
			String st = null;
			int count=0;
			while((st=br.readLine())!=null)
			{
				if(count>=1)
					try
					{
						list.add(parseStockCSVLine(st));
					} catch (FileHandlingException e) 
					{
						e.printStackTrace();
					}
				count++;
			}
		}
     	catch(FileNotFoundException fnfexp)
		{
     		throw new FileHandlingException("File is not found in the given location.",fnfexp);
		}
		catch(IOException ioexp)
		{
			throw new FileHandlingException("Cannot read the given file.",ioexp);
		}
		return list;
	}
	
	public StockTrade getMaxVolumeTrade(List<StockTrade> list)
	{
		 StockTrade max = Collections.max(list);
		 return max;
	}
	
	public StockTrade getMinVolumeTrade(List<StockTrade> list)
	{
		StockTrade min = Collections.min(list);
		return min;
	}
	public Map<Date,Double> getDailyTradingDifferential(List<StockTrade> list)
	{
		Double difference=0d;
		Map<Date,Double> map = new LinkedHashMap<Date,Double>();
		for(int i=0;i<list.size();i++)
		{
			difference=list.get(i).getHigh() - list.get(i).getOpen();
			map.put(list.get(i).getDate(), difference);
		}
		System.out.println(map);
		return map;
	} 
}
