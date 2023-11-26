/**
 * 
 */
package com.flipkart.exception;

/**
 * 
 */
public class NoSlotsFoundException extends Exception {
	@Override
	public String getMessage() {
		return "No slots found!";
	}
}
