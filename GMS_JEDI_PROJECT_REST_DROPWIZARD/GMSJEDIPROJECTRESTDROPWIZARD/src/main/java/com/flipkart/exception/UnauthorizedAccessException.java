package com.flipkart.exception;

/**
 * Exception when user is not authorized to perform an action
 */
public class UnauthorizedAccessException extends Exception {
	@Override
	public String getMessage() {
		return "Sorry, you are not authorized to make this change!";
	}
}
