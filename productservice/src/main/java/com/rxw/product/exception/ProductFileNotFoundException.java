package com.rxw.product.exception;

import java.io.File;

/**
 * A custom exception class which is 
 * handling exceptions for file related operations.
 * @author Elangovan
 *
 */
public class ProductFileNotFoundException extends Exception{

	public ProductFileNotFoundException() {
		super();
	
	}

	public ProductFileNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	
	}

	public ProductFileNotFoundException(String arg0) {
		super(arg0);
	
	}

	public ProductFileNotFoundException(Throwable arg0) {
		super(arg0);
	
	}

}
