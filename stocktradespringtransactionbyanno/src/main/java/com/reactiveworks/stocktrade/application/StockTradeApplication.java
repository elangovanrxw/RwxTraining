package com.reactiveworks.stocktrade.application;

import org.apache.log4j.Logger;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.reactiveworks.stocktrade.dao.exception.StockTradeSpringException;
import com.reactiveworks.stocktrade.spring.configuration.StockTradeConfiguration;

/**
 * A class that contains the Spring container configuration details.
 * @author Elangovan
 *
 */
public class StockTradeApplication {
	
	/**
	 * Logger implementation.
	 */
	private static final Logger LOGGER = Logger.getLogger(StockTradeApplication.class);
	
	/**
	 * This method is used to start the spring container.
	 * @return the instance of {@link ClassPathXmlApplicationContext}
	 * @throws StockTradeSpringException in case, the spring container is not able to start.
	 */
	public static ApplicationContext startAndGetContext() throws StockTradeSpringException {
		
		try {
			ApplicationContext context = new AnnotationConfigApplicationContext(StockTradeConfiguration.class);
			return context;
		}
		catch(BeansException beansExp) {
			LOGGER.debug("Unable to start the Spring Container.",beansExp);
			throw new StockTradeSpringException("Unable to start the Spring Container.",beansExp);
		}
	}
}
