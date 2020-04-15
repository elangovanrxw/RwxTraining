package com.rxw.product.reader;

import java.util.*;
import org.apache.log4j.Logger;
import java.io.*;
import com.rxw.product.domain.Laptop;
import com.rxw.product.domain.MobileDevice;
import com.rxw.product.domain.Product;
import com.rxw.product.domain.TV;
import com.rxw.product.domain.WashingMachine;
import com.rxw.product.exception.InvalidDataFormatException;
import com.rxw.product.exception.ProductFileNotFoundException;
import com.rxw.product.exception.ProductFileNotReadableException;
import com.rxw.product.service.IProductReader;

/**
 * A class to read product details form the source file.
 * @author Elangovan
 *
 */
public class ProductCSVReader implements IProductReader{
	
	public static final Logger LOGGER= Logger.getLogger(ProductCSVReader.class);
	/**
	 * contains the filename of the source file.
	 */
	public static final String PRODUCT_FILENAME = "ProductDetail.csv";
	public static final String PRODUCT_TYPE = "ProductType";
	public static final String PRODUCT_MOBILE = "Mobile";
	public static final String PRODUCT_LAPTOP = "Laptop";
	public static final String PRODUCT_TV = "TV";
	public static final String PRODUCT_WASHINGMACHINE = "WashinMachine";
	
	/**
	 * used to get all products as a List 
	 * @return all products which was read from the file.
	 * @throws InvalidDataFormatException handles any incorrect format in data
	 * 
	 */
	public List<Product> getAllProducts() throws ProductFileNotFoundException, ProductFileNotReadableException, InvalidDataFormatException
	{
		LOGGER.debug("Searching for file : "+PRODUCT_FILENAME);
		String file = this.getClass().getResource("/"+PRODUCT_FILENAME).getFile();
		LOGGER.info("File found at the location :"+file+"\"");
		List<Product> productList = new ArrayList<Product>();
		try 
		{
			String lineString=null;
			BufferedReader reader = new BufferedReader(new FileReader(file));
			HashMap<String, String> hashMap = new HashMap<String, String>();
			String fieldNames[] = reader.readLine().split(",");
			while((lineString=reader.readLine())!=null)
			{
				String fieldValues[]=lineString.split(",");
				for(int i=0;i<fieldValues.length;i++)
				{
					hashMap.put(fieldNames[i],fieldValues[i]);
				}
				String productType = hashMap.get(PRODUCT_TYPE);
				
				if(productType.equalsIgnoreCase(PRODUCT_MOBILE))
				{
					LOGGER.debug("Creating Mobile Object.");
					MobileDevice mobile = new MobileDevice();
					mobile.buildProduct(hashMap);
					productList.add(mobile);
				}
				if(productType.equalsIgnoreCase(PRODUCT_LAPTOP))
				{
					LOGGER.debug("Creating Laptop Object.");
					Laptop laptop = new Laptop();
					laptop.buildProduct(hashMap);
					productList.add(laptop);
				}
				if(productType.equalsIgnoreCase(PRODUCT_TV))
				{
					LOGGER.debug("Creating TV Object.");
					TV tv = new TV();
					tv.buildProduct(hashMap);
					productList.add(tv);
				}
				if(productType.equalsIgnoreCase(PRODUCT_WASHINGMACHINE))
				{
					LOGGER.debug("Creating washing machine Object.");
					WashingMachine washingMachine = new WashingMachine();
					washingMachine.buildProduct(hashMap);
					productList.add(washingMachine);
				}
			}
			reader.close();				//Closing the resource.
		} 
		catch (FileNotFoundException fnfexp)
		{
			LOGGER.error("Product file is not found in given classpath :",fnfexp);
			throw new ProductFileNotFoundException("Product file is not found in given classpath",fnfexp);
		} 
		catch (IOException ioexp) 
		{
			LOGGER.error("Product file cannot be read :",ioexp);
			throw new ProductFileNotReadableException("Product file cannot be read",ioexp);
		}
		
		if(productList.size()==0) {
			LOGGER.warn("No Products are retrieved, list is empty.");
		}
		LOGGER.info("Returning all "+productList.size()+" products. ");
		return productList;
	}
}
