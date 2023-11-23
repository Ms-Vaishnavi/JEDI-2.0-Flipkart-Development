package com.flipkart.client;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.*;

import java.util.*;

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
			System.out.println("Approved gym owner" + gymOwner.getName());
			adminBusiness.approveGymOwnerRequest(gymOwner);
		}
	}

	public void approvePendingGymRequest() {
		for (Gym gym : pendingGymList) {
			System.out.println("Approved gym" + gym.getGymName());
			gym.setVerified(true);
			adminBusiness.approveGymRequest(gym);
		}
	}

	public void AdminPage(Scanner in) throws Exception {
		while (true) {
//			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("1. View All Gym ");
			System.out.println("2. View All Gym Owners");
			System.out.println("3.  Approve Pending Gym  Requests");
			System.out.println("4. 	Approve pending Gym owner request");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = in.nextInt();
			switch (choice) {
			// Case statements
			case 1:
				viewAllGymOwners();
				break;
			case 2:
				viewAllGyms();
				break;
			case 3:
				approvePendingGymRequest();
				break;
			case 4:
//				approvePendingGymOwnerRequest();
				break;

			// Default case statement
			default:
				System.out.println("Wrong choice");
			}
		}
}
			
	public void viewAllGyms() {
		for (Gym gym : gymList) {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Gym Id-->" + gym.getGymId());
			System.out.println("Gym Name-->" + gym.getGymName());
			System.out.println("Gym Owner Mail-->" + gym.getOwnerEmail());
			System.out.println("Gym Address-->" + gym.getAddress());
			System.out.println("Gym Slot Count-->" + gym.getSlotCount());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		}
	}

	public void viewAllGymOwners() {
		for (GymOwner gymOwner : gymOwnerList) {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Gym Owner Name-->" + gymOwner.getName());
			System.out.println("Gym Owner phone numver-->" + gymOwner.getPhoneNumber());
			System.out.println("Gym Owner Aadhar-->" + gymOwner.getAadharNumber());
			System.out.println("Gym Owner panNumber-->" + gymOwner.getPanNumber());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		}

	}
}
