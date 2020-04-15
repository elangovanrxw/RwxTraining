package com.rxw.product.service;

import java.util.List;


import com.rxw.product.domain.Product;
import com.rxw.product.exception.InvalidDataFormatException;
import com.rxw.product.exception.ProductFileNotFoundException;
import com.rxw.product.exception.ProductFileNotReadableException;

public interface IProductReader {

	public List<Product> getAllProducts() throws InvalidDataFormatException,
				ProductFileNotFoundException, ProductFileNotReadableException;
}
