package com.reactiveworks.webservice.impl;

import com.reactiveworks.productwithsoapserver.dao.exception.ProductDAOException;
import com.reactiveworks.productwithsoapserver.dao.impl.ProductDAOSQLImpl;
import com.reactiveworks.productwithsoapserver.model.Product;
import com.reactiveworks.webservice.ProductOperation;

public class ProductOperationImpl implements ProductOperation {

	ProductDAOSQLImpl dao = new ProductDAOSQLImpl();
	
	@Override
	public String createProductOperation(Product product) throws ProductDAOException {
		return dao.createProduct(product);
	}

	@Override
	public Product getProductByNameOperation(String productName) throws ProductDAOException {
		return dao.getProductByProductName(productName);
	}

	@Override
	public String updateProductOperation(Product product) throws ProductDAOException {
		return dao.updateProduct(product);
	}

	@Override
	public Product getProductByIdOperation(String productId) throws ProductDAOException {
		return dao.getProductByProductId(productId);
	}

	@Override
	public String deleteProductOperation(String productId) throws ProductDAOException {
		return dao.deleteProduct(productId);
	}

}
