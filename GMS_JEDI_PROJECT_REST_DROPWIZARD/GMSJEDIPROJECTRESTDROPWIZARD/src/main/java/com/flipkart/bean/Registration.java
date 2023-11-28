/**
 * 
 */
package com.flipkart.bean;

/**
 * Registration bean
 */
public class Registration {
	
	public String RegistrationId;
	public String RegistrationDate;
	public String email;

	public String getRegistrationId() {
		return RegistrationId;
	}
	public void setRegistrationId(String registrationId) {
		RegistrationId = registrationId;
	}
	public String getRegistrationDate() {
		return RegistrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		RegistrationDate = registrationDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
