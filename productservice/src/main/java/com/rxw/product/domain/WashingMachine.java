package com.rxw.product.domain;

import java.util.Map;

import org.apache.log4j.Logger;

import com.rxw.product.exception.InvalidDataFormatException;

/**
 * A class that specifically containing the individual properties of 
 * washing machine.
 * @author Elangovan
 *
 */
public class WashingMachine extends Product {

	private static final Logger LOGGER = Logger.getLogger(WashingMachine.class.getName());
	/**
	 * stores the load capacity of the Washing machine
	 */
	private Integer loadCapacity;
	
	/**
	 * stores whether the type of washing machine 
	 * is automatic or not.
	 */
	private boolean isAutomatic;
	/**
	 * stores the door type of the washhing machine
	 */
	private String doorType;

	/**
	 * used to get the load capacity of washing machine
	 * @return load of the washing machine
	 */
	public Integer getLoadCapacity() {
		return loadCapacity;
	}
	
	/**
	 * used to set the load capacity of the washing machine 
	 * @param loadCapacity load capacity of the washing machine
	 */
	public void setLoadCapacity(Integer loadCapacity) {
		this.loadCapacity = loadCapacity;
	}
	
	/**
	 * used to get the boolean value (true or false)
	 * @return true is washing machine is automatic else, returns false
	 */
	public boolean isAutomatic() {
		return isAutomatic;
	}
	/**
	 * used to set the washing machine automatic or not.
	 * @param isAutomatic a boolean value indicating the state
	 * of automatic
	 */
	public void setAutomatic(boolean isAutomatic) {
		this.isAutomatic = isAutomatic;
	}
	
	/**
	 * used to get the door type of the washing machine.
	 * @return the door type of washing machine.
	 */
	public String getDoorType() {
		return doorType;
	}
	
	/**
	 * used to set the door type of the washing machine. 
	 * @param doorType indicates the door type of washing machine.
	 */
	public void setDoorType(String doorType) {
		this.doorType = doorType;
	}
	/**
	 * Used to build product by getting the key values of {@link Map}
	 * @param map contains the map consisting of field name and 
	 * field value for one CSV line.
	 * @throws InvalidDataFormatException handles any incorrect format in data
	 */
	public void buildProduct(Map<String,String> map) throws InvalidDataFormatException
	{
		 LOGGER.debug("Washing machine building initiated.");
		 super.buildProduct(map);
		 try
		 {
			 loadCapacity = Integer.parseInt(map.get("loadCapacity"));
		 }
		 catch(NumberFormatException nfe)
		 {
			 LOGGER.error("Error occured for incorrect format in load capacity :",nfe);
			 throw new InvalidDataFormatException("Incorrect format for Load capacity : "+map.get("loadCapacity"),nfe);
		 }
		 if(map.get("isAutomatic").equalsIgnoreCase("yes"))
			 isAutomatic=true;
		 else
			 isAutomatic=false;
		 
		 doorType = map.get("doorType");
	}
	/**
	 * @return concatenated the super class String with
	 * the {@link WashingMachine} object data
	 */
	public String toString()
	{
		return super.toString()+" "+loadCapacity+" "+isAutomatic+" "+doorType;
	}
}
