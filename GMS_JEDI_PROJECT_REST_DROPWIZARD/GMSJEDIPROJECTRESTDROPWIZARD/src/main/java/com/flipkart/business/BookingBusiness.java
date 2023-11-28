/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.*;
import java.util.*;
import java.util.Date;
/**
 * Booking business
 */
public class BookingBusiness implements BookingBusinessInterface{

	List<Booking> bookings=new ArrayList<>();
	Date d1=new Date(); //current date

	public BookingBusiness()
	{
		
	}
	/**
	 * Checks if a booking is confirmed or not for the given bookingId
	 * @param bookingId the id of a booking that needs to be checked
	 * @return true if the bookingId is confirmed else returns false
	 */
	public boolean isConfirmed(String bookingId) {

		for(Booking b:bookings)
		{
			if(b.getBookingId().equals(bookingId))
			{
				if(b.getType()=="confirmed")
					return true;
				else
					return false;
			}
		}
		return false;
	}
	/**
	 * Gives a size of wait listed customers.
	 */
	public int getWaitingList() {
		return -1;
	}

}
