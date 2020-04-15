package com.rxw.product.domain;

import java.text.ParseException;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import com.rxw.product.exception.InvalidDataFormatException;
import com.rxw.product.exception.InvalidPriceException;

/**
 * A class for every product which is
 * containing basic properties of 
 * every product.
 * @author Elangovan
 *
 */
public class Product {
	
	private static final Logger LOGGER= Logger.getLogger(Product.class);
	/**
	 * stores the unique product Id
	 */
	private String productId;
	/**
	 * stores the name of the product.
	 */
	private String productName;
	/**
	 * stores the type of the product.
	 */
	private String productType;
	/**
	 * stores the price of the product.
	 */
	private Double price;
	/**
	 * stores the warranty of the product in years.
	 */
	private Integer warranty;
	/**
	 * stores the manufactured date of the product.
	 */
	private Date manufacturedDate;
		
	/**
	 * used to get the ID of the product.
	 * @return unique product ID
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * used to set the product ID for the product
	 * @param productId unique product ID
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	/**
	 * used to get product name
	 * @return the name of the product.
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * used to set the name of the product.
	 * @param productName the product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * used to get the type of product
	 * @return the product type.
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * used to set the type of product
	 * @param productType the type of product
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	/**
	 * used to get the price of a product
	 * @return the price of product.
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * used to set the price of the product
	 * @param price product price
	 * @throws InvalidPriceException handles exceptions regarding prices.
	 */
	public void setPrice(Double price) throws InvalidPriceException {
		if(price>0)
		   this.price = price;
		else
			throw new InvalidPriceException("Price is invalid : "+price);
	}
	/**
	 * used to get warranty of a product
	 * @return warranty of a product in years.
	 */
	public Integer getWarranty() {
		return warranty;
	}
	
	/**
	 * used to set warranty for a product
	 * @param warranty warranty in years.
	 */
	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}
	
	/**
	 * used to get the manufactured date of the product.
	 * @return manufactured date
	 */
	public Date getManufacturedDate() {
		return manufacturedDate;
	}
	
	/**
	 * used to set the manufactured date for a product.
	 * @param manufacturedDate manufactured date of product.
	 */
	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}
	
	/**
	 * Used to build product by getting the key values of {@link Map}
	 * @param map contains the map consisting of field name and 
	 * field value for one CSV line.
	 * @throws InvalidDataFormatException handles any incorrect format in data
	 */
	 public void buildProduct(Map<String,String> map) throws InvalidDataFormatException
	 {
		 LOGGER.debug("Product parameters are initializing.");
		 productId   = map.get("ProductId");
		 productName = map.get("ProductName");
		 productType = map.get("ProductType");
		 try 
		 {
			price    = Double.parseDouble(map.get("Price"));
			manufacturedDate = new SimpleDateFormat("dd/MM/yyyy").parse(map.get("ManufecturedDt"));
		 }
		 catch(NumberFormatException nfe_price)
		 {
			 LOGGER.error("Error occured for incorrect price input provided : ",nfe_price);
			 throw new InvalidDataFormatException("Incorrect format for price : "+map.get("Price"),nfe_price);
		 } 
		 catch (ParseException parseExp) 
		 {
			 LOGGER.error("Error occured for incorrect date input provided. ",parseExp);
			throw new InvalidDataFormatException("Incorrect Format for date : "+map.get("ManufecturedDt"),parseExp);
		 }
		 try {
		     warranty = Integer.parseInt(map.get("Warranty"));
		 }
		 catch(NumberFormatException nfe_waranty)
		 {
			 LOGGER.error("Error occured for incorrect format in waranty. ",nfe_waranty);
			 throw new InvalidDataFormatException("Incorrect format for Warranty : "+map.get("Warranty"),nfe_waranty);
		 } 
	 }
	 /**
	  * @return the concatenated the String with
	  *  {@link Product} properties.
	  */
	@Override
	public String toString() {
		return productId+" "+productName+" "+productType+" "+price+" "+warranty+" "+manufacturedDate;
	}
}
