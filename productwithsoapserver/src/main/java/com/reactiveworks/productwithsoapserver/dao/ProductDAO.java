package com.reactiveworks.productwithsoapserver.dao;

import com.reactiveworks.productwithsoapserver.dao.exception.ProductDAOException;
import com.reactiveworks.productwithsoapserver.model.Product;

public interface ProductDAO {

	String INSERT_PRODUCT = "INSERT INTO PRODUCT(ID,NAME,CATEGORY,PRICE) VALUES(?,?,?,?)";
	String INSERT_CITIES = "INSERT INTO CITY(ID,CITY) VALUES (?,?)";
	
	String GET_BY_PRODUCTID = "SELECT * FROM PRODUCT WHERE ID=?";
	String GET_PRODUCT_CITIES ="SELECT CITY FROM CITY WHERE ID=?";
	String GET_BY_PRODUCTNAME = "SELECT * FROM PRODUCT WHERE NAME=?";
	String DELETE_PRODUCT = "DELETE FROM PRODUCT WHERE ID=?";
	String DELETE_PRODUCT_CITIES = "DELETE FROM CITY WHERE ID=?";
	String DB_FILE_NAME = "db.properties";
	
	String createProduct(Product product) throws ProductDAOException;
	
	String updateProduct(Product product) throws ProductDAOException;
	
	Product getProductByProductId(String productId) throws ProductDAOException;
	
	Product getProductByProductName(String productName) throws ProductDAOException;
	
	String deleteProduct(String productId) throws ProductDAOException;
}
