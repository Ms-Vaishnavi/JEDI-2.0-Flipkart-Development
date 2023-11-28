package com.flipkart.DAO;

import java.util.Date;
import java.util.List;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;
import com.flipkart.exception.*;

public interface CustomerDAO {
	public Customer getProfile(Customer customer);

	public int editCustomerDetails(Customer customer);
	public List<Gym> fetchGymList(String city);

	public List<Slot> fetchSlotList(String gymId) throws SlotNotFoundException;

	public List<Booking> fetchBookedSlots(String email);

	public void bookSlots(String bookingId, String slotId, String gymId, String type, String date, String customerEmail);

	public boolean isFull(String slotId, String date);

	public boolean alreadyBooked(String slotId, String email, String date);

	public int cancelBooking(String bookingId, String email);

	public boolean checkSlotExists(String slotId, String gymId);

	public boolean checkGymApprove(String gymId);
	
	public int getNumberOfSeatsBooked(String slotId);
	
	public int getNumberOfSeats(String slotId);
}
