package com.reactiveworks.restiplexercise.deliveries.dao;

import java.util.List;

import com.reactiveworks.restiplexercise.dao.exception.DAOException;
import com.reactiveworks.restiplexercise.model.Deliveries;

/**
 * An interface which is containing the structure of deliveries DAO functions
 * that is to be performed on the data source.
 * @author Elangovan
 *
 */
public interface IDeliveriesDAO {

	/**
	 * This method is used to read the data from the data source and convert that
	 * data into the form of List.
	 * @return a list of all deliveries for all match id.
	 */
	List<Deliveries> getAllDeliveries() throws DAOException;
	
	/**
	 * Used to delete deliveries data from the data source.
	 * @param matchId deliveries data to be fetched for the given matchId.
	 * @return a list of deliveries for the given match id.
	 * @throws DAOException if any exception occurs when performing DAO Operations.
	 */
	List<Deliveries> getDeliveryForMatchId(int matchId) throws DAOException;
}
