package com.flipkart.exception;

/*
 * Exception when Gym with the given Id is not found
 */
public class GymNotFoundException extends Exception {
	@Override
    public String getMessage() {
        return "Sorry, Gym details not found!";
    }
}