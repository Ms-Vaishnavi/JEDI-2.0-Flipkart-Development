package com.flipkart.DAO;
import com.flipkart.bean.*;
import com.flipkart.bean.User;
import com.flipkart.exception.UserNotFoundException;

public class UserDAO {
	
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