/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

/**
 * 
 */
public class UserBusiness {
	/**
	Registers a customer in the system.
	@param customer The Customer object representing the customer data
	*/
	public boolean registerCustomer(Customer customer) {
		return false;
	}
	/**
	Registers a gym owner in the system.
	@param gymOwner The gym owner object representing the gym owner data
	*/
	public boolean registerGymOwner(GymOwner gymOwner) {
		return false;
	}
	/**
	Verifies a user's data.
	@param user The user object representing the user data
	@return true if the user's data are valid else returns false
	*/
	public boolean authenticateUser(User user) {
		return false;
	}
	/**
	Logs out a user.
	@param user The User object representing the user data
	@return true if the user is successfully logged out else returns false
	*/
	public boolean logout(User user) {
		return false;
	}
}
