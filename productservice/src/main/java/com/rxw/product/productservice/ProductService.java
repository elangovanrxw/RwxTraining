package com.rxw.product.productservice;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.rxw.product.domain.Product;
import com.rxw.product.exception.InvalidDataFormatException;
import com.rxw.product.exception.ProductFileNotFoundException;
import com.rxw.product.exception.ProductFileNotReadableException;
import com.rxw.product.reader.ProductCSVReader;
import com.rxw.product.service.IProductService;

/**
 * A class for performing specific tasks
 * regarding the products.
 * @author Elangovan
 * @see IProductService
 */
public class ProductService implements IProductService  {
	
	private static final Logger LOGGER = Logger.getLogger(ProductService.class);
	/**
	 * contains the complete list of products
	 */
	private List<Product> productList;
	/**
	 * contains the list of products belonged to the specific category.
	 */
	private List<Product> productForType;
	
	/**
	 * Reads all the products from {@link ProductCSVReader}
	 * @throws InvalidDataFormatException handles any incorrect format in data
	 * @throws ProductFileNotReadableException thrown when the file is not readable.
	 *
	 */
	public ProductService() throws InvalidDataFormatException, ProductFileNotFoundException, ProductFileNotReadableException {
		LOGGER.debug("[ACTION] Getting all products");
		productList = new ProductCSVReader().getAllProducts();
	}

	/**
	 * @param productType the type of product that user have to pass 
	 * to this method.
	 * @return the list of products belonged to the category that user passed.
	 */
	public List<Product> getProductForType(String productType) {
		
		productForType = new ArrayList<Product>();
		LOGGER.debug("Getting products for "+productType+"\" as a product type.");
		for(int i=0;i<productList.size();i++)
		{
			if(productList.get(i).getProductType().equalsIgnoreCase(productType))
				productForType.add(productList.get(i));
		}
		if(productForType.size()==0) {
			LOGGER.warn("Specific product for type is null ");
		}
		LOGGER.info("Specific product type returning "+productForType.size()+" products for category "+productType);
		return productForType;
	}
}
