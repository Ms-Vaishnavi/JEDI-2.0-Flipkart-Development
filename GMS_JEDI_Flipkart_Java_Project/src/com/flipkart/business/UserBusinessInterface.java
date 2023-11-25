package com.flipkart.business;

import com.flipkart.bean.*;
import java.util.*;
import com.flipkart.exception.*;



public interface UserBusinessInterface{

    public boolean registerCustomer(Customer customer);
    /*
    Registers a new customer
    */

    public boolean registerGymOwner(GymOwner gymOwner);
    /*
    Registers a new Gym Owner
    */

    public boolean authenticateUser(User user);
    /*
    Authenticates a user
    */

    public boolean logout(User user);
    /*
    Logs out a user
    */
}