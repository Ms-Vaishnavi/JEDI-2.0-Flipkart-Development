package com.flipkart.business;

/**
 * Booking business interface
 */
public interface BookingBusinessInterface {
	/*
    Returns true if the booking is confirmed and false if its waitlisted
    */
    public boolean isConfirmed(String bookingId);
   
    /*
    Returns the waitlist number if the booking is in waitlist
    */
    public int getWaitingList();
}