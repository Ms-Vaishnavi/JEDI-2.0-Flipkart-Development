package com.flipkart.exception; 

/**
 * Exception when entered input is invalid
 */
public class InvalidInputException extends Exception {
	@Override
    public String getMessage(){
    	return "Input is invalid! Please recheck!";
    }
}

