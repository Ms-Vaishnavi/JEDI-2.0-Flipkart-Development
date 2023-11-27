package com.flipkart.client;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.*;
import com.flipkart.constants.ColorConstants;

import java.util.*;

/**
 * 
 */

public class AdminClient {

	AdminBusiness adminBusiness = new AdminBusiness();

	Scanner sc = new Scanner(System.in);

	public void viewAllPendingGymOwnerRequests() {
		List<GymOwner> gymOwners = adminBusiness.viewAllPendingGymOwnerRequests();

		System.out.printf("%15s%15s%15s%15s%15s%15s", "GymOwner Email", "GymOwner Name", "Phone Number", "Aadhaar",
				"PAN number", "Verification");
		for (GymOwner gymOwner : gymOwners) {
			System.out.println();
			System.out.printf("%15s%15s%15s%15s%15s%15s", gymOwner.getEmail(), gymOwner.getName(),
					gymOwner.getPhoneNumber(), gymOwner.getAadharNumber(), gymOwner.getPanNumber(),
					gymOwner.isVerified() ? "Verified" : "Not Verified");
		}
	}

	public void viewAllPendingGymRequests() {

		List<Gym> gyms = adminBusiness.viewAllPendingGymRequests();

		System.out.printf("%15s%15s%15s%15s%15s%15s%15s", "Gym Id", "Gym Name", "Gym Owner", "Address", "SlotCount",
				"SeatsPerSlot", "Verification");
		for (Gym gym : gyms) {
			System.out.println();
			System.out.printf("%15s%15s%15s%15s%15s%15s%15s", gym.getGymId(), gym.getGymName(), gym.getOwnerEmail(),
					gym.getAddress(), gym.getSlotCount(), gym.getSeatsPerSlotCount(),
					gym.isVerified() ? "Verified" : "Not Verified");
		}
		System.out.println();
	}

	public void approveSingleGymOwnerRequest() {
		System.out.println("Enter gym owner email: ");
		adminBusiness.approveSingleGymOwnerRequest(sc.next());
	}

	public void approveSingleGymRequest() {
		System.out.println("Enter gym Id: ");
		adminBusiness.approveSingleGymRequest(sc.next());
	}

	public void approvePendingGymOwnerRequests() {
		adminBusiness.approveAllPendingGymOwnerRequests();
	}

	public void approvePendingGymRequests() {
		adminBusiness.approveAllPendingGymRequests();
	}

	public void adminMenu(Scanner in) throws Exception {
		System.out.println("________________________________________________________________________________\n");
		while (true) {
			System.out.println("Here are the actions you can perform!");
			System.out.println("1. View All Gym ");
			System.out.println("2. View All Gym Owners");
			System.out.println("3. View all pending Gym Owner Requests");
			System.out.println("4. View all pending Gym Requests");
			System.out.println("5. Approve all pending Gym Owner Requests");
			System.out.println("6. Approve all pending Gym Requests");
			System.out.println("7. Approve Single Gym Owner Request");
			System.out.println("8. Approve Single Gym Request");
			System.out.println("9. Exit");

			System.out.print("\nEnter your choice: ");
			int choice = in.nextInt();
			switch (choice) {
			// Case statements
			case 1:
				viewAllGyms();
				break;
			case 2:
				viewAllGymOwners();
				break;
			case 3:
				viewAllPendingGymOwnerRequests();
				break;
			case 4:
				viewAllPendingGymRequests();
				break;
			case 5:
				approvePendingGymOwnerRequests();
				break;
			case 6:
				approvePendingGymRequests();
				break;
			case 7:
				approveSingleGymOwnerRequest();
				break;
			case 8:
				approveSingleGymRequest();
				break;
			case 9:
				return;
			// Default case statement
			default:
				System.out.println(ColorConstants.RED + "Wrong choice" + ColorConstants.RESET);
			}
		}
	}

	public void viewAllGyms() {
		List<Gym> gyms = adminBusiness.getGym();

		System.out.printf("%15s%15s%15s%15s%15s%15s%15s", "Gym Id", "Gym Name", "Gym Owner", "Address", "SlotCount",
				"SeatsPerSlot", "Verification");
		for (Gym gym : gyms) {
			System.out.println();
			System.out.printf("%15s%15s%15s%15s%15s%15s%15s", gym.getGymId(), gym.getGymName(), gym.getOwnerEmail(),
					gym.getAddress(), gym.getSlotCount(), gym.getSeatsPerSlotCount(),
					gym.isVerified() ? "Verified" : "Not Verified");
		}
		System.out.println();
		System.out.println("Fetched gym owner details successfully!");
	}

	public void viewAllGymOwners() {

		List<GymOwner> gymOwners = adminBusiness.getGymOwners();

		System.out.printf("%15s%15s%15s%15s%15s%15s", "GymOwner Email", "GymOwner Name", "Phone Number", "Aadhaar",
				"PAN number", "Verification");
		for (GymOwner gymOwner : gymOwners) {
			System.out.println();
			System.out.printf("%15s%15s%15s%15s%15s%15s", gymOwner.getEmail(), gymOwner.getName(),
					gymOwner.getPhoneNumber(), gymOwner.getAadharNumber(), gymOwner.getPanNumber(),
					gymOwner.isVerified() ? "Verified" : "Not Verified");
		}

	}
}
