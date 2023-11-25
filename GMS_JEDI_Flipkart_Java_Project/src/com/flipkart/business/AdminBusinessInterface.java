package com.flipkart.business;


import com.flipkart.bean.*;
import java.util.*;
import com.flipkart.exception.*;



public interface AdminBusinessInterface{

    public List<GymOwner> getGymOwners();
    /*
    returns the list of all the gym owners
    */

    public List<Gym> getGym() ;
    /*
    returns the list of all the gyms
    */

    public List<GymOwner> viewAllPendingGymOwnerRequests();
    /*
    returns the list of all the gym owners whose requests are pending
    */

    public boolean approveSingleGymOwnerRequest(String gymOwnerEmail);
    /*
    approves the gym owner request whose email is passed
    */

    public boolean approveAllPendingGymOwnerRequests();
    /*
    approves all the pending gym owner requests
    */
    public List<Gym> viewAllPendingGymRequests();
    /*
     returns the list of all the gyms whose request is pending
    */

    public boolean approveSingleGymRequest(String gymId);
    /*
    approves single gym whose gymId is sent
    */

    public boolean approveAllPendingGymRequests();
    /*
    approves all the pending gym requests
    */
}
