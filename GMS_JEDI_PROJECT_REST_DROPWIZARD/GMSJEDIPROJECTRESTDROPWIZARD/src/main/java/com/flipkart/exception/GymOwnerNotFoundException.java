package com.flipkart.exception;

/**
 * Exception when Gym with the given Id is not found
 */
public class GymOwnerNotFoundException extends Exception{
	@Override
	public String getMessage() {
		return "Sorry, gym owner is not found with the given details!";
	}
}
