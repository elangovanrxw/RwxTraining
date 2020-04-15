package com.reactiveworks.restiplexercise.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.reactiveworks.restiplexercise.dao.exception.DAOException;
import com.reactiveworks.restiplexercise.deliveries.dao.IDeliveriesDAO;
import com.reactiveworks.restiplexercise.deliveries.dao.factory.DeliveriesDAOFactory;
import com.reactiveworks.restiplexercise.matches.dao.IMatchesDAO;
import com.reactiveworks.restiplexercise.matches.dao.factory.MatchesDAOFactory;
import com.reactiveworks.restiplexercise.model.CompleteFieldCountDetail;
import com.reactiveworks.restiplexercise.model.CompleteRunRateDetail;
import com.reactiveworks.restiplexercise.model.CompleteScoreDetail;
import com.reactiveworks.restiplexercise.model.Deliveries;
import com.reactiveworks.restiplexercise.model.Matches;
import com.reactiveworks.restiplexercise.resource.exception.ResourceException;
import com.reactiveworks.restiplexercise.service.exception.DataNotFoundException;
import com.reactiveworks.restiplexercise.service.exception.ServiceException;
import com.reactiveworks.restiplexercise.service.impl.CricketService;
import com.reactiveworks.restiplexercise.service.impl.CricketServiceImpl;

@Path("/service")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CricketServiceResource {

	/**
	 * Logger implementation.
	 */
	private static final Logger LOGGER = Logger.getLogger(CricketServiceResource.class);
	
	CricketService service= new CricketService();
	
	/**
	 * An HTTP method which is used to get all the details of the score details.
	 * @param year to filter the data according to the year.
	 * @return the required response.
	 * @throws ResourceException if any error happens while performing the service.
	 */
	@GET
	@Path("/getScoreDetails")
	public Response getScoreDetails(@QueryParam("year") int year) throws ResourceException {
		try {
			List<CompleteScoreDetail> scoreDetails = service.getScoreDetails(year);									
			GenericEntity<List<CompleteScoreDetail>> scoreDetailsEntity = new GenericEntity<List<CompleteScoreDetail>>(scoreDetails) {};
			return Response.status(Status.OK).entity(scoreDetailsEntity).build();
		}
		catch (DataNotFoundException dnfExp) {
			LOGGER.error("No data found for the given parameters.",dnfExp);
			throw new ResourceException(dnfExp.getMessage(),Status.NOT_FOUND.getStatusCode());
		}
		catch(Exception e) {
			LOGGER.error("Unable to perform the score detail service because an error occured.",e);
			throw new ResourceException("Unable to perform the score detail service because an error occured.",e,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
		
	}
	
	/**
	 * An HTTP method which is used to get all the details of the run rate details.
	 * @param year to filter the data according to the year.
	 * @return the required response.
	 * @throws ResourceException if any error happens while performing the service.
	 */
	@GET
	@Path("/getHighestRunRateTeamName")
	public Response getHighestRunRateTeamName(@QueryParam("year") int year) throws ResourceException {
		try {
			List<CompleteRunRateDetail> runRateDetails = service.getHighestRunRateTeamName(year);
			GenericEntity<List<CompleteRunRateDetail>> runRateDetailsEntity = new GenericEntity<List<CompleteRunRateDetail>>(runRateDetails) {};
			return Response.status(Status.OK).entity(runRateDetailsEntity).build();
		}
		catch (DataNotFoundException dnfExp) {
			LOGGER.error("No data found for the given parameters.",dnfExp);
			throw new ResourceException(dnfExp.getMessage(),Status.NOT_FOUND.getStatusCode());
		}
		catch(Exception e) {
			LOGGER.error("Unable to perform the run rate service because an error occured.",e);
			throw new ResourceException("Unable to perform the run rate service because an error occured.",e,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
	}
	
	/**
	 * An HTTP method which is used to get all the details of the field count details.
	 * @param limit to limit the field count records.
	 * @return the required response.
	 * @throws ResourceException if any error happens while performing the service.
	 */
	@GET
	@Path("/getFieldCountOfTeams")
	public Response getFieldCountOfTeams(@QueryParam("limit") int limit) throws ResourceException {
		try {
			List<CompleteFieldCountDetail> fieldCountDetails = service.getFieldCountOfTeams(limit);
			GenericEntity<List<CompleteFieldCountDetail>> fieldCountDetailsEntity = new GenericEntity<List<CompleteFieldCountDetail>>(fieldCountDetails) {};
			return Response.status(Status.OK).entity(fieldCountDetailsEntity).build();
		}
		catch (ServiceException se) {
			LOGGER.error("Cannot perform the field count service.",se);
			throw new ResourceException("Cannot perform the field count service.",se,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
		catch(Exception e) {
			LOGGER.error("Unable to perform the field count service because an error occured.",e);
			throw new ResourceException("Unable to perform the field count service because an error occured.",e,Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
	}
}
