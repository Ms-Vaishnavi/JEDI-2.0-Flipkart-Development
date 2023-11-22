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

	public List<GymOwner> getGymOwners() {
		return new ArrayList<>();
	}
	
	public List<Gym> getGym() {
		return new ArrayList<>();
	}
	
	public List<GymOwner> getPendingGymOwnersRequests() {
		return new ArrayList<>();
	}
	
	public List<Gym> getPendingGymRequests() {
		return new ArrayList<>();
	}
	
	public boolean approveGymOwnerRequest(GymOwner gymOwner) {
		return false;
	}
	
	public boolean approveGymRequest(Gym gym) {
		return false;
	}
}
