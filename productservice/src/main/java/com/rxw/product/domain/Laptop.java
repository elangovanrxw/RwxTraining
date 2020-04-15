package com.rxw.product.domain;

import java.util.Map;

import org.apache.log4j.Logger;

import com.rxw.product.exception.InvalidDataFormatException;

/**
 * A class which is containing the specific 
 * properties of Laptop.
 * @author Elangovan
 *
 */
public class Laptop extends ProcessingDevice  {
	
	private static final Logger LOGGER= Logger.getLogger(Laptop.class.getName());
	/**
	 * stores the type of the graphic card 
	 * that the laptop has in it.
	 */
	private String graphicCard;

	/**
	 * 
	 * @return the  type of the graphic card
	 */
	public String getGraphicCard() {
		return graphicCard;
	}

	/**
	 * Sets the type of graphic card which laptop has in it.
	 * @param graphicCard type of graphic card
	 */
	public void setGraphicCard(String graphicCard) {
		this.graphicCard = graphicCard;
	}

	/**
	 * Used to build product by getting the key values of {@link Map}
	 * @param map contains the map consisting of field name and 
	 * field value for one CSV line.
	 * @throws InvalidDataFormatException handles any incorrect format in data
	 * 
	 */
	public void buildProduct(Map<String,String> map) throws InvalidDataFormatException
	{
		 LOGGER.debug("Laptop building initiated.");
		 super.buildProduct(map);
		 graphicCard  = map.get("GraphicsCard");
	}
	/**
	 * @return concatenated the super class String with
	 * the {@link Laptop} object data
	 */
    public String toString()
    {
    	return super.toString()+" "+graphicCard;
    }
}
