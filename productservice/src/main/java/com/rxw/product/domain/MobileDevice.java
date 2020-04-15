package com.rxw.product.domain;

import java.util.Map;

import org.apache.log4j.Logger;

import com.rxw.product.exception.InvalidDataFormatException;

/**
 * MobileDevice class which is containing the
 * specific properties that Mobile has with it.
 * @author Elangovan
 *
 */
public class MobileDevice extends ProcessingDevice {
	
	private static final Logger LOGGER = Logger.getLogger(MobileDevice.class.getName());
	/**
	 * The type of the sim for a mobile.
	 */
	private String simType;

	/**
	 * 
	 * @return type of sim for mobile
	 */
	public String getSimType() {
		return simType;
	}

	/**
	 * Set the type of sim for mobile
	 * @param simType is passed with a string
	 * indicating the type of SIM
	 */
	public void setSimType(String simType) {
		this.simType = simType;
	}
	
	/**
	 * Used to build product by getting the key values of {@link Map}
	 * @param map contains the map consisting of field name and 
	 * field value for one CSV line.
	 * @throws InvalidDataFormatException handles any incorrect format in data
	 */
	public void buildProduct(Map<String,String> map) throws InvalidDataFormatException
	{
		LOGGER.debug("Mobile building initiated.");
        super.buildProduct(map);
        simType = map.get("SIMtYPE");
	}
	/**
	 * @return concatenated the super class String with
	 * the {@link MobileDevice} object data
	 */
	public String toString()
	{
		return super.toString()+" "+simType;
	}
}
