package com.reactiveworks.stocktrade.exception;

/**
 * An exception class which is to be thrown whenever
 * there any errors occur in the starting and
 * closing of the spring container.
 * @author Elangovan
 *
 */
public class StockTradeSpringException extends Exception {

	/**
	 * Default Constructor
	 */
	public StockTradeSpringException() {
		super();
		
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public StockTradeSpringException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public StockTradeSpringException(String message) {
		super(message);
		
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public StockTradeSpringException(Throwable cause) {
		super(cause);
		
	}

	

}
