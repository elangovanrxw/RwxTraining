package com.rxw.product.readers;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import com.rxw.product.base.Product;
import com.rxw.product.exception.FileHandlingException;
import com.rxw.product.exception.NegativeOrZeroPriceException;
import com.rxw.product.exception.NotNumberException;

public class ProductCSVReader extends Reader{
		
    public static final String PRODUCT_FILENAME="Product.csv";
	
	public List<Product> getAllProducts() throws NegativeOrZeroPriceException, FileHandlingException, NotNumberException
	{
		ArrayList<Product> productList = new ArrayList<Product>();
		try
		{
			BufferedReader br = getBufferredReader(PRODUCT_FILENAME);
			String lineString = null;
			int count=0;
			while((lineString=br.readLine())!=null)
			{
				if(count>=1)
					productList.add(parseProductData(lineString));
				count++;
			}
		} 
		catch (FileNotFoundException fnfexp)
		{
			throw new FileHandlingException("File '"+PRODUCT_FILENAME+"' is not present in classpath.",fnfexp);
		} 
		catch (IOException ioexp) 
		{
			throw new FileHandlingException("[READING ERROR] Cannot read the given file : '"+PRODUCT_FILENAME+"'",ioexp);
		}
		return productList;		
	}

	private Product parseProductData(String lineString) throws NegativeOrZeroPriceException, NotNumberException {
		
		String prodDet[] = lineString.split(",");
		Product  product = new Product();
		product.setProductId(prodDet[0]);
		product.setProductName(prodDet[1]);
		product.setProductCategory(prodDet[2]);
		try
		{
			product.setPrice(Double.parseDouble(prodDet[3]));
		}
		catch(NumberFormatException nfe)
		{
			throw new NotNumberException("[ERROR] It is not a number : "+prodDet[3]);
		}
		ArrayList<String> list = new ArrayList<String>();
		
		String city[] = prodDet[4].split("/");		
		for(int i=0;i<city.length;i++)
			list.add(city[i]);
		product.setAvailableCity(list);
		
		return product;
	}

}
