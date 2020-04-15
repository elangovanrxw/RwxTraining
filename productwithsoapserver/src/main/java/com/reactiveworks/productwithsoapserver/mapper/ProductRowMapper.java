package com.reactiveworks.productwithsoapserver.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.reactiveworks.productwithsoapserver.model.Product;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setProductId(rs.getString(1));
		product.setProductName(rs.getString(2));
		product.setProductCategory(rs.getString(3));
		product.setPrice(rs.getString(4));
		
		return product;
	}



}
