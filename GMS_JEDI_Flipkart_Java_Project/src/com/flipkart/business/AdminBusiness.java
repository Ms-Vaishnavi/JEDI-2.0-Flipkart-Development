/**
 * 
 */
package com.flipkart.business;
import java.util.*;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

/**
 * 
 */
public class AdminBusiness {
	List<GymOwner> gymOwners = new ArrayList<>();
	GymOwner gymOwner1 = new GymOwner("gymowner1@gmail.com", "go1", "GymOwner", "Rakesh", "0000", "0000", "0000");
	GymOwner gymOwner2 = new GymOwner("gymowner2@gmail.com", "go2", "GymOwner", "Ramesh", "0000", "0000", "0000");
	GymOwner gymOwner3 = new GymOwner("gymowner3@gmail.com", "go3", "GymOwner", "Rajesh", "0000", "0000", "0000");
	GymOwner gymOwner4 = new GymOwner("gymowner4@gmail.com", "go4", "GymOwner", "Rameshwari", "0000", "0000", "0000");
	
	List<Gym> gyms = new ArrayList<>();
	Gym gym1 = new Gym("g1", "gym1", "gymowner1@gmail.com", "Kanpur", 2, 5, true);
	Gym gym2 = new Gym("g2", "gym2", "gymowner2@gmail.com", "Hyderabad", 3, 5, false);
	Gym gym3 = new Gym("g3", "gym3", "gymowner3@gmail.com", "Bangalore", 2, 3, false);
	Gym gym4 = new Gym("g4", "gym4", "gymowner4@gmail.com", "Cochin", 6, 5, true);
	
	public AdminBusiness() {
		gymOwners.add(gymOwner1);
		gymOwners.add(gymOwner2);
		gymOwners.add(gymOwner3);
		gymOwners.add(gymOwner4);
		
		gyms.add(gym1);
		gyms.add(gym2);
		gyms.add(gym3);
		gyms.add(gym4);
	}

	public List<GymOwner> getGymOwners() {
		return gymOwners;
	}
	
	public List<Gym> getGym() {
		return gyms;
	}
	
	public List<GymOwner> getPendingGymOwnersRequests() {
		List<GymOwner> pendingGymOwnerRequests = new ArrayList<GymOwner>();
		for (GymOwner owner: gymOwners) {
			if (!owner.isVerified())
				pendingGymOwnerRequests.add(owner);
		}
		return pendingGymOwnerRequests;
	}
	
	public List<Gym> getPendingGymRequests() {
		List<Gym> pendingGymRequests = new ArrayList<Gym>();
		for (Gym gym: gyms) {
			if (!gym.isVerified())
				pendingGymRequests.add(gym);
		}
		return pendingGymRequests;
	}
	
	public boolean approveSingleGymOwnerRequest(String gymOwnerEmail) {
		for (int i = 0; i < gymOwners.size(); i++) {
			GymOwner owner = gymOwners.get(i);
			if (owner.getEmail().equals(gymOwnerEmail)) {
				owner.setVerified(true);
				gymOwners.add(i, owner);
				System.out.println("Approved the Gym Owner Request : " + gymOwnerEmail);
				return true;
			}
		}
		return false;
	}
	
	public List<GymOwner> viewAllPendingGymOwnerRequests() {
		List<GymOwner> pendingGymOwnerReq = new ArrayList<GymOwner>();
		for (int i = 0; i < gymOwners.size(); i++) {
			GymOwner owner = gymOwners.get(i);
			if (!owner.isVerified()) {
				pendingGymOwnerReq.add(owner);
			}
		}
		return pendingGymOwnerReq;
	}
	
	public boolean approveAllPendingGymOwnerRequests() {
		for (int i = 0; i < gymOwners.size(); i++) {
			GymOwner owner = gymOwners.get(i);
			if (!owner.isVerified()) {
				owner.setVerified(true);
				gymOwners.add(i, owner);
				System.out.println("Approved the Gym Owner Request : " + owner.getEmail());
			}
		}
		return true;
	}
	
	public List<Gym> viewAllPendingGymRequests() {
		List<Gym> pendingGymReq = new ArrayList<Gym>();
		for (int i = 0; i < gyms.size(); i++) {
			Gym gym = gyms.get(i);
			if (!gym.isVerified()) {
				pendingGymReq.add(gym);
			}
		}
		return pendingGymReq;
	}
	
	public boolean approveSingleGymRequest(String gymId) {
		for (int i = 0; i < gyms.size(); i++) {
			Gym gym = gyms.get(i);
			if (gym.getGymId().equals(gymId)) {
				gym.setVerified(true);
				gyms.add(i, gym);
				System.out.println("Approved the Gym Request : " + gymId);
				return true;
			}
		}
		return false;
	}
	public boolean approveAllPendingGymRequests() {
		for (int i = 0; i < gyms.size(); i++) {
			Gym gym = gyms.get(i);
			if (!gym.isVerified()) {
				gym.setVerified(true);
				gyms.add(i, gym);
				System.out.println("Approved the Gym Request : " + gym.getGymId());
			}
		}
		return false;
	}
}
