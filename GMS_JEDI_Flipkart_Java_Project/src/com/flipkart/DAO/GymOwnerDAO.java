package com.flipkart.DAO;

import java.util.List;

import com.flipkart.bean.*;

public interface GymOwnerDAO {

	public GymOwner fetchOwnerDetails(String phoneNumber);
	
	public void addGymOwnerDetails(GymOwner gymOwnerDetails);
	
	public List<Gym> fetchGymDetails(String phoneNumber);
	
	public void addGymDetails(Gym gymDetails);
	
	public List<Slot> fetchPossibleSlots();
	
	public void addSlots(int gymId, String chosenSlots, List<Slot> slotInfo);

	public boolean checkOwnerApproval(String email);

	public boolean checkGymApproval(int gymId);

	public boolean checkIfAlreadyBooked(int gymId);
}