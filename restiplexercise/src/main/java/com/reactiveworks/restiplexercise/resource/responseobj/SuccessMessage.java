package com.reactiveworks.restiplexercise.resource.responseobj;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A class which instances has to return to indicate the success response.
 * @author Elangovan
 *
 */
@XmlRootElement
public class SuccessMessage {

	/**
	 * The operation performed to the resource.
	 */
	private String operation;
	
	/**
	 * Sucess message of the operation.
	 */
	private String successMsg;

	/*
	 * Getters and setters for the instance variables.
	 */
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
		
}
