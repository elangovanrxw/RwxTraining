package com.reactiveworks.restiplexercise.service;

import java.util.List;

import com.reactiveworks.restiplexercise.model.CompleteFieldCountDetail;
import com.reactiveworks.restiplexercise.model.CompleteRunRateDetail;
import com.reactiveworks.restiplexercise.model.CompleteScoreDetail;
import com.reactiveworks.restiplexercise.model.Deliveries;
import com.reactiveworks.restiplexercise.model.Matches;




/**
 * An interface for the cricket service implementation class.
 * @author Elangovan
 *
 */
public interface ICricketService {
	
	/**
	 * A method to get the total number of fours, sixes, total score with respect to team and year.
	 * @param deliveries all deliveries details in all the years that match has happened.
	 * @param matches all matches details in all the years that match has happened.
	 * @return an instance of {@link CompleteScoreDetail} which contains total details.
	 */
	public List<CompleteScoreDetail> getScoreDetails(List<Deliveries> deliveries,List<Matches> matches);
	
	/**
	 * A method to get the highest run rate team name with respect to the year.
	 * @param deliveries total deliveries data for all years in the form of List.
	 * @param matches total matches data for all years in the form of List.
	 * @return an instance of {@link CompleteRunRateDetail} which contains total details.
	 */
	public List<CompleteRunRateDetail> getHighestRunRateTeamName(List<Deliveries> deliveries,List<Matches> matches);
	
	/**
	 * A method to get the field count team name with respect to the year.
	 * @param matches total matches data for all years in the form of List.
	 * @return an instance of {@link CompleteFieldCountDetail} which contains total details.
	 */
	public List<CompleteFieldCountDetail> getFieldCountOfTeams(List<Matches> matches);
	
	
}
