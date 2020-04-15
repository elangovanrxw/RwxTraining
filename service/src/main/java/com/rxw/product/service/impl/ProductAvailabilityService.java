package com.rxw.product.service.impl;

import java.util.*;

import com.rxw.product.base.Product;
import com.rxw.product.base.User;
import com.rxw.product.exception.FileHandlingException;
import com.rxw.product.exception.InvalidDataException;
import com.rxw.product.exception.NegativeOrZeroPriceException;
import com.rxw.product.exception.NotNumberException;
import com.rxw.product.readers.ProductCSVReader;
import com.rxw.product.readers.UserCSVReader;
import com.rxw.product.service.IProductAvailabilityService;

public class ProductAvailabilityService implements IProductAvailabilityService
{
	 private List<Product> productList;
	 private List<User> userList;
	 
	 public ProductAvailabilityService() throws InvalidDataException,NegativeOrZeroPriceException, FileHandlingException, NotNumberException
	 {
		UserCSVReader userReader = new UserCSVReader();		
		ProductCSVReader productReader = new ProductCSVReader();
		userList=userReader.getAllUsers();
		productList=productReader.getAllProducts();
	 }

	@Override
	public List<Product> getAllProductForUser(String userId)
	{
		String userCity=null;
		for(int i=0;i<userList.size();i++)
		{
			if(userList.get(i).getUserId().equals(userId))
			{
				userCity=userList.get(i).getCity();
				break;
			}
		}
		List<Product> productsForUser = new ArrayList<Product>();
		for(int i=0;i<productList.size();i++)			
		{
			if(productList.get(i).getAvailableCity().contains(userCity))
				productsForUser.add(productList.get(i));
		}
		return productsForUser;
	}

	@Override
	public List<Product> getAllProductForUserForCategory(String userId, String productCategory)
	{

		List<Product> allProductForUser = (ArrayList<Product>)getAllProductForUser(userId);
		List<Product> allProductForUserForCategory = new ArrayList<Product>();

		for(int i=0;i<allProductForUser.size();i++)
		{
			if(allProductForUser.get(i).getProductCategory().equalsIgnoreCase(productCategory))
				allProductForUserForCategory.add(allProductForUser.get(i));
		}
		return allProductForUserForCategory;
		
	}
  
}
