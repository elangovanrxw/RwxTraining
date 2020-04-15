package com.reactiveworks.restiplexercise.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.reactiveworks.restiplexercise.dao.exception.DAOException;
import com.reactiveworks.restiplexercise.matches.dao.IMatchesDAO;
import com.reactiveworks.restiplexercise.matches.dao.factory.MatchesDAOFactory;
import com.reactiveworks.restiplexercise.model.Matches;
import com.reactiveworks.restiplexercise.resource.exception.ResourceException;
import com.reactiveworks.restiplexercise.resource.responseobj.ErrorMessage;
import com.reactiveworks.restiplexercise.resource.responseobj.SuccessMessage;
import com.reactiveworks.restiplexercise.service.exception.DataNotFoundException;
import com.reactiveworks.restiplexercise.service.exception.RequiredFieldNotFoundException;
import com.reactiveworks.restiplexercise.service.exception.ServiceException;
import com.reactiveworks.restiplexercise.service.impl.MatchesService;

@Path("/matches")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class MatchesResource {

	/**
	 * Logger implementation.
	 */
	private static final Logger LOGGER = Logger.getLogger(MatchesResource.class);
	
	MatchesService matchesService = new MatchesService();
	
	/**
	 * An HTTP method to get all the matches data from the resource depending upon the params values.
	 * @param filter an instance that is containing the param values.
	 * @return a response indicating the request is success or failure.
	 * @throws ResourceException if any error occurs when accessing the resource.
	 */
	@GET
	public Response getAllMatches(@BeanParam MatchesFilterBean filter) throws ResourceException {
		
		try {
			List<Matches> matches = matchesService.getAllMatches(filter);
			GenericEntity<List<Matches>> genEntityForMatches = new GenericEntity<List<Matches>>(matches) {};
			Response response = Response.status(Status.OK).entity(genEntityForMatches).build();
			return response;			
		} catch (DataNotFoundException dnfExp) {
			LOGGER.error("No data found for the given parameters.",dnfExp);
			throw new ResourceException(dnfExp.getMessage(),Status.NOT_FOUND.getStatusCode());
		}
		catch (ServiceException se) {
			LOGGER.error("Unable to get the matches data from the resource.",se);
			throw new ResourceException("Unable to get the matches data from the resource.",se,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
		catch (Exception e) {
			LOGGER.error("Unable to access the matches resource",e);
			throw new ResourceException("Unable to access the matches resource",e,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
	}
	
	/**
	 * An HTTP method to get all the matches data from the resource for given matchId.
	 * @return a response indicating the request is success or failure.
	 * @throws ResourceException if any error occurs when accessing the resource.
	 */
	@GET
	@Path("/{matchId}")
	public Response getMatchforMatchId(@PathParam("matchId") int matchId) throws ResourceException {
		try {
			Matches match = matchesService.getMatchForId(matchId);
			Response response = Response.status(Status.OK).entity(match).build();
			return response;
		} catch (DataNotFoundException dnfExp) {
			LOGGER.error("No data found for the given matchId.",dnfExp);
			throw new ResourceException(dnfExp.getMessage(),Status.NOT_FOUND.getStatusCode());
		}
		catch (ServiceException se) {
			LOGGER.error("Unable to get the matches data from the resource.",se);
			throw new ResourceException("Unable to get the matches data from the resource.",se,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
		catch (RuntimeException e) {
			LOGGER.error("Unable to access the matches resource for matchid "+matchId,e);
			throw new ResourceException("Unable to access the matches resource for matchid "+matchId,e,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
	}
	
	/**
	 * An HTTP method to insert the matches data sent in request.
	 * @param match the parameter that is to be sent on the request.
	 * @return a response indicating the request is success or failure.
	 * @throws ResourceException if any error occurs when accessing the resource.
	 */
	@POST
	public Response insertMatch(Matches match) throws ResourceException {
		try {
			matchesService.insertMatch(match);			
			SuccessMessage successMsg = new SuccessMessage();
			successMsg.setOperation("success");
			successMsg.setSuccessMsg("The data is successfully inserted.");
			Response response = Response.status(Status.CREATED).entity(successMsg).build();
			return response;
		}
		catch (RequiredFieldNotFoundException rfnfExp) {
			LOGGER.error("Required Value is missing in the request",rfnfExp);
			throw new ResourceException(rfnfExp.getMessage(),Status.BAD_REQUEST.getStatusCode());
		}
		catch (ServiceException se) {
			LOGGER.error("Unable to insert the matches data to the resource.",se);
			throw new ResourceException("Unable to insert the matches data to the resource.",se,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
		catch (Exception e) {
			LOGGER.error("Unable to insert the matches resource",e);
			throw new ResourceException("Unable to insert the matches resource",e,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
	}
	
	/**
	 * An HTTP method to update the matches data sent in request.
	 * @param match the parameter that is to be sent on the request.
	 * @return a response indicating the request is success or failure.
	 * @throws ResourceException if any error occurs when accessing the resource.
	 */
	@PUT
	@Path("/{matchId}")
	public Response updateMatch(@PathParam("matchId") int matchId,Matches match) throws ResourceException, DAOException {
		try {
			matchesService.updateMatch(matchId,match);
			SuccessMessage successMsg = new SuccessMessage();
			successMsg.setOperation("success");
			successMsg.setSuccessMsg("The data is successfully updated for matchId "+matchId);
			Response response = Response.status(Status.OK).entity(successMsg).build();
			return response;
		}
		catch (DataNotFoundException dae) {
			LOGGER.error("Updating non-existing record.",dae);
			throw new ResourceException(dae.getMessage(),Status.BAD_REQUEST.getStatusCode());
		}
		catch (ServiceException se) {
			LOGGER.error("Unable to update the matches data to the resource.",se);
			throw new ResourceException("Unable to update the matches data to the resource.",se,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
		catch (Exception e) {
			LOGGER.error("Unable to update the matches resource.",e);
			throw new ResourceException("Unable to update the matches resource.",e,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}      
	}

	/**
	 * An HTTP method to delete the matches data for given matchId sent in request.
	 * @param matchId the parameter that is to be sent on the request.
	 * @return a response indicating the request is success or failure.
	 * @throws ResourceException if any error occurs when accessing the resource.
	 */
	@DELETE
	@Path("/{matchId}")
	public Response deleteMatch(@PathParam("matchId") int matchId) throws ResourceException {
		try {
			matchesService.deleteMatch(matchId);
			SuccessMessage successMsg = new SuccessMessage();
			successMsg.setOperation("success");
			successMsg.setSuccessMsg("The data is successfully deleted for matchId "+matchId);
			Response response = Response.status(Status.OK).entity(successMsg).build();
			return response;
		}
		catch (DataNotFoundException dae) {
			LOGGER.error("Deleting non-existing record.",dae);
			throw new ResourceException(dae.getMessage(),Status.BAD_REQUEST.getStatusCode());
		}
		catch (ServiceException se) {
			LOGGER.error("Unable to delete the matches data from the resource.",se);
			throw new ResourceException("Unable to delete the matches data from the resource.",se,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
		catch (Exception e) {
			LOGGER.error("Unable to delete the matches resource",e);
			throw new ResourceException("Unable to delete the update resource",e,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
	}
	
	@PATCH
	@Path("/{matchId}")
	public Response patchUpdateMatch(@PathParam("matchId") int matchId,Matches match) throws ResourceException {
		try {
			matchesService.updateMatch(matchId,match);
			SuccessMessage successMsg = new SuccessMessage();
			successMsg.setOperation("success");
			successMsg.setSuccessMsg("The data is successfully updated for matchId "+matchId);
			Response response = Response.status(Status.OK).entity(successMsg).build();
			return response;
		}
		catch (DataNotFoundException dae) {
			LOGGER.error("Updating non-existing record.",dae);
			throw new ResourceException(dae.getMessage(),Status.BAD_REQUEST.getStatusCode());
		}
		catch (ServiceException se) {
			LOGGER.error("Unable to update the matches data to the resource.",se);
			throw new ResourceException("Unable to update the matches data to the resource.",se,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
		catch (Exception e) {
			LOGGER.error("Unable to update the matches resource.",e);
			throw new ResourceException("Unable to update the matches resource.",e,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}      
	}
}
