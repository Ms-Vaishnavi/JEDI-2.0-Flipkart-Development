package com.flipkart.DAO;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.*;

public class GymOwnerDAO {

	public GymOwner fetchOwnerDetails(String phoneNumber){
		return null;
	}
	
	public void addGymOwnerDetails(GymOwner gymOwnerDetails) {
		
	}
	
	public List<Gym> fetchGymDetails(String phoneNumber) {
		return new ArrayList<>();
	}
	
	public void addGymDetails(Gym gymDetails) {
		
	}
	
	public List<Slot> fetchPossibleSlots() {
		return new ArrayList<>();
	}
	
	public void addSlots(int gymId, String chosenSlots, List<Slot> slotInfo) {}

	public boolean checkOwnerApproval(String email) {
		return true;
	}

	public boolean checkGymApproval(int gymId) {
		return true;
	}

	public boolean checkIfAlreadyBooked(int gymId) {
		return true;
	}
}