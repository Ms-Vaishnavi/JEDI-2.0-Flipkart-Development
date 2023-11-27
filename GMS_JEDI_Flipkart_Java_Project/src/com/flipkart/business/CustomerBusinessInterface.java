package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.exception.NoSlotsFoundException;

import java.util.*;

public interface CustomerBusinessInterface{
    public Customer getProfile(Customer customer);
    /*
    returns the customer profile
    */
 
    public void editProfile(Customer customer);
    /*
    allows the customer to edit profile
    */
   
    public List<Gym> getGymInCity(String city);
    public List<Slot> getSlotInGym(String gymId);
    public boolean isSlotBooked(String slotId, Date date);
    public boolean cancelBooking(String bookingId, String email);
}