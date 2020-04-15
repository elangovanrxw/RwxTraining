package com.reactiveworks.stocktrade.pool;

import java.util.concurrent.LinkedBlockingQueue;

import com.reactiveworks.stocktrade.dao.exception.OperationNotSupportedException;
import com.reactiveworks.stocktrade.db.exception.DatabaseAccessFailureException;
import com.reactiveworks.stocktrade.db.exception.DatabaseOperationFailureException;
import com.reactiveworks.stocktrade.pojo.StockTrade;

public class StockTradeThreadPool2 {
	
	private LinkedBlockingQueue<Thread> threads;
	
	private Runnable r;
	
	public StockTradeThreadPool2(int n) {
		threads = new LinkedBlockingQueue<Thread>();
		for(int i=0;i<n;i++) {
			threads.add(new Thread());
		}
	}
	
	
	public void executeJob(Runnable job)  {
		Thread currentThread = new Thread(job);
		currentThread.start();
	}
	
}
