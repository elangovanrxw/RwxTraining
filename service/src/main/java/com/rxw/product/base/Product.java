package com.rxw.product.base;

import java.util.*;

import com.rxw.product.exception.NegativeOrZeroPriceException;

public class Product {

	private String productId;
	private String productName;
	private String productCategory;
	private Double price;
	private List<String> availableCity;

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) throws NegativeOrZeroPriceException {
		if(price>0)
			this.price = price;
		else if(price<0)
			throw new NegativeOrZeroPriceException("Price cannot be less than 0 : "+ price);
		else
			throw new NegativeOrZeroPriceException("Price cannot be zero : "+price);
	}
	public List<String> getAvailableCity() {
		return availableCity;
	}
	public void setAvailableCity(List<String> availableCity) {
		this.availableCity = availableCity;
	}
	
	public String toString()
	{
		return productId+" "+productName+" "+productCategory+" "+price+" "+availableCity.toString();
	}
	
}
