package com.reactiveworks.stocktrade.pool;

import java.util.concurrent.LinkedBlockingQueue;


/**
 * Thread Pool implementation class.
 * @author Elangovan
 *
 */
public class StockTradeJobExecutor implements Runnable{

	/**
	 * A runnable queue of jobs.
	 */
	private static LinkedBlockingQueue<Runnable> jobs = new LinkedBlockingQueue<>();
	

	/**
	 * Number of threads to create.
	 */
	private int nThreads;
	
	
	/**
	 * Parameterized constructor for assigning jobs and number of threads.
	 * @param jobs queue of jobs to store in the current class Runnable queue.
	 * @param nThreads Number of threads to execute the complete job.
	 */
	public StockTradeJobExecutor(LinkedBlockingQueue<Runnable> jobs,int nThreads) {
		this.jobs = jobs;
		this.nThreads = nThreads;
	}
	
	/**
	 * Default no arg constructor.
	 */
	public StockTradeJobExecutor() {
		
	}
	
	/**
	 * Method to create threads and starting it.
	 */
	public void executeJobsParallely() {
		for(int i=0;i<nThreads;i++) {
			Thread t = new Thread(new StockTradeJobExecutor());
			t.start();			
		}
		try {
			Thread.currentThread().join(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Overriden method - Job implementation (Parallel execution of Threads)
	 */
	@Override
	public void run() {
		
		while(!jobs.isEmpty()) {
			Runnable job=jobs.poll();
			job.run();
		}
	}
}
