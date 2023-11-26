/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.DAO.*;
import com.flipkart.constants.ColorConstants;

import java.util.*;

/**
 * 
 */
public class GymOwnerBusiness implements GymOwnerBusinessInterface {
	GymOwnerDAOImpl gymOwnerDAO = new GymOwnerDAOImpl();

	/**
	 * Obtains gym owner's profile details 
	 * @param email the email of the gym owner whose profile details are requested
	 * @return GymOwner the gym owner object
	 */
	public GymOwner getProfile(String email) {
		System.out.println("Fetched Gym owner details successfully! " + email);
		return gymOwnerDAO.getGymOwnerDetails(email);
	}
	/**
	 * Gives functionality of updating gym onwer's personal data. 
	 * @param gymOwnerNew the gymOwner object in which the profile data needs to be updated
	 * @param email the gymOwner email for which the profile data needs to be update
	 */
	public void editProfile(GymOwner gymOwnerNew) {
		gymOwnerDAO.editGymOwnerDetails(gymOwnerNew);
		System.out.println(ColorConstants.GREEN + "\nEdited your profile Successfully!" + ColorConstants.RESET);
	}
	/**
	 * This method allows a gym owner to add details of a particular gym.
	 * @param gym the gym object representing the gym details
	 */
	public boolean addGym(Gym gym) {
		gymOwnerDAO.addGym(gym);
		System.out.println(ColorConstants.GREEN + "\nAdded Gym Successfully!" + gym.getGymId() + ColorConstants.RESET );
		return true;
	}
	/**
	 * This method allows a gym owner to edit details of a particular gym.
	 * @param gym the gym object representing the gym details
	 */
	public void editGym(Gym gym) {
		gymOwnerDAO.editGym(gym);
		System.out.println(ColorConstants.GREEN + "Edited Gym Details Successfully! " + gym.getGymId()+ ColorConstants.RESET );
	}
	/**
	 * Obtains all the gyms that owned by the given gym owner.
	 * @param gymOwnerEmail the gym owner's email for which the list of gyms is requested
	 * @return list of gyms owned by the given gym owner
	 */
	public List<Gym> getGymDetail(String gymOwnerEmail) {
		System.out.println("Fetched gym details successfully! " + gymOwnerEmail);
		return gymOwnerDAO.getGymsOfGymOwner(gymOwnerEmail);
	}
	/**
	 * Checks if the gym owner is verified or not.
	 * @param email the gym owner's email 
	 * @return true if the gym owner is verified else returns false;
	 */
	public boolean isApproved(String email) {
		return gymOwnerDAO.checkOwnerApproval(email);
	}
	/**
	 * Checks if the gym is verified or not.
	 * @param gymId the gym id for which the verification status is requested
	 * @return true if the gym is verified else returns false;
	 */
	public boolean isGymApproved(String gymId) {
		return gymOwnerDAO.checkGymApproval(gymId);
	}
}
