package com.flipkart.DAO;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Gym;

public class CustomerDAO {

	public List<Gym> fetchGymList(){
		return new ArrayList<>();
	}
	
	public void fetchSlotList(int gymId) {}
	
	public void fetchBookedSlots(String email) {}
	
	public void bookSlots(int gymId, String slotId,String email,String date) {}
	
	public boolean isFull(String slotId,String date) {
		return true;
	}

	public boolean alreadyBooked(String slotId, String email, String date) {
		return true;
	}

	public void cancelBooking(String slotId, String email, String date) {
		
	}

	public boolean checkSlotExists(String slotId, int gymId) {
		return true;
	}

	public void cancelBookedSlots(String email, int bookingId) {
		
	}

	public boolean checkGymApprove(int gymId) {
		return true;
	}

}