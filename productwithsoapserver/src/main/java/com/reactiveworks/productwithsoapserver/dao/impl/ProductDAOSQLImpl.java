package com.reactiveworks.productwithsoapserver.dao.impl;

import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.reactiveworks.productwithsoapserver.dao.ProductDAO;
import com.reactiveworks.productwithsoapserver.dao.exception.ProductDAOException;
import com.reactiveworks.productwithsoapserver.mapper.CitiesRowMapper;
import com.reactiveworks.productwithsoapserver.mapper.ProductRowMapper;
import com.reactiveworks.productwithsoapserver.model.Product;
import com.reactiveworks.webservice.exception.InvalidRequestException;

/**
 * An implementation class to perform the DAO related operations into the database.
 * @author Elangovan
 *
 */
public class ProductDAOSQLImpl implements ProductDAO {

	private JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = Logger.getLogger(ProductDAOSQLImpl.class);
	
	/**
	 * Default constructor to load the database configurations.
	 */
	public ProductDAOSQLImpl() {
		String file = this.getClass().getResource("/"+DB_FILE_NAME).getFile();
		try {
			FileReader fr = new FileReader(file);
			Properties prop = new Properties();
			prop.load(fr);
			BasicDataSource ds = new BasicDataSource();
			ds.setUrl(prop.getProperty("db.url"));
			ds.setUsername(prop.getProperty("db.username"));
			ds.setPassword(prop.getProperty("db.password"));
			ds.setMinIdle(Integer.parseInt(prop.getProperty("db.minIdle")));
			this.jdbcTemplate = new JdbcTemplate(ds);
			
		} catch (IOException e) {
			LOGGER.error("Database properties file cannot be loaded.");
		}
	}
	/**
	 * A meethod to create a new product to the database.
	 * @param product a new product which is to be created.
	 */
	@Override
	public String createProduct(Product product) throws ProductDAOException {

		LOGGER.debug("Inside Service createProduct() implementation");
		String returnMsg = "";
		int productRows=0;
		int citiesRows=0;
		try {
			LOGGER.debug("jdbctemplate is :"+jdbcTemplate);
			productRows = jdbcTemplate.update(INSERT_PRODUCT,product.getProductId(), product.getProductName(), product.getProductCategory(),
					product.getPrice());
			List<String> availableCities = product.getAvailableCities();
			for(int i=0;i<availableCities.size();i++) {
				citiesRows += jdbcTemplate.update(INSERT_CITIES, product.getProductId(),availableCities.get(i));
			}
		}
		catch(DataAccessException dae) {
			LOGGER.error("Cannot create new product because : "+dae.getMessage(),dae);
			throw new ProductDAOException("Cannot create new product because : "+dae.getMessage(),dae);
		}
		catch(Exception e) {
			LOGGER.error("Cannot create new product because : "+e.getMessage(),e);
			throw new ProductDAOException("Cannot create new product because : "+e.getMessage(),e);
		}
		if(productRows==1 && citiesRows>=1) {
			returnMsg = "The product is created successfully with productid '"+product.getProductId()+"' and productname '"+product.getProductName()+"'.";
		}		
		return returnMsg;		//returning return message.
	}

	/**
	 * A method to update the existing product in the database.
	 * @param product product with new details to be updated.
	 */
	@Override
	public String updateProduct(Product product) throws ProductDAOException {
		LOGGER.debug("Inside Service updateProduct() implementation");
		String returnMsg = "";
		int rows=0;
		try {
			rows = jdbcTemplate.update(getUpdateQuery(product), getUpdatingFieldValues(product));
			
		}catch(DataAccessException dae) {
			LOGGER.error("Unable to update the product because : "+dae.getMessage(),dae);
			throw new ProductDAOException("Unable to update the product because : "+dae.getMessage(),dae);
		}
		catch(Exception e) {
			LOGGER.error("Unable to update the product because : "+e.getMessage(),e);
			throw new ProductDAOException("Unable to update the product because : "+e.getMessage(),e);
		}
		if(rows==1) {
			returnMsg = "The product is updated successfully with data.";
		}
		return returnMsg;		//returning return message.
	}

	/**
	 * A helper method to determine which value is to be inserted into database.
	 * @param product which is to be determined.
	 * @return the value of the not null field.
	 */
	private Object[] getUpdatingFieldValues(Product product) {
		List<String> values = new ArrayList<String>();
		if(product.getProductName()!= null && !product.getProductName().isEmpty()) {
			values.add(product.getProductName());
		}
		if(product.getProductCategory()!= null && !product.getProductCategory().isEmpty()) {
			values.add(product.getProductCategory());
		}
		if(product.getPrice()!= null && !product.getPrice().isEmpty()) {
			values.add(product.getPrice());
		}
		values.add(product.getProductId());
		return values.toArray();
	}

