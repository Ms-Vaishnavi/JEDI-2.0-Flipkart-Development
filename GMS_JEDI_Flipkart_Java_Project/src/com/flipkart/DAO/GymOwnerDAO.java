package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.*;

public interface GymOwnerGMSDao {

	public GymOwner fetchOwnerDetails(String phoneNumber);
	
	public void addGymOwnerDetails(GymOwner gymOwnerDetails);
	
	public List<Gymnasium> fetchGymDetails(String phoneNumber);
	
	public void addGymDetails(Gymnasium gymDetails);
	
	public List<Slots> fetchPossibleSlots();
	
	public void addSlots(int gymId, String chosenSlots, List<Slots> slotInfo);

	public boolean checkOwnerApproval(String email);

	public boolean checkGymApproval(int gymId);

	public boolean checkIfAlreadyBooked(int gymId);
}