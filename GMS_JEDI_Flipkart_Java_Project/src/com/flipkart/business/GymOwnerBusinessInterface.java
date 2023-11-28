package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.UnauthorizedAccessException;

import java.util.*;

public interface GymOwnerBusinessInterface {
	/**
	 * Obtains gym owner's profile details 
	 * @param email the email of the gym owner whose profile details are requested
	 * @return GymOwner the gym owner object
	 * @throws GymOwnerNotFoundException 
	 */
    public GymOwner getProfile(String email) throws GymOwnerNotFoundException;
   
	/**
	 * Gives functionality of updating gym onwer's personal data. 
	 * @param gymOwnerNew the gymOwner object in which the profile data needs to be updated
	 * @param email the gymOwner email for which the profile data needs to be update
	 * @throws GymOwnerNotFoundException 
	 */
    public void editProfile(GymOwner gymOwnerNews) throws GymOwnerNotFoundException;

    /**
	 * This method allows a gym owner to add details of a particular gym.
	 * @param gym the gym object representing the gym details
	 */
    public boolean addGym(Gym gym);
   
    /**
	 * This method allows a gym owner to edit details of a particular gym.
	 * @param gym the gym object representing the gym details
	 * @throws GymNotFoundException 
	 */
    public void editGym(Gym gym) throws GymNotFoundException;
   
    /**
	 * Obtains all the gyms that owned by the given gym owner.
	 * @param gymOwnerEmail the gym owner's email for which the list of gyms is requested
	 * @return list of gyms owned by the given gym owner
	 */ 
    public List<Gym> getGymDetail(String gymOwnerEmail);
    
    /**
	 * This method allows a gym owner to add details of a slot.
	 * @param slot the slot object representing the slot details
	 * @throws GymNotFoundException 
     * @throws UnauthorizedAccessException 
	 */
    public void addSlot(Slot slot, String ownerEmail) throws GymNotFoundException, UnauthorizedAccessException;
    
    /**
	 * Checks if the gym owner is verified or not.
	 * @param email the gym owner's email 
	 * @return true if the gym owner is verified else returns false;
	 */
    public boolean isApproved(String email);
   
    /**
	 * Checks if the gym is verified or not.
	 * @param gymId the gym id for which the verification status is requested
	 * @return true if the gym is verified else returns false;
	 */
    public boolean isGymApproved(String gymId);
    
}