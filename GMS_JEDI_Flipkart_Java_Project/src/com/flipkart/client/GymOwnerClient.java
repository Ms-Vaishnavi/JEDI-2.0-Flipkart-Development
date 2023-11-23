/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.GymOwnerBusiness;
import com.flipkart.business.UserBusiness;

/**
 * 
 */
public class GymOwnerClient {
	
	GymOwner gymOwner = new GymOwner();
	GymOwnerBusiness gymOwnerBusiness = new GymOwnerBusiness();

	/**
	 * @param args
	 */
	
	public void gymOwnerRegistration(Scanner in) {
		System.out.println("Enter GymOwner Details : ");
		System.out.println("Enter Name : ");
		gymOwner.setName(in.next());
		System.out.println("Enter Phone Number : ");
		gymOwner.setPhoneNumber(in.next());
		System.out.println("Enter PAN : ");
		gymOwner.setPanNumber(in.next());
		System.out.println("Enter Aadhaar : ");
		gymOwner.setAadharNumber(in.next());
		System.out.println("Enter Email : ");
		gymOwner.setEmail(in.next());
		System.out.println("Enter Password : ");
		gymOwner.setPassword(in.next());
		gymOwner.setRoleId(2);
		
		UserBusiness userBusiness = new UserBusiness();
		userBusiness.registerGymOwner(gymOwner);
		
		System.out.println("Customer registered successfully!");
	}
	
	public void editProfile(Scanner in) {
		System.out.println("Enter Details: ");
		System.out.println("Enter Name : ");
		gymOwner.setName(in.next());
		System.out.println("Enter Phone Number : ");
		gymOwner.setPhoneNumber(in.next());
		System.out.println("Enter PAN : ");
		gymOwner.setPanNumber(in.next());
		System.out.println("Enter Aadhaar : ");
		gymOwner.setAadharNumber(in.next());
		
		gymOwnerBusiness.editProfile(gymOwner);
	}

	public void viewProfile(Scanner in) {
		System.out.println("Enter Id: ");
		gymOwner = gymOwnerBusiness.getProfile(in.next());
		System.out.println("Name : " + gymOwner.getName());
		System.out.println("Phone Number : " + gymOwner.getPhoneNumber());
		System.out.println("PAN : " + gymOwner.getPanNumber());
		System.out.println("Aadhaar : " + gymOwner.getAadharNumber());
		
	}

	public void addGym(Scanner in) {
		System.out.println("Enter Gym Details: ");
		
		Gym gym = new Gym();
		System.out.println("Enter GymName : ");
		gym.setGymName(in.next());
		System.out.println("Enter Owner Email : ");
		gym.setOwnerEmail(in.next());
		System.out.println("Enter Address : ");
		gym.setAddress(in.next());
		System.out.println("Enter SlotCount : ");
		gym.setSlotCount(in.next());
		System.out.println("Enter seatsPerSlotCount : ");
		gym.setSeatsPerSlotCount(in.next());
		gym.setVerified(false);
		
		gymOwnerBusiness.addGym(gym);
		

	}

	public void editGym(Scanner in) {
		System.out.println("Enter Gym Details: ");
		
		Gym gym = new Gym();
		System.out.println("Enter GymName : ");
		gym.setGymName(in.next());
		System.out.println("Enter Owner Email : ");
		gym.setOwnerEmail(in.next());
		System.out.println("Enter Address : ");
		gym.setAddress(in.next());
		System.out.println("Enter SlotCount : ");
		gym.setSlotCount(in.next());
		System.out.println("Enter seatsPerSlotCount : ");
		gym.setSeatsPerSlotCount(in.next());
		gym.setVerified(false);
		
		gymOwnerBusiness.editGym(gym);
	}

	public void getGymDetails(Scanner in) {
		gymOwnerBusiness.getGymDetail(gymOwner.getEmail());
	}

	public void gymOwnerMenu(Scanner in) {
		System.out.println("Welcome! Here are the actions you can perform!");
		
		System.out.println("1. View Profile");
		System.out.println("2. Edit Profile");
		System.out.println("3. Add Gym");
		System.out.println("4. Edit Gym");
		System.out.println("5. View All Gym Details");
		
		int choice = in.nextInt();
		
		switch(choice) {
		case 1: viewProfile(in);
				break;
		case 2: editProfile(in);
				break;
		case 3: addGym(in);
				break;
		case 4: editGym(in);
				break;
		case 5: getGymDetails(in);
				break;
		}
		
	}

}
