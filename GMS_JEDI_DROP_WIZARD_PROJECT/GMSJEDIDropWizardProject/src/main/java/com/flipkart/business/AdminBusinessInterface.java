package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;

import java.util.*;

public interface AdminBusinessInterface{
	 /*
    returns the list of all the gym owners
    */
    public List<GymOwner> getGymOwners();
   
    /*
    returns the list of all the gyms
    */
    public List<Gym> getGym() ;
    
    /*
    returns the list of all the gym owners whose requests are pending
    */
    public List<GymOwner> viewAllPendingGymOwnerRequests();
    
    /*
    approves the gym owner request whose email is passed
    */
    public void approveSingleGymOwnerRequest(String gymOwnerEmail) throws GymOwnerNotFoundException;
   
    /*
    approves all the pending gym owner requests
    */
    public void approveAllPendingGymOwnerRequests();
    
    /*
    returns the list of all the gyms whose request is pending
   */
    public List<Gym> viewAllPendingGymRequests();
    
    /*
    approves single gym whose gymId is sent
    */
    public void approveSingleGymRequest(String gymId) throws GymNotFoundException;
   
    /*
    approves all the pending gym requests
    */
    public void approveAllPendingGymRequests();
    
}
