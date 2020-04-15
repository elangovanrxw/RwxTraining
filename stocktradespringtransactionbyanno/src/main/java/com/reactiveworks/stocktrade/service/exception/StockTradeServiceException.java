package com.reactiveworks.stocktrade.service.exception;

/**
 * A parent exception for all the service related exceptions.
 * @author Elangovan
 *
 */
public class StockTradeServiceException extends Exception {

	/**
	 * Default Constructor
	 */
	public StockTradeServiceException() {
		super();
		
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public StockTradeServiceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public StockTradeServiceException(String message) {
		super(message);
		
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public StockTradeServiceException(Throwable cause) {
		super(cause);
		
	}

	
}
