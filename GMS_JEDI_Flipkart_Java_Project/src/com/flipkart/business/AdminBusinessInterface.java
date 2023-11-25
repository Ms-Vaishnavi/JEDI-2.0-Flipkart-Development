
package com.flipkart.business;

import com.flipkart.bean.*;
import java.util.*;
import com.flipkart.exception.*;



public interface AdminBusinessInterface {

    public List<GymOwner> getGymOwners();
    /*
    Returns the list of all the gym owners
    */

    public List<Gym> getGym();
    /*
    Returns the list of all the gyms
    */

    public List<GymOwner> getPendingGymOwnersRequests();
    /*
    Returns the list of all the gym owners whose approval request is pending
    */

    public List<Gym> getPendingGymRequests();
    /*
   Returns the list of all the gym owners whose approval request is pending
   */

    public boolean approveSingleGymOwnerRequest(String gymOwnerEmail);
    /*
     Approves a single gym ownwer with the gymOwnerEmail that is passed
    */

    public boolean approveAllPendingGymOwnerRequests()
    /*
     Approves all the pending Gym Owner Requests
    */

    public List<Gym> viewAllPendingGymRequests();
    /*
    Returns the list of all the gyms whose approval request is pending
    */

    public boolean approveSingleGymRequest(String gymId);
    /*
    Approves a single gym with the gymId that is passed
    */

    public boolean approveAllPendingGymRequests();
    /*
    Approves all the pending Gym Requests
    */
}
