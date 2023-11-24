/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

import java.util.*;

/**
 * 
 */
public class GymOwnerBusiness {
	
	List<GymOwner> gymOwners = new ArrayList<>();
	GymOwner gymOwner1 = new GymOwner("gymowner1@gmail.com", "go1", "GymOwner", "Rakesh", "0000", "0000", "0000");
	GymOwner gymOwner2 = new GymOwner("gymowner2@gmail.com", "go2", "GymOwner", "Ramesh", "0000", "0000", "0000");
	GymOwner gymOwner3 = new GymOwner("gymowner3@gmail.com", "go3", "GymOwner", "Rajesh", "0000", "0000", "0000");
	GymOwner gymOwner4 = new GymOwner("gymowner4@gmail.com", "go4", "GymOwner", "Rameshwari", "0000", "0000", "0000");

//	public Gym(String gymId, String gymName, String ownerEmail, String address, String slotCount, String seatsPerSlotCount, boolean isVarified) {

	List<Gym> gyms = new ArrayList<>();
	Gym gym1 = new Gym("g1", "gym1", "gymowner1@gmail.com", "Kanpur", 2, 5, true);
	Gym gym2 = new Gym("g2", "gym2", "gymowner2@gmail.com", "Hyderabad", 3, 5, true);
	Gym gym3 = new Gym("g3", "gym3", "gymowner3@gmail.com", "Bangalore", 2, 3, true);
	Gym gym4 = new Gym("g4", "gym4", "gymowner4@gmail.com", "Cochin", 6, 5, true);

	
	public GymOwnerBusiness() {
		gymOwners.add(gymOwner1);
		gymOwners.add(gymOwner2);
		gymOwners.add(gymOwner3);
		gymOwners.add(gymOwner4);
		
		gyms.add(gym1);
		gyms.add(gym2);
		gyms.add(gym3);
		gyms.add(gym4);
	}
	
	public GymOwner getProfile(String email) {
		for(GymOwner gymOwner: gymOwners) {
			if(gymOwner.getEmail().equals(email)) return gymOwner;
		}
		return null;
	}

	public void editProfile(GymOwner gymOwnerNew, String email) {
		for(int i=0; i<gymOwners.size(); i++) {
			GymOwner prevGymOwner = gymOwners.get(i);
			if(prevGymOwner.getEmail().equals(email)) {
				prevGymOwner.setName(gymOwnerNew.getName());
				prevGymOwner.setPhoneNumber(gymOwnerNew.getPhoneNumber());
				prevGymOwner.setPanNumber(gymOwnerNew.getPanNumber());
				prevGymOwner.setAadharNumber(gymOwnerNew.getAadharNumber());
				gymOwners.add(i, prevGymOwner);
				System.out.println("Successfully edited your profile");
				break;
			}
		}
		System.out.println("We could not find your profile, please retry!");
	}
	
	public boolean addGym(Gym gym) {
		gyms.add(gym);
		System.out.println("Added Gym Successfully!");
		return true;
	}
	
	public void editGym(Gym gym) {
		for(int i=0; i<gyms.size(); i++) {
			Gym prevGym = gyms.get(i);
			if(prevGym.getGymId().equals(gym.getGymId())) {
				prevGym.setGymName(gym.getGymName());
				prevGym.setAddress(gym.getAddress());
				prevGym.setSlotCount(gym.getSlotCount());
				prevGym.setSeatsPerSlotCount(gym.getSeatsPerSlotCount());
				gyms.add(i, prevGym);
				System.out.println("Edited Gym Details Successfully");
				break;
			}
		}
		System.out.println("We could not find the gym with the ID provided, please retry!");
	}
	
	public List<Gym> getGymDetail(String gymOwnerEmail) {
		List<Gym> ownersGyms = new ArrayList<>();
		for(Gym gym: gyms) {
			if(gym.getOwnerEmail().equals(gymOwnerEmail)) { 
				ownersGyms.add(gym);
			}
		}
		return ownersGyms;
	}
	
	public boolean isApproved(String email) {
		for(GymOwner gymOwner: gymOwners) {
			if(gymOwner.getEmail().equals(email)) return gymOwner.isVerified();
		}
		return false;
	}
	
	public boolean isGymApproved(String gymId) {
		for(Gym gym: gyms) {
			if(gym.getGymId().equals(gymId)) gym.isVerified();
		}
		return false;
	}
}
