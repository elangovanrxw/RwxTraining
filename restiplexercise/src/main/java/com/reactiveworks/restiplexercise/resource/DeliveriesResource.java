package com.reactiveworks.restiplexercise.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.reactiveworks.restiplexercise.model.Deliveries;
import com.reactiveworks.restiplexercise.resource.exception.ResourceException;
import com.reactiveworks.restiplexercise.service.exception.DataNotFoundException;
import com.reactiveworks.restiplexercise.service.exception.ServiceException;
import com.reactiveworks.restiplexercise.service.impl.DeliveriesService;

@Path("/deliveries")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class DeliveriesResource {

	/**
	 * Logger implementation.
	 */
	private static final Logger LOGGER = Logger.getLogger(MatchesResource.class);
	
	DeliveriesService deliveryService = new DeliveriesService();
	/**
	 * An HTTP method to get all the deliveries data from the resource.
	 * @return a response indicating the request is success or failure.
	 * @throws ResourceException if any error occurs when accessing the resource.
	 */
	@GET
	public Response getAllDeliveries(@BeanParam DeliveriesFilterBean filter) throws ResourceException {
		LOGGER.debug("Inside GET method for getting deliveries in the resources.");
		try {
			List<Deliveries> deliveries = deliveryService.getAllDeliveriesForMatchId(filter);
			GenericEntity<List<Deliveries>> genEntityForDeliveries = new GenericEntity<List<Deliveries>>(deliveries) {};
			Response response = Response.status(Status.OK).entity(genEntityForDeliveries).build();
			return response;
		} catch (DataNotFoundException dnfExp) {
			LOGGER.error("No data found for the given parameters.",dnfExp);
			throw new ResourceException(dnfExp.getMessage(),Status.NOT_FOUND.getStatusCode());
		}
		catch (ServiceException se) {
			LOGGER.error("Unable to get the deliveries data from the resource.",se);
			throw new ResourceException("Unable to get the deliveries data from the resource.",se,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
		catch (Exception e) {
			LOGGER.error("Unable to access the deliveries resource",e);
			throw new ResourceException("Unable to access the deliveries resource",e,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
	}
	
}
