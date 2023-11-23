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

	public GymOwner getProfile(String Id) {
		return new GymOwner();
	}

	public void editProfile(GymOwner gymOwner) {

	}
	
	public boolean addGym(Gym gym) {
		return false;
	}
	
	public void editGym(Gym gym) {
		
	}
	
	public List<Gym> getGymDetail(String gymOwnerEmail) {
		return new ArrayList<>();
	}
	
	public boolean isApproved(String email) {
		return false;
	}
	
	public boolean isGymApproved(Gym gym) {
		return false;
	}
}
