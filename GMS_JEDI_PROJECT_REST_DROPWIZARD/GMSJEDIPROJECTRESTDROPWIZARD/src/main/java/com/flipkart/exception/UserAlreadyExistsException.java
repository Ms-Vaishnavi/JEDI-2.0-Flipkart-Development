package com.flipkart.exception;

/**
 * Exception when registration is done with an already existing Id
 */
public class UserAlreadyExistsException extends Exception{
	@Override
	public String getMessage() {return "User already exists!";
	}
}
