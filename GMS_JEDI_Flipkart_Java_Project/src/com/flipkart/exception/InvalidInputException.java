package com.flipkart.exception; 

public class InvalidInputException extends Exception {
	@Override
    public String getMessage(){
    	return "Input is invalid! Please recheck!";
    }
}

