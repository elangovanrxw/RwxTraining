package com.rw.stocktrade.main;

import java.io.*;

import java.util.*;

import com.rw.stocktrade.exceptions.FileHandlingException;
import com.rw.stocktrade.exceptions.StockTradeInValidFormatException;
import com.rw.stocktrade.readerimpl.StockTradeReaderImpl;
import com.rw.stocktrade.trade.StockTrade;

public class Test {

	public static void main(String[] args) {
		
		StockTradeReaderImpl stri = new StockTradeReaderImpl();
		try
		{
			ArrayList<StockTrade> list1 =(ArrayList) stri.readStockTrades();   //1
			System.out.println("------READING STOCK TRADES-------");
			for(int i=0;i<list1.size();i++)
			{
				System.out.println(list1.get(i));
			}
	
	/*
	  		System.out.println("------MAXIMUM VOLUME TRADES-------");
			StockTrade maxVolumeTrade = stri.getMaxVolumeTrade(list1);	//2
			System.out.println(maxVolumeTrade.getVolume());
	*/
	/*		
	  		System.out.println("------MINIMUM VOLUME TRADES-------");
			StockTrade minVolumeTrade = stri.getMinVolumeTrade(list1);   //3
			System.out.println(minVolumeTrade.getVolume());
	*/
	/*
			System.out.println("------DIFFERENCES HIGH Vs OPEN-----");    //4
			LinkedHashMap lhm = (LinkedHashMap) stri.getDailyTradingDifferential(list1);
			for(int i=0;i<lhm.size();i++)
			{
				System.out.println(lhm.get(list1.get(i).getDate()));
			}
	*/		
		} 
		catch (StockTradeInValidFormatException e)
		{
			e.printStackTrace();
		} 
		catch (FileHandlingException e)
		{
			e.printStackTrace();
		}		
	}
}
