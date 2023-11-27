package com.flipkart.DAO;

import java.util.Date;
import java.util.List;

import com.flipkart.bean.Gym;
<<<<<<< HEAD
import com.flipkart.bean.Slot;
import com.flipkart.exception.NoSlotsFoundException;
=======
>>>>>>> 575b7eb (Added Exceptions)

public interface CustomerDAO {
	public List<Gym> fetchGymList(String city);

	public void fetchSlotList(int gymId);

	public void fetchBookedSlots(String email);

	public void bookSlots(String bookingId, String slotId, String gymId, String type, Date date, String customerEmail);

	public boolean isFull(String slotId, Date date);

	public boolean alreadyBooked(String slotId, String email, Date date);

	public boolean cancelBooking(String bookingId, String email);

	public boolean checkSlotExists(String slotId, String gymId);

	public boolean checkGymApprove(String gymId);
}
