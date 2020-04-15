package com.rxw.product.domain;

import java.util.Map;

import org.apache.log4j.Logger;

import com.rxw.product.exception.InvalidDataFormatException;

/**
 * ProcessingDevice class containing the
 * properties for any device with its 
 * specification.
 * @author Elangovan
 * 
 */
public class ProcessingDevice extends Product {

	private static final Logger LOGGER = Logger.getLogger(ProcessingDevice.class.getName());
	/**
	 * Stores screensize of the particular device.
	 */
	private String screenSize;
	/**
	 * Stores the type of the operating system of particular device.
	 */
	private String operatingSystem;
	/**
	 * contains battery capacity.
	 */
	private Integer batterySize;
	/**
	 * Contains the number of cores that the device has.
	 */
	private Integer numCore;
	/**
	 * Contains the amount of RAM of device in (GB)
	 */
	private Integer ram;
	
	/**
	 * @return the screensize of particular device.
	 */
	public String getScreenSize() {
		return screenSize;
	}
	/**
	 * Set the size of screen to instance.
	 * @param screenSize the device's screen size
	 */
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	/**
	 * Get the operating system of particular device
	 * @return the type of operating system
	 */
	public String getOperatingSystem() {
		return operatingSystem;
	}
	/**
	 * This method sets the type of operating system
	 * @param operatingSystem type of operating system
	 */
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	/**
	 * Used to return the battery capacity.
	 * @return battery capacity of particular device.
	 */
	public Integer getBatterySize() {
		return batterySize;
	}
	/**
	 * used to set the battery capacity
	 * @param batterySize battery capacity of device
	 */
	public void setBatterySize(Integer batterySize) {
		this.batterySize = batterySize;
	}
	/**
	 * used to get the number of cores that device has.
	 * @return the number of cores.
	 */
	public Integer getNumCore() {
		return numCore;
	}
	/**
	 * used to set the cores.
	 * @param numCore the number of cores device is having.
	 */
	public void setNumCore(Integer numCore) {
		this.numCore = numCore;
	}
	/**
	 * used to get ram capacity of device.
	 * @return the amount of ram.
	 */
	public Integer getRam() {
		return ram;
	}
	/**
	 * Used to initialize the amount of ram
	 * @param ram amount of ram that device is having.
	 */
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	
	/**
	 * Used to build product by getting the key values of {@link Map}
	 * @param map contains the map consisting of field name and 
	 * field value for one CSV line.
	 * @throws InvalidDataFormatException handles any incorrect format in data
	 */
	public void buildProduct(Map<String,String> map) throws InvalidDataFormatException
    {
		 LOGGER.debug("Processing device building initiated.");
		 super.buildProduct(map);
		 screenSize      = map.get("ScreenSize");
		 operatingSystem = map.get("OS");
		 try {
			 batterySize = Integer.parseInt(map.get("BatterySize"));
		 }
		 catch(NumberFormatException nfe)
		 {
			 LOGGER.error("Error occured for incorrect format for battery size : ",nfe);
			 throw new InvalidDataFormatException("Incorrect format : "+map.get("BatterySize"));
		 }
		 try {
			 numCore = Integer.parseInt(map.get("NumCore"));
		 }catch(NumberFormatException nfe)
		 {
			 LOGGER.error("Error occured for incorrect format for number of cores : ",nfe);
			 throw new InvalidDataFormatException("Incorrect format : "+map.get("NumCore"));
		 }
		 try {
			 ram	 = Integer.parseInt(map.get("RAM"));
		 }catch(NumberFormatException nfe)
		 {
			 LOGGER.error("Error occured for incorrect format for ram : "+map.get("RAM"));
			 throw new InvalidDataFormatException("Incorrect format : "+map.get("RAM"));
		 }
	}
	/**
	 * @return concatenated the super class String with
	 * the {@link ProcessingDevice} object data
	 */
	public String toString()
	{
		return super.toString()+" "+screenSize+" "+operatingSystem+" "+batterySize+" "+numCore+" "+ram;
	}	
}
