/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class GymOwner extends User {
	private String name;
	private String phoneNumber;
	private String aadharNumber;
	private String panNumber;
	
	public GymOwner(String email, String password, int roleId, String name, String phoneNumber, String aadharNumber, String panNumber) {
		super(email, password, roleId);
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
	}
	
	public GymOwner() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

}
