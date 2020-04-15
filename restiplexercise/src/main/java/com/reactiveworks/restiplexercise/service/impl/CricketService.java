package com.reactiveworks.restiplexercise.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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
import com.reactiveworks.restiplexercise.service.exception.DataNotFoundException;
import com.reactiveworks.restiplexercise.service.exception.ServiceException;

public class CricketService {

	/**
	 * Logger implementation.
	 */
	private static final Logger LOGGER = Logger.getLogger(CricketService.class);
	
	/**
	 * Contains complete delivery list.
	 */
	private List<Deliveries> deliveriesList;
	
	/**
	 * Contains complete matches list.
	 */
	private List<Matches> matchesList;
	
	/**
	 * DAO instance to perform matches related DAO operations.
	 */
	private IMatchesDAO matchesDAO = MatchesDAOFactory.getMatchesInstance();
	
	/**
	 * DAO instance to perform deliveries related DAO operations.
	 */
	private IDeliveriesDAO deliveriesDAO = DeliveriesDAOFactory.getDeliveriesInstance();
	
	CricketServiceImpl impl= new CricketServiceImpl();
	
	/**
	 * Constructor to load the data from database to instance variables.
	 */
	public CricketService() {
		try {
			deliveriesList = deliveriesDAO.getAllDeliveries();
			matchesList = matchesDAO.getAllMatches();
		} catch (DAOException e) {
			LOGGER.debug("Error ocuured during value initialization.",e);
		}
	}
	
	/**
	 * This method is used to perform the score details of the operation
	 * @param year is used to filter the result according to the year.
	 * @return a list of score details.
	 * @throws ServiceException if any error occurs when performing the operation.
	 */
	public List<CompleteScoreDetail> getScoreDetails(int year) throws ServiceException {
		List<CompleteScoreDetail> scoreDetails = impl.getScoreDetails(deliveriesList, matchesList);
		if(year!=0) {
			List<CompleteScoreDetail> scoreDetailsForYear = scoreDetails.stream().filter( d-> d.getYear()==year).collect(Collectors.toList());
			if(scoreDetailsForYear.size()==0) {
				throw new DataNotFoundException("No score details for the given year :"+year);
			}
			return scoreDetailsForYear;
		}
		else {
			return scoreDetails;
		}
	}
	
	/**
	 * This method is used to perform the run rate details of the operation.
	 * @param year is used to filter the result according to the year.
	 * @return a list of run rate details.
	 * @throws ServiceException if any error occurs when performing the operation.
	 */
	public List<CompleteRunRateDetail>  getHighestRunRateTeamName(int year) throws ServiceException {
		List<CompleteRunRateDetail> runRateDetails = impl.getHighestRunRateTeamName(deliveriesList, matchesList);
		if(year!=0) {
			List<CompleteRunRateDetail> runRateDetailsForYear = runRateDetails.stream().filter( d-> d.getYear()==year).collect(Collectors.toList());
			if(runRateDetailsForYear.size()==0) {
				throw new DataNotFoundException("No run rate details for the given year :"+year);
			}
			return runRateDetailsForYear;
		}
		else {
			return runRateDetails;
		}
	}
	
	/**
	 * This method is used to perform the field count details of the operation.
	 * @param limit is used to filter the result according to the limit.
	 * @return a list of field count details.
	 * @throws ServiceException if any error occurs when performing the operation.
	 */
	public List<CompleteFieldCountDetail> getFieldCountOfTeams(int limit) throws ServiceException {
		List<CompleteFieldCountDetail> fieldCountDetails = impl.getFieldCountOfTeams(matchesList);
		if(limit!=0) {
			List<CompleteFieldCountDetail> limitedList =  fieldCountDetails.stream().sorted((a,b) -> a.getFieldCount()>b.getFieldCount()?-1:
															a.getFieldCount()<b.getFieldCount()?1:0).limit(limit).collect(Collectors.toList());
			return limitedList;
		}
		else {
			return fieldCountDetails;
		}
	}
}
