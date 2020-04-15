package com.rxw.product.service;

import java.util.List;
import com.rxw.product.domain.Product;
import com.rxw.product.productservice.ProductService;

/**
 * An interface which is to be implemented in {@link ProductService}
 * @author Elangovan
 *
 */
public interface IProductService {

	public List<Product> getProductForType(String productType);
}
