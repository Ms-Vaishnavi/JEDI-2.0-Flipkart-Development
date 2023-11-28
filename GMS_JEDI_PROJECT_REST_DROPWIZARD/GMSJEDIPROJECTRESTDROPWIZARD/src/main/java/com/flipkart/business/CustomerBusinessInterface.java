package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.exception.CustomerNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.SlotNotFoundException;

import java.util.*;
/**
 * Customer business interface
 */
public interface CustomerBusinessInterface{
    public Customer getProfile(Customer customer) throws CustomerNotFoundException;
    /*
    returns the customer profile
    */
 
    public void editProfile(Customer customer)  throws CustomerNotFoundException;
    /*
    allows the customer to edit profile
    */
   
    public List<Gym> getGymInCity(String city) ;
    public List<Slot> getSlotInGym(String gymId) throws SlotNotFoundException;
    public boolean isSlotBooked(String slotId, String date);
    public boolean cancelBooking(String bookingId, String email);
}