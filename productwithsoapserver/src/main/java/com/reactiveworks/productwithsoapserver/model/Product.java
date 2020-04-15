package com.reactiveworks.productwithsoapserver.model;

import java.util.List;

public class Product {

	private String productId;
	private String productName;
	private String productCategory;
	private String price;
	private List<String> availableCities;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public List<String> getAvailableCities() {
		return availableCities;
	}
	public void setAvailableCities(List<String> availableCities) {
		this.availableCities = availableCities;
	}
	
	
}