	/**
	 * A helper method to determine which query is to be executed.
	 * @param product which is to be determined.
	 * @return the constructed query for the update function.
	 * @throws InvalidRequestException when the request to the server is invalid.
	 */
	private String getUpdateQuery(Product product) throws InvalidRequestException {
		String fields ="";
		boolean containsAtleastOneField = false;
		
		if(product.getProductName()!= null && !product.getProductName().isEmpty()) {
			containsAtleastOneField=true;
			fields+="NAME=?,";
		}
		if(product.getProductCategory()!= null && !product.getProductCategory().isEmpty()) {
			containsAtleastOneField=true;
			fields+="CATEGORY=?,";
		}
		if(product.getPrice()!= null && !product.getPrice().isEmpty()) {
			containsAtleastOneField=true;
			fields+="PRICE=?,";
		}

		if(containsAtleastOneField) {
			fields = fields.substring(0, fields.length()-1);		//To ignore the last ',' character.
		}
		else {
			LOGGER.error("Minimum one field value is required for Update Functionality");
			throw new InvalidRequestException("Minimum one field value is required for Update Functionality");
		}
		String updateQuery = "UPDATE PRODUCT SET "+fields+" WHERE ID=?";
		
		return updateQuery;
	}
	
	/**
	 * A method to get the product form the database by passing the product id.
	 * @param productId The id of the product which is to be fetched.
	 * @return the instance of the product.
	 */
	@Override
	public Product getProductByProductId(String productId) throws ProductDAOException {

		LOGGER.debug("Inside Service getProductByProductId() implementation");
		try {			
			Product product = jdbcTemplate.queryForObject(GET_BY_PRODUCTID, new ProductRowMapper(), productId);
			List<String> cities = jdbcTemplate.query(GET_PRODUCT_CITIES, new CitiesRowMapper(), productId);		
			product.setAvailableCities(cities);
			return product;
		}
		catch(DataAccessException dae) {
			LOGGER.error("Unable to fetch product for productId '"+productId+"' because : "+dae.getMessage(),dae);
			throw new ProductDAOException("Unable to fetch product for productId '"+productId+"' because : "+dae.getMessage(),dae);
		}
		catch (Exception e) {
			LOGGER.error("Unable to fetch product for productId '"+productId+"' because : "+e.getMessage(),e);
			throw new ProductDAOException("Unable to fetch product for productId '"+productId+"' because : "+e.getMessage(),e);
		}
	}

	/**
	 * A method to get the product form the database by passing product name.
	 * @param productName The name of the product which is to be fetched.
	 * @return the instance of the product.
	 */
	@Override
	public Product getProductByProductName(String productName) throws ProductDAOException {
		LOGGER.debug("Inside Service getProductByProductName() implementation");
		try {			
			Product product = jdbcTemplate.queryForObject(GET_BY_PRODUCTNAME, new ProductRowMapper(), productName);
			List<String> cities = jdbcTemplate.query(GET_PRODUCT_CITIES, new CitiesRowMapper(), product.getProductId());		
			product.setAvailableCities(cities);
			return product;
		}
		catch(DataAccessException dae) {
			LOGGER.error("Unable to fetch product for product name '"+productName+"' because : "+dae.getMessage(),dae);
			throw new ProductDAOException("Unable to fetch product for product name '"+productName+"' because : "+dae.getMessage(),dae);
		}
		catch (Exception e) {
			LOGGER.error("Unable to fetch product for product name '"+productName+"' because : "+e.getMessage(),e);
			throw new ProductDAOException("Unable to fetch product for product name '"+productName+"' because : "+e.getMessage(),e);
		}
	}

	/**
	 * A method to delete the data from the database for the given productId.
	 * @param productId  The name of the product which is to be deleted.
	 */
	@Override
	public String deleteProduct(String productId) throws ProductDAOException {
		LOGGER.debug("Inside Service deleteProduct() implementation");
		int productRows =0;
		int cityRows=0;
		String returnMsg="";
		try {
			productRows = jdbcTemplate.update(DELETE_PRODUCT, productId);
			cityRows = jdbcTemplate.update(DELETE_PRODUCT_CITIES,productId);
		}
		catch(DataAccessException dae) {
			LOGGER.error("Unable to delete the product for productId '"+productId+"' because : "+dae.getMessage(),dae);
			throw new ProductDAOException("Unable to delete the product for productId '"+productId+"' because : "+dae.getMessage(),dae);
		}
		catch (Exception e) {
			LOGGER.error("Unable to delete the product for productId '"+productId+"' because : "+e.getMessage(),e);
			throw new ProductDAOException("Unable to delete the product for productId '"+productId+"' because : "+e.getMessage(),e);
		}
		if(productRows ==1 && cityRows>=1) {
			returnMsg = "Product '"+productId+"' is deleted successfully";
		}
		return returnMsg;
	}

}
