package com.flipkart.DAO;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

public interface GymOwnerDAO {
	/**
	 * Retrieves gym owner details from the database
	 * @param gymOwnerEmail The Email Id of the gym owner
	 * @return GymOwner object
	 */
	public GymOwner getGymOwnerDetails(String gymOwnerEmailId);

	/**
	 * Adds a gym owner to the database
	 * @param GymOwner object
	 */
	public void addGymOwnerDetails(GymOwner gymOwnerDetails);

	/**
	 * Edits gym owner details in the database
	 * @param GymOwner object
	 */
	public void editGymOwnerDetails(GymOwner gymOwnerDetails);

	/**
	 * Retrieves gym details from the database
	 * @param gymId The Id of the gym
	 * @return Gym object
	 */
	public Gym getGym(String gymId);

	/**
	 * Adds a gym to the database
	 * @param Gym object
	 */
	public void addGym(Gym gymDetails);

	/**
	 * Edits a gym in the database
	 * @param Gym object
	 */
	public void editGym(Gym gymDetails);
	
	/**
	 * Retrieves all gym details of a gym owner from the database
	 * @param gymOwnerId The Email Id of the gym owner
	 * @return List of Gym objects
	 */
	public List<Gym> getGymsOfGymOwner(String gymOwnerId);

	/**
	 * Retrieves all the possible slots of a gym from the database
	 * @param gymId The Id of the gym
	 * @return List of the Slot objects
	 */
	public List<Slot> getPossibleSlots(String gymId);

	/**
	 * Adds a slot in the database
	 * @param Slot object
	 */
	public void addSlot(Slot slot);

	/**
	 * Checks if a gym owner is verified by the Administrator
	 * @param email The emailId of the gym owner
	 */
	public boolean checkOwnerApproval(String email);

	/**
	 * Checks if a gym is verified by the Administrator
	 * @param gymId The Id of the gym
	 */
	public boolean checkGymApproval(String gymId);
}
