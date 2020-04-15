package com.reactiveworks.stocktrade.spring.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.reactiveworks.stocktrade.dao.IStockTradeDAO;
import com.reactiveworks.stocktrade.dao.StockTradeDAOFactory;

/**
 * Configuration class for the spring framework.
 * @author Elangovan
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@PropertySource("classpath:dbtype.properties")
public class StockTradeConfiguration {

	/**
	 * To load from the properties file
	 */
	@Autowired
	private Environment env;
	
	
	/**
	 * a bean of {@link PlatformTransactionManager} containing a data source.
	 * @return instance of {@link DataSourceTransactionManager}
	 */
	@Bean
	public PlatformTransactionManager platformTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	/**
	 * DataSource configuration from the properties file.
	 * @return a {@link DataSource} with database configuration.
	 */
	@Bean
	public DataSource dataSource() {
		
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(env.getRequiredProperty("db.url"));
		ds.setUsername(env.getRequiredProperty("db.username"));
		ds.setPassword(env.getRequiredProperty("db.password"));
		ds.setMinIdle(Integer.parseInt(env.getRequiredProperty("db.minIdle")));

		return ds;  
	}
	
	/**
	 * Bean to return the instance of the {@link JdbcTemplate} to perform Database operations.
	 * @return
	 */
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	/**
	 * Based on the database implementation type, it is used to return the 
	 * instance of the DAO from the factory class {@link StockTradeDAOFactory}
	 * @return an DAO instance.
	 */
	@Bean
	public IStockTradeDAO daoInstance() {
		StockTradeDAOFactory.dbType = env.getRequiredProperty("db.type");
		return StockTradeDAOFactory.getStockTradeDAOInstance();
	}
}
