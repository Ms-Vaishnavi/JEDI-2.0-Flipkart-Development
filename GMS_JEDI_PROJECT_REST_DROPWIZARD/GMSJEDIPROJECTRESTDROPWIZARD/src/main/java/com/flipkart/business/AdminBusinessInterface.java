package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;

import java.util.*;

/**
 * Admin Business Interface
 */
public interface AdminBusinessInterface{
	/**
	 * Obtains a list of every gym owner within the system.
	 * @return List of GymOwner objects
	 */
    public List<GymOwner> getGymOwners();
   
	/**
	 * Obtains a list of every gym within the system.
	 * @return List of Gym objects
	 */
    public List<Gym> getGym() ;
    
    /**
	 * Returns all GymOwners object whose requests are pending for approval.
	 * @return List of GymOwner objects
	 */
    public List<GymOwner> viewAllPendingGymOwnerRequests();
    
    /**
	 * Accepts one request from a gym owner. 
	 * @param gymOwnerEmail The request's email that has to be approved
	 * @throws GymOwnerNotFoundException when gymOwnerEmail is not found
	 */
    public void approveSingleGymOwnerRequest(String gymOwnerEmail) throws GymOwnerNotFoundException;
   
    /**
	 * Approves all GymOwners whose requests are pending for approval. 
	 */
    public void approveAllPendingGymOwnerRequests();
    
    /**
	 * Returns all Gym object whose requests are pending for approval. 
	 * @return List of Gym objects
	 */
    public List<Gym> viewAllPendingGymRequests();
    
    /**
	 * Approves a single Gym object request. 
	 * @param gymId the id of a gym that needs to be approved
	 * @throws GymNotFoundException when gymId is not found
	 */
    public void approveSingleGymRequest(String gymId) throws GymNotFoundException;
   
    /**
	 * Approves all Gym whose requests are pending for approval. 
	 */
    public void approveAllPendingGymRequests();
    
}
