package com.flipkart.exception;

/**
 * Exception when customer with the given Id is not found
 */
public class CustomerNotFoundException extends Exception {
    @Override
    public String getMessage(){

        return "Sorry, Customer is not found with the given details!\"";
    }
}
