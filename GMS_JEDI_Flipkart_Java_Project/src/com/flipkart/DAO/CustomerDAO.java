package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Gym;

public interface CustomerDao {

	public List<Gym> fetchGymList();
	
	public void fetchSlotList(int gymId);
	
	public void fetchBookedSlots(String email);
	
	public void bookSlots(int gymId, String slotId,String email,String date);
	
	public boolean isFull(String slotId,String date);

	public boolean alreadyBooked(String slotId, String email, String date);

	public void cancelBooking(String slotId, String email, String date);

	public boolean checkSlotExists(String slotId, int gymId);

	public void cancelBookedSlots(String email, int bookingId);

	public boolean checkGymApprove(int gymId);

}