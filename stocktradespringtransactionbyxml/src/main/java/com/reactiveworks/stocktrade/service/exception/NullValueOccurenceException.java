package com.reactiveworks.stocktrade.service.exception;


public class NullValueOccurenceException extends StockTradeServiceException {

	/**
	 * Default Constructor
	 */
	public NullValueOccurenceException() {
		super();
		
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public NullValueOccurenceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public NullValueOccurenceException(String message) {
		super(message);
		
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public NullValueOccurenceException(Throwable cause) {
		super(cause);
		
	}


	
}
