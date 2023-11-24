package com.flipkart.dao;
import com.flipkart.bean.*;
import com.flipkart.bean.User;
import com.flipkart.exception.UserNotFoundException;

public class UserDao {
	
	public boolean isAuthenticated(User userData) throws UserNotFoundException{
		return true;
	}
	
	public void registerCustomer(Customer customerData) {
		
	}
	
	public void registerGymOwner(GymOwner ownerData) {
		
	}
	
	public void registerUser(User userData) {
		
	}
}