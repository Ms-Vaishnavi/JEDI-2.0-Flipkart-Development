package com.flipkart.business;

import com.flipkart.bean.*;
import java.util.*;
import com.flipkart.exception.*;



public interface BookingBusinessInterface {

    public boolean isConfirmed(String bookingId);
    /*
    Returns true if the booking is confirmed and false if its waitlisted
    */

    public int getWaitingList();
    /*
    Returns the waitlist number if the booking is in waitlist
    */
}