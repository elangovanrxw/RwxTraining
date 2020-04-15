package com.reactiveworks.restiplexercise.deliveries.dao.factory;

import org.apache.log4j.Logger;

import com.reactiveworks.restiplexercise.deliveries.dao.IDeliveriesDAO;
import com.reactiveworks.restiplexercise.deliveries.dao.impl.DeliveriesDAOSQLImpl;

/**
 * A factory class to provide the instance of the {@link IDeliveriesDAO}
 * 
 * @author Elangovan
 *
 */
public class DeliveriesDAOFactory {

	/**
	 * Logger Implementation.
	 */
	private static final Logger LOGGER = Logger.getLogger(DeliveriesDAOFactory.class);
	
	/**
	 * Instance of {@link IDeliveriesDAO}
	 */
	private static IDeliveriesDAO deliveryDAOInstance;
	
	
	/**
	 * A static method which is used to get the instance.
	 * @return the instance of {@link IDeliveriesDAO}
	 */
	public static IDeliveriesDAO getDeliveriesInstance() {
		
		if(deliveryDAOInstance == null) {
			deliveryDAOInstance = new DeliveriesDAOSQLImpl();
		}
		return deliveryDAOInstance;
	}
}
