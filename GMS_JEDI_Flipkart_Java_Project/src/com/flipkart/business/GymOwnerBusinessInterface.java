package com.flipkart.business;

import com.flipkart.bean.*;
import java.util.*;
import com.flipkart.exception.*;



public interface GymOwnerBusinessInterface{
    public GymOwner getProfile(String email);
    /*
    Returns the gym owner profile
    */

    public void editProfile(GymOwner gymOwnerNew, String email);
    /*
    Allows the gym owner to edit profile
    */

    public boolean addGym(Gym gym);
    /*
    Allows the Gym Owner to add a new gym
    */

    public void editGym(Gym gym);
    /*
    Allows the gym owner to edit any gym's Information
    */

    public List<Gym> getGymDetail(String gymOwnerEmail);
    /*
    returns the list of all gyms that is owned by the gym owner whose email is provided
    */

    public boolean isApproved(String email);
    /*
    Returns true if the gym owner is approved else returns false
    */

    public boolean isGymApproved(String gymId);
    /*
    Returns true if the gym is approved else returns false
    */
}