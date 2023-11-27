/**
 * 
 */
package com.flipkart.business;
import java.util.*;
import com.flipkart.DAO.*;

import com.flipkart.DAO.AdminDAOImpl;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;

/**
 * This class gives the Gym Management System's admin operations capabilities by implementing the AdminGMSInterface.
 */
public class AdminBusiness implements AdminBusinessInterface{
	AdminDAO adminDAO = new AdminDAOImpl();
	GymOwnerDAO gymOwnerDAO = new GymOwnerDAOImpl();
	/**
	 * Obtains a list of every gym owner within the system.
	 * @return List of GymOwner objects
	 */
	public List<GymOwner> getGymOwners() {
		
		return adminDAO.getAllGymOwners();
	}
	/**
	 * Obtains a list of every gym within the system.
	 * @return List of Gym objects
	 */
	public List<Gym> getGym() {
		return adminDAO.getAllGyms();
	}

	/**
	 * Returns all GymOwners object whose requests are pending for approval.
	 * @return List of GymOwner objects
	 */
	public List<GymOwner> viewAllPendingGymOwnerRequests() {
		return adminDAO.getPendingGymOwnerRequests();
	}

	/**
	 * Accepts one request from a gym owner. 
	 * @param gymOwnerEmail The request's email that has to be approved
	 * @throws GymOwnerNotFoundException 
	 */
	public void approveSingleGymOwnerRequest(String gymOwnerEmail) throws GymOwnerNotFoundException {
		int approvedCount = adminDAO.approveSingleOwnerRequest(gymOwnerEmail);
		if (approvedCount == 0)
			throw new GymOwnerNotFoundException();
		System.out.println("Approved gym owner request! " + gymOwnerEmail);
	}

	/**
	 * Approves all GymOwners whose requests are pending for approval. 
	 */
	public void approveAllPendingGymOwnerRequests() {
		int approvedCount = adminDAO.approveAllOwnerRequest();
		if (approvedCount != 0)
			System.out.println("Approved all pending gym owner requests!");
		else
			System.out.println("No pending gym owner requests!");
	}
	/**
	 * Returns all Gym object whose requests are pending for approval. 
	 * @return List of Gym objects
	 */
	public List<Gym> viewAllPendingGymRequests() {
		System.out.println("Fetched pending gym requests successfully!");
		return adminDAO.getPendingGymRequests();
	}
	/**
	 * Approves a single Gym object request. 
	 * @param gymId the id of a gym that needs to be approved
	 * @return true if the gymId is valid else returns false
	 * @throws GymNotFoundException 
	 */
	public void approveSingleGymRequest(String gymId) throws GymNotFoundException {
		int approvedCount = adminDAO.approveSingleGymRequest(gymId);
		if (approvedCount == 0)
			throw new GymNotFoundException();
		System.out.println("Successfully approved gym request! " + gymId);
	}
	/**
	 * Approves all Gym whose requests are pending for approval. 
	 */
	public void approveAllPendingGymRequests() {
		int approvedCount = adminDAO.approveAllGymRequest();
		if (approvedCount > 0)
			System.out.println("Successfully approved all pending gym requests!");
		else 
			System.out.println("No pending gym requests");
	}
}
