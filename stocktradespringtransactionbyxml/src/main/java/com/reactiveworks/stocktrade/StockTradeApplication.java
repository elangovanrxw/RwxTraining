package com.reactiveworks.stocktrade;

import org.apache.log4j.Logger;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.reactiveworks.stocktrade.exception.StockTradeSpringException;

/**
 * A class that contains the Spring container configuration details.
 * @author Elangovan
 *
 */
public class StockTradeApplication {

	/**
	 * Spring Configuration file name.
	 */
	public static final String CONFIG_FILE = "springcfg.xml";
	
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
			ApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_FILE);
			return context;
		}
		catch(BeansException beansExp) {
			LOGGER.debug("Unable to start the Spring Container.",beansExp);
			throw new StockTradeSpringException("Unable to start the Spring Container.",beansExp);
		}
	}
	
	public static void closeContainer(ApplicationContext context) throws StockTradeSpringException {
		try {
			((AbstractApplicationContext) context).close();
		}
		catch(BeansException beansExp) {
			LOGGER.debug("Unable to close the Spring Container.",beansExp);
			throw new StockTradeSpringException("Unable to close the Spring Container.",beansExp);
		}
	}
}
