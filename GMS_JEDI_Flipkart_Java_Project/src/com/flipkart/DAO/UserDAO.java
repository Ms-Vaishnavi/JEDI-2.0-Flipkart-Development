package com.flipkart.dao;
import com.flipkart.bean.*;
import com.flipkart.bean.User;
import com.flipkart.exception.UserNotFoundException;

public interface UserDao {
	
	public User isAuthenticated(User userData) throws UserNotFoundException;
	
	public void registerCustomer(Customer customerData);
	
	public void registerGymOwner(GymOwner ownerData);
	
	public void registerUser(User userData);
}