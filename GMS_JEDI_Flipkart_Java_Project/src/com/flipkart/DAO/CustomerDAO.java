package com.flipkart.DAO;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.exception.NoSlotsFoundException;

public interface CustomerDAO {
	public List<Gym> fetchGymList();

	public void fetchSlotList(int gymId) throws NoSlotsFoundException;

	public void fetchBookedSlots(String email);

	public void bookSlots(String gymId, String slotId, String email, String date);

	public boolean isFull(String slotId, String date);

	public boolean alreadyBooked(String slotId, String email, String date);

	public void cancelBooking(String slotId, String email, String date);

	public boolean checkSlotExists(String slotId, String gymId);

	public boolean checkGymApprove(String gymId);
}
