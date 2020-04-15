package com.rxw.product.domain;

import java.util.Map;

import org.apache.log4j.Logger;

import com.rxw.product.exception.InvalidDataFormatException;

/**
 * A class containing the individual properties
 * of Television
 * @author Elangovan
 */
public class TV extends Product {
	
	private static final Logger LOGGER= Logger.getLogger(TV.class.getName()); 
	/**
	 * stores the display size of the TV
	 */
	private Integer displaySize;
	/**
	 * stores the type of the display
	 */
    private String displayType;
    /**
     * stores whether the tv is smart tv or not. (true or false)
     */
    private boolean isSmartTv;
    
    
    /**
     * used to get the display size of the TV
     * @return display size of the TV
     */
	public Integer getDisplaySize() {
		return displaySize;
	}
	
	/**
	 * used to set the display size for a TV.
	 * @param displaySize contains the display size of the TV
	 */
	public void setDisplaySize(Integer displaySize) {
		this.displaySize = displaySize;
	}
	
	/**
	 * used to get display type of the TV
	 * @return display type of TV.
	 */
	public String getDisplayType() {
		return displayType;
	}
	
	/**
	 * used to set display type for a TV
	 * @param displayType type of display for TV
	 */
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	
	/**
	 * Get whether the TV is smart tv or not.
	 * @return true if the TV is smart, else returns false.
	 */
	public boolean isSmartTv() {
		return isSmartTv;
	}
	public void setSmartTv(boolean isSmartTv) {
		this.isSmartTv = isSmartTv;
	}
    
	/**
	 * Used to build product by getting the key values of {@link Map}
	 * @param map contains the map consisting of field name and 
	 * field value for one CSV line.
	 * @throws InvalidDataFormatException handles any incorrect format in data
	 */
	public void buildProduct(Map<String,String> map) throws InvalidDataFormatException
	{
		 LOGGER.debug("TV building initiated.");
		 super.buildProduct(map);
		 try {
		 displaySize = Integer.parseInt(map.get("DisplaySize"));
		 }
		 catch(NumberFormatException numFormatExp)
		 {
			 LOGGER.error("Error occured in incorrect format in display size : ",numFormatExp);
			 throw new InvalidDataFormatException("Incorrect format for display size: "+map.get("DisplaySize"),numFormatExp);
		 }
		 
		 displayType = map.get("DisplayType");
		 if(map.get("isSmartTV").equalsIgnoreCase("yes"))
		 {
			 isSmartTv=true;
		 }
		 else
		 {
			 isSmartTv=false;
		 }
	}
	/**
	 * @return concatenated the super class String with
	 * the {@link TV} object data
	 */  
    public String toString()
    {
    	return super.toString()+" "+displaySize+" "+displayType+" "+isSmartTv;
    }

}
