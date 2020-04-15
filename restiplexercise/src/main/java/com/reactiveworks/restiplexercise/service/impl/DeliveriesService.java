package com.reactiveworks.restiplexercise.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.reactiveworks.restiplexercise.dao.exception.DAOException;
import com.reactiveworks.restiplexercise.deliveries.dao.IDeliveriesDAO;
import com.reactiveworks.restiplexercise.deliveries.dao.factory.DeliveriesDAOFactory;
import com.reactiveworks.restiplexercise.model.Deliveries;
import com.reactiveworks.restiplexercise.resource.DeliveriesFilterBean;
import com.reactiveworks.restiplexercise.service.exception.DataNotFoundException;
import com.reactiveworks.restiplexercise.service.exception.ServiceException;

/**
 * A service class which is used to perform the validations of deliveries before performing 
 * operations into the database.
 * @author Elangovan
 *
 */
public class DeliveriesService {

	/**
	 * Logger Implementation
	 */
	private static final Logger LOGGER = Logger.getLogger(DeliveriesService.class);
	
	/**
	 * DAO instance to perform dao operations.
	 */
	private static IDeliveriesDAO deliveriesDAO = DeliveriesDAOFactory.getDeliveriesInstance();
	
	/**
	 * This service method is used to get all the deliveries for the filter that has been
	 * passed to the method.
	 * @param filter instance of the {@link DeliveriesFilterBean} that is containing filter parameters.
	 * @return a list of deliveries.
	 * @throws ServiceException if any exception occurs in performing operations.
	 */
	public List<Deliveries> getAllDeliveriesForMatchId(DeliveriesFilterBean filter) throws ServiceException {
		int matchId= filter.getMatchId();
		int innings = filter.getInning();
		List<Deliveries> deliveries = null;
		try {
			if(matchId != 0) {
				List<Deliveries> deliveriesForMatchId = deliveriesDAO.getDeliveryForMatchId(matchId);
				if(deliveriesForMatchId.size()==0) {
					LOGGER.debug("Throwing DataNotFoundException because no deliveries data for matchId:"+matchId);
					throw new DataNotFoundException("The data is not found for match-id : "+matchId);
			//		throw new DataNotFoundException();
				}
				else if(innings !=0 ) {
					List<Deliveries> deliveryForInnings = deliveriesForMatchId.stream().filter(d -> d.getInning()==innings)
										.collect(Collectors.toList());
					if(deliveryForInnings.size()==0) {
						LOGGER.debug("Throwing DataNotFoundException because no deliveries data for matchId:"+matchId+", Innings: "+innings);
						throw new DataNotFoundException("Innings "+innings+" not happen for matchId: "+matchId);
			//			throw new DataNotFoundException();
					}
					deliveries = deliveryForInnings;
				}
				else {
					deliveries = deliveriesForMatchId;
				}
			}
			else if(matchId==0){
				LOGGER.debug("Throwing exception because no match Id is given in query parameter.");
				throw new DataNotFoundException("Match_ID value is mandatory to get the deliveries.");
			}
			return deliveries;
		}
		catch(DAOException dae) {
			LOGGER.error("Unable to get all data from the database."+dae);
			throw new ServiceException(dae);
		}
		catch (RuntimeException re) {
			LOGGER.error("Unable to get all data from the database."+re);
			throw new ServiceException(re);
		}
	}
}
