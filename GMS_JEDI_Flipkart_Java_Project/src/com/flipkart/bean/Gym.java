/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Gym {
	private String gymId;
	private String gymName;
	private String ownerEmail;
	private String address;
	private int slotCount;
	private int seatsPerSlotCount;
	private boolean isVerified;
	
	public Gym() {
		
	}
	
	public Gym(String gymId, String gymName, String ownerEmail, String address, int slotCount, int seatsPerSlotCount, boolean isVerified) {
		
	}

	public String getGymId() {
		return gymId;
	}

	public void setGymId(String gymId) {
		this.gymId = gymId;
	}

	public String getGymName() {
		return gymName;
	}

	public void setGymName(String gymName) {
		this.gymName = gymName;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSlotCount() {
		return slotCount;
	}

	public void setSlotCount(int slotCount) {
		this.slotCount = slotCount;
	}

	public int getSeatsPerSlotCount() {
		return seatsPerSlotCount;
	}

	public void setSeatsPerSlotCount(int seatsPerSlotCount) {
		this.seatsPerSlotCount = seatsPerSlotCount;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

}
