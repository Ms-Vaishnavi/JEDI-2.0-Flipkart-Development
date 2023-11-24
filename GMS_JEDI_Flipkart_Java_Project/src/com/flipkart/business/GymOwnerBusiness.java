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

	List<Gym> gyms = new ArrayList<>();
	
	public GymOwnerBusiness() {
		gymOwners.add(gymOwner1);
		gymOwners.add(gymOwner2);
		gymOwners.add(gymOwner3);
		gymOwners.add(gymOwner4);
	}
	
	public GymOwner getProfile(String email) {
		for(GymOwner gymOwner: gymOwners) {
			if(gymOwner.getEmail().equals(email)) return gymOwner;
		}
		return null;
	}

	public void editProfile(GymOwner gymOwnerNew) {
		for(int i=0; i<gymOwners.size(); i++) {
			if(gymOwners.get(i).getEmail().equals(gymOwnerNew.getEmail())) gymOwners.add(i, gymOwnerNew);
		}
	}
	
	public boolean addGym(Gym gym) {

		gyms.add(gym);
		return true;
	}
	
	public void editGym(Gym gym) {
		for(int i=0; i<gyms.size(); i++) {
			if(gyms.get(i).getGymId().equals(gym.getGymId())) gyms.add(i, gym);
		}
	}
	
	public List<Gym> getGymDetail(String gymOwnerEmail) {
		List<Gym> ownersGyms = new ArrayList<>();
		for(Gym gym: gyms) {
			if(gym.getOwnerEmail().equals(gymOwnerEmail)) ownersGyms.add(gym);
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
