package com.rxw.product.service;

import java.util.*;

import com.rxw.product.base.Product;

public interface IProductAvailabilityService {

	public List<Product> getAllProductForUser(String userId);
	
	public List<Product> getAllProductForUserForCategory(String userId,String productCategory);
			
	
}
