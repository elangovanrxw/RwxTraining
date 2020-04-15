package com.reactiveworks.productwithsoap;

import com.reactiveworks.webservice.Product;
import com.reactiveworks.webservice.ProductDAOException_Exception;
import com.reactiveworks.webservice.ProductOperation;
import com.reactiveworks.webservice.ProductOperationService;

public class Main {

	public static void main(String[] args) throws ProductDAOException_Exception {
		ProductOperationService pos = new ProductOperationService();
		ProductOperation opImpl = pos.getProductOperation();
		
		Product product = new Product();
		product.setProductId("P1004");
		product.setProductName("oppo mobile");
		product.setPrice("15000");
		product.setProductCategory("MobilePhone");
		product.getAvailableCities().add("Banglore");
		product.getAvailableCities().add("Chennai");
		product.getAvailableCities().add("Mumbai");
		product.getAvailableCities().add("Coimbatore");
		
		String result = opImpl.createProductOperation(product);
		System.out.println("Create Result : "+result);
		
/*		product.setProductId("P1001");
		product.setProductName("BOAT headset 3.5mm");
		
		String result = opImpl.updateProductOperation(product);
		System.out.println("Update name Result : "+result);*/
		
	/*	product.setProductId("P1001");
		product.setPrice("560");
		
		String result = opImpl.updateProductOperation(product);
		System.out.println("Update price Result : "+result);*/
		
	//	product = opImpl.getProductByIdOperation("P1002");
	/*    product = opImpl.getProductByNameOperation("BOAT headset 3.5mm");
		System.out.println("Product ID      : "+product.getProductId());
		System.out.println("Product Name    : "+product.getProductName());
		System.out.println("Product Category: "+product.getProductCategory());
		System.out.println("Product Price   : "+product.getPrice());
		System.out.println("Available cities: "+product.getAvailableCities());*/
		
		
/*		String result = opImpl.deleteProductOperation("P1003");
		System.out.println("Delete Result : "+result);*/

	}
}
