package com.flipkart.business;

import com.flipkart.bean.*;
import java.util.*;
import com.flipkart.exception.*;



public interface CustomerBusinessInterface{

    public Customer getProfile(Customer customer);
    /*
    Returns the customer profile
    */

    public void editProfile(Customer customer);
    /*
    Allows the customer to edit the profile and edit any information
    */

    public List<Booking> getBookings(String email);
    /*
    Returns the list of all the bookings made by the customer
    */

    public boolean cancelBooking(String bookingId, String email);
    /*
    Allows the customer to cancel any booking made earlier
    */

    public List<Gym> getGymInCity(String city);
    /*
    Returns the list of all the gyms in the customer's city
    */

    public List<Slot> getSlotInGym(String gymId);
    /*
    Returns the list of all the slots in the gym with the provided gymId
    */

    public int bookSlot(String slotId, String email, Date date);
    /*
    allows the customer to book a slot in Gym
    */

    public boolean isSlotBooked(String slotId, Date date);
    /*
    checks if the slot is fully booked or not
    */

    public boolean hasBookedSlotAlready(String slotId, String customerEmail, Date date);
    /*
    Checks if the customer has already booked the given slot or not
    */
}