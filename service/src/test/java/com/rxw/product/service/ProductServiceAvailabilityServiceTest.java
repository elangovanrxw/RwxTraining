package com.rxw.product.service;

import org.junit.*;
import com.rxw.product.base.Product;
import com.rxw.product.base.User;
import com.rxw.product.exception.FileHandlingException;
import com.rxw.product.exception.InvalidDataException;
import com.rxw.product.exception.NegativeOrZeroPriceException;
import com.rxw.product.exception.NotNumberException;
import com.rxw.product.readers.ProductCSVReader;
import com.rxw.product.readers.UserCSVReader;
import com.rxw.product.service.impl.ProductAvailabilityService;

import static org.junit.Assert.*;

import java.util.List;

public class ProductServiceAvailabilityServiceTest
{
	@Test(expected=InvalidDataException.class)
	public void shouldThrowInvalidDataException_forInvalidEmail() throws InvalidDataException {	
		new User().setEmail("invalidemail");
	}
	@Test(expected=NegativeOrZeroPriceException.class)
	public void shouldThrowNegativeOrZeroPriceException_forZeroPrice() throws NegativeOrZeroPriceException
	{
		new Product().setPrice(0d);
	}
	@Test
	public void messageForException_priceLessThanZero()
	{
		String message=null;
		double price=-5d;
		try {
			new Product().setPrice(price);
		} catch (NegativeOrZeroPriceException e) {
			message=e.getMessage();
		}
		assertEquals("Price cannot be less than 0 : "+ price, message);
	}
	@Test
	public void messageForException_priceIsZero()
	{
		String message=null;
		double price=0d;
		try {
			new Product().setPrice(price);
		} catch (NegativeOrZeroPriceException e) {
			message=e.getMessage();
		}
		assertEquals("Price cannot be zero : "+price, message);
	}
	
	@Test
	public void shouldPrintEmptyList_forWrongUserID() throws InvalidDataException, NegativeOrZeroPriceException, FileHandlingException, NotNumberException
	{
		ProductAvailabilityService service = new ProductAvailabilityService();
		assertEquals(0,service.getAllProductForUser("U1021").size());
	}
	
	@Test
	public void shouldPrintEmptyList_forWrongCategory() throws InvalidDataException, NegativeOrZeroPriceException, FileHandlingException, NotNumberException
	{
		ProductAvailabilityService service = new ProductAvailabilityService();
		assertEquals(0,service.getAllProductForUserForCategory("U1001","Furnitures").size());
	}
	
	@Test
	public void testListSize_userId_U1005_Mumbai() throws InvalidDataException, NegativeOrZeroPriceException, FileHandlingException, NotNumberException
	{
		ProductAvailabilityService service = new ProductAvailabilityService();
		List<Product> allProductForUser = service.getAllProductForUser("U1005");
		assertEquals(7, allProductForUser.size());
	}
	
	@Test
	public void testListSize_userId_U1003_Chennai() throws InvalidDataException, NegativeOrZeroPriceException, FileHandlingException, NotNumberException
	{
		ProductAvailabilityService service = new ProductAvailabilityService();
		List<Product> allProductForUser = service.getAllProductForUser("U1003");
		assertEquals(5, allProductForUser.size());
	}
	
	@Test
	public void testListSize_userId_U1005_category_Mobile() throws InvalidDataException, NegativeOrZeroPriceException, FileHandlingException, NotNumberException
	{
		ProductAvailabilityService service = new ProductAvailabilityService();
		List<Product> allProductForUser = service.getAllProductForUserForCategory("U1005","Mobile");
		assertEquals(4, allProductForUser.size());
	}
	
	@Test
	public void testListSize_userId_U1005_category_WashingMachin() throws InvalidDataException, NegativeOrZeroPriceException, FileHandlingException, NotNumberException
	{
		ProductAvailabilityService service = new ProductAvailabilityService();
		List<Product> allProductForUser = service.getAllProductForUserForCategory("U1005","WashingMachin");
		assertEquals(1, allProductForUser.size());
	}
	
	@Test
	public void testFileFormatForUserCSVReader()
	{
		UserCSVReader userReader = new UserCSVReader();
		String filename = userReader.USER_FILENAME;
		assertTrue(filename.endsWith(".csv"));
	}
	
	@Test
	public void testFileFormatForProductCSVReader()
	{
		ProductCSVReader productReader = new ProductCSVReader();
		String filename = productReader.PRODUCT_FILENAME;
		assertTrue(filename.endsWith(".csv"));
	}
	
	@Test
	public void testWhetherUserCSVReaderReadsAllUsers() throws InvalidDataException, FileHandlingException
	{
		UserCSVReader userReader = new UserCSVReader();
		List<User> allUsers = userReader.getAllUsers();
		assertEquals(11, allUsers.size());
	}
	
	@Test
	public void testWhetherProductCSVReaderReadsAllProducts() throws NegativeOrZeroPriceException, FileHandlingException, NotNumberException 
	{
		ProductCSVReader productReader =new ProductCSVReader();
		List<Product> allProducts = productReader.getAllProducts();
		assertEquals(14, allProducts.size());
	}
	
}