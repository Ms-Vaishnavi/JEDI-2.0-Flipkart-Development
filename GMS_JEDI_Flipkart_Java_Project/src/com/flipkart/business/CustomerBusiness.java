/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.*;
import java.util.*;

public class CustomerBusiness {

	public void getProfile(Customer customer) {

	}

	public void editProfile(Customer customer) {

	}

	public List<Booking> getBookings(String email) {
		return new ArrayList<>();
	}

	public boolean cancelBooking(String bookingId, String customerId) {
		return false;
	}

	public List<Gym> getGymInCity(String city) {
		return new ArrayList<>();
	}

	public List<Slot> getSlotInGym(String gymId) {
		return new ArrayList<>();
	}

	public int bookSlot(String gymId, String slotId, String customerId, Date date) {
		return 0;
	}

	public boolean isSlotBooked(String slotId, Date date) {
		return false;
	}
	
	public boolean hasBookedSlotAlready(String slotId, String customerId, Date date) {
		return false;
	}


}
