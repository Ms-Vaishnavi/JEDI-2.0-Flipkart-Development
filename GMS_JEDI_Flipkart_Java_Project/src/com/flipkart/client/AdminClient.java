package com.flipkart.client;

import com.flipkart.business.*;
import java.util.Scanner;

/**
 * 
 */

public class AdminClient {

	AdminBusiness adminBusiness = new AdminBusiness();

	List<Gym> pendingGymList = adminBusiness.getPendingGymRequests();
	List<GymOwner> pendingGymOwnerList = adminBusiness.getPendingGymOwnersRequests();
	List<GymOwner> gymOwnerList = adminBusiness.getGymOwners();
	List<Gym> gymList = adminBusiness.getGym();

	public void approvePendingGymOwnerRequest(List<GymOwner> pendingGymOwnerList) {
		for (GymOwner gymOwner : pendingGymOwnerList) {
			System.out.println("Approved gym owner" + gymOwner.name);
			adminBusiness.approveGymOwnerRequest();
		}
	}

	public void approvePendingGymRequest() {
		for (Gym gym : pendingGymList) {
			System.out.println("Approved gym" + gym.gymName);
			gym.isVerified = true;
			adminBusiness.approveGymRequest();
		}
	}

	public void viewAllGyms() {
		for (Gym gym : gymList) {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Gym Id-->" + gym.gymId);
			System.out.println("Gym Name-->" + gym.gymName);
			System.out.println("Gym Owner Mail-->" + gym.ownerEmail);
			System.out.println("Gym Address-->" + gym.address);
			System.out.println("Gym Slot Count-->" + gym.slotCount);
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		}
	}

	public void viewAllGymOwners() {
		for (GymOwner gymOwner : gymOwnerList) {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Gym Owner Name-->" + gymOwner.name);
			System.out.println("Gym Owner phone numver-->" + gymOwner.phoneNumber);
			System.out.println("Gym Owner Aadhar-->" + gymOwner.aadharNumber);
			System.out.println("Gym Owner panNumber-->" + gymOwner.panNumber);
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		}
	}
}
