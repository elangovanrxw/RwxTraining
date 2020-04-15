package com.reactiveworks.restiplexercise.service.exception;

/**
 * A subclass of {@link ServiceException} which is to be thrown 
 * when no data is present on the instance that has to contain this data
 * before the operation.
 * @author Elangovan
 *
 */
public class RequiredFieldNotFoundException extends ServiceException {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public RequiredFieldNotFoundException() {
		super();
		
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public RequiredFieldNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public RequiredFieldNotFoundException(String message) {
		super(message);
		
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public RequiredFieldNotFoundException(Throwable cause) {
		super(cause);
		
	}

	
}
