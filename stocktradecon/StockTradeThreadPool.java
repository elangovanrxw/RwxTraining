package com.reactiveworks.stocktrade.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

public class StockTradeThreadPool {
	
	private static final Logger LOGGER = Logger.getLogger(StockTradeThreadPool.class);
	
	private WorkerThread[] threads;
	
	private LinkedBlockingQueue<Runnable> queue;
	
	 boolean isShutdown = false;
	
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition empty = lock.newCondition();
	private final Condition nonEmpty = lock.newCondition();
	
	private AtomicBoolean exit = new AtomicBoolean(false);

	public StockTradeThreadPool(int nThreads) {
		queue = new LinkedBlockingQueue<Runnable>();
		threads = new WorkerThread[nThreads];
		
		for (int i = 0; i < nThreads; i++) {
            threads[i] = new WorkerThread();
            threads[i].start();
        }
	}
	
	 public void executeJob(Runnable task) {
	//	 lock.lock();
            queue.add(task);
            queue.notify();
    //        nonEmpty.signal();
    //     lock.unlock();
	 }
	 
	 public void stop() {
		 exit.set(true);
	 }
	 
	 private class WorkerThread extends Thread{

		 public void run () {			 
			 Runnable job;
			 
			 while(!exit.get()) 
			 {
	//			 	lock.lock();
				 	synchronized (queue) {
				 		while(queue.isEmpty()) {
							try {
							//	empty.await();
								queue.wait();
							} catch (InterruptedException e) {
								LOGGER.error("Exception occured while queue waiting ..",e);;
							}
						}
					}
					
	//				lock.unlock();
					job = queue.poll();
					try {
						job.run();
					}
					catch(RuntimeException re) {
						LOGGER.debug("Runtime exception : ",re);
					}
			 }
		 }
	 }

}
	
