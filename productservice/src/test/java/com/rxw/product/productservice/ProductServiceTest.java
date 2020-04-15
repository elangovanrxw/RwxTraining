package com.rxw.product.productservice;

import org.apache.log4j.Logger;
import org.junit.*;
import com.rxw.product.domain.Product;
import com.rxw.product.exception.InvalidDataFormatException;
import com.rxw.product.exception.InvalidPriceException;
import com.rxw.product.exception.ProductFileNotFoundException;
import com.rxw.product.exception.ProductFileNotReadableException;
import com.rxw.product.reader.ProductCSVReader;
import static org.junit.Assert.*;
import java.util.HashMap;


/**
 * A class used to test the functionalities of the project.
 * @author Elangovan
 *
 */
public class ProductServiceTest {
	
	private static final Logger LOGGER = Logger.getLogger(ProductServiceTest.class);
	/**
	 * This test case is used to check whether the {@link ProductCSVReader} class
	 * gets all the products correctly. Total products is 9,
	 * If it contains all the products its size should be 9
	 * 
	 * @throws InvalidDataFormatException handles any incorrect format in data.
	 * @throws ProductFileNotReadableException it is thrown when file is present, but not readable
	 * @throws ProductFileNotFoundException if the file is not available in given location.
	 *
	 */
	@Test
	public void ifContainsAllProducts() throws InvalidDataFormatException, ProductFileNotFoundException, ProductFileNotReadableException
	{
		int size = new ProductCSVReader().getAllProducts().size();
		LOGGER.debug("Returning "+size+" products for getAllProducts().");
		assertEquals(9, size);    //ProductCSVReader
	}
	
	/**
	 * This test case is used to check the extension of the source file.
	 * The given source file contains .csv extension, so we have to check if the
	 * extension of the file is correct.
	 */
	@Test
	public void checkExtensionOfFile()
	{
		LOGGER.debug("Checking extension of file for (.csv)");
		assertTrue(ProductCSVReader.PRODUCT_FILENAME.endsWith(".csv"));    //ProductCSVReader
	}
	
	/**
	 * This testcase is used to check the getProductForType() method in
	 * {@link ProductService} class. The file contains 3 mobiles.
	 * If "Mobile" is passed as arguments, then it should 
	 * return 3 products of mobile type and its size is 3.
	 * @throws InvalidDataFormatException handles any incorrect format in data.
	 * @throws ProductFileNotReadableException it is thrown when file is present, but not readable
	 * @throws ProductFileNotFoundException if the file is not available in given location.
	 *
	 */
	@Test
	public void testListSize_Mobile() throws InvalidDataFormatException, ProductFileNotFoundException, ProductFileNotReadableException
	{
		String type="Mobile";
		LOGGER.debug("Checking with product type "+type);
		assertEquals(3, new ProductService().getProductForType(type).size());
	}
	
	/**
	 * This testcase is used to check the getProductForType() method in
	 * {@link ProductService} class. The file contains 2 laptops.
	 * If "Mobile" is passed as arguments, then it should 
	 * return 2 products of laptop type and its size is 2.
	 * @throws InvalidDataFormatException handles any incorrect format in data.
	 * @throws ProductFileNotReadableException it is thrown when file is present, but not readable
	 * @throws ProductFileNotFoundException if the file is not available in given location.
	 * 
	 */
	@Test
	public void testListSize_Laptop() throws InvalidDataFormatException, ProductFileNotFoundException, ProductFileNotReadableException
	{
		String type="laptop";
		LOGGER.debug("Checking with product type "+type);
		assertEquals(2, new ProductService().getProductForType(type).size());
	}
	
	/**
	 * This testcase is used to check the getProductForType() method in
	 * {@link ProductService} class. The file contains 0 Furnitures.
	 * If "Furnitures" is passed as arguments, then it should 
	 * return empty list and its size is 0.
	 * @throws InvalidDataFormatException handles any incorrect format in data.
	 * @throws ProductFileNotReadableException it is thrown when file is present, but not readable
	 * @throws ProductFileNotFoundException if the file is not available in given location.
	 *
	 */
	@Test
	public void testEmptyList_Furnitures() throws InvalidDataFormatException, ProductFileNotFoundException, ProductFileNotReadableException
	{
		LOGGER.debug("Checking for \"Furnitures\" type");
		assertEquals(0, new ProductService().getProductForType("Furnitures").size());
		
		//or
	//	assertTrue(new ProductService().getProductForType("Furnitures").isEmpty());
	}
	
	/**
	 * This testcase is used to check the buildProduct() method
	 * in {@link Product} class.
	 * Here, price is containing a string value which is expected to 
	 * get an exception {@link InvalidDataFormatException}
	 * @throws InvalidDataFormatException handles any incorrect format in data.
	 */
	@Test(expected=InvalidDataFormatException.class)
	public void shouldThrowInvalidDataFormatException_forPrice() throws InvalidDataFormatException
	{
		LOGGER.debug("Throw an InvalidDataFormatException for price 55,000");
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("Price","55,000");
		new Product().buildProduct(map);
	}
	
	/**
	 * This test case is used to check the buildProduct() method
	 * in {@link Product} class.
	 * Here, date is containing a string value which is expected to 
	 * get an exception while parsing {@link InvalidDataFormatException}
	 * @throws InvalidDataFormatException handles any incorrect format in data.
	 */	
	@Test(expected=InvalidDataFormatException.class)
	public void shouldThrowInvalidDataFormatException_forDate() throws InvalidDataFormatException
	{
		LOGGER.debug("Throw an InvalidDataFormatException for date 12/03/abc2016");
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("Price","55000");
		map.put("ManufecturedDt","12/03/abc2016");
		new Product().buildProduct(map);
	}
	
	/**
	 * This testcase is used to check the setPrice() method
	 * in {@link Product} class. If a negative value is passed as
	 * price, we have to get {@link InvalidPriceException}
	 * @throws InvalidPriceException handles price related exceptions.
	 */
    @Test(expected=InvalidPriceException.class)
    public void shouldThrowInvalidPriceException_price() throws InvalidPriceException
    {
    	LOGGER.debug("Throw an InvalidPriceException for Negative price.");
    	new Product().setPrice(-5000d);
    }
}
