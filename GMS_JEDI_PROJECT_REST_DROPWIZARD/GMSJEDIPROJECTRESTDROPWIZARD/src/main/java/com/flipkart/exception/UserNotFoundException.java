package com.flipkart.exception; 

/**
 * Exception when User with the given Id is not found
 */
public class UserNotFoundException extends Exception {
	@Override
    public String getMessage(){
        return "Wrong credentials entered! Please recheck!";
    }
}

