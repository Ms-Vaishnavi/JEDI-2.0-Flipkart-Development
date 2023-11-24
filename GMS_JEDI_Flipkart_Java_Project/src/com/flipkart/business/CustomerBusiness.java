/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.*;
import java.util.*;

public class CustomerBusiness {

	List<Customer> customers = new ArrayList<>();
	Customer customer1 = new Customer("c1@gmail.com", "c1", "Customer", "Vaishnavi", "0000", 22, "Kanpur");
	Customer customer2 = new Customer("c2@gmail.com", "c2", "Customer", "Anjali", "0000", 32, "Vadodara");
	Customer customer3 = new Customer("c3@gmail.com", "c3", "Customer", "Sudha", "0000", 42, "Kolkata");
	Customer customer4 = new Customer("c4@gmail.com", "c4", "Customer", "Aaishu", "0000", 52, "Mumbai");

	public CustomerBusiness()
	{
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		customers.add(customer4);
	}
	
	public Customer getProfile(Customer customer) {
		for(Customer cust:customers)
		{
			if(cust.getEmail().equals(customer.getEmail()))
				return cust;
		}
		return null;
	}

	public void editProfile(Customer customer) {
		for(Customer cust:customers)
		{
			if(cust.getEmail().equals(customer.getEmail()))
			{
				cust.setName(customer.getName());
				cust.setPhoneNumber(customer.getPhoneNumber());
				cust.setAge(customer.getAge());
				cust.setAddress(customer.getAddress());
				customers.add(cust);
				System.out.println("Successfully edited your profile");
				break;
			}
		}
	}

	public List<Booking> getBookings(String email) {
		return new ArrayList<>();
	}

	public boolean cancelBooking(String bookingId, String customerId) {
		return false;
	}

	public List<Gym> getGymInCity(String city) {
		return new ArrayList<>();
	}

	public List<Slot> getSlotInGym(String gymId) {
		return new ArrayList<>();
	}

	public int bookSlot(String gymId, String slotId, String customerId, Date date) {
		return 0;
	}

	public boolean isSlotBooked(String slotId, Date date) {
		return false;
	}
	
	public boolean hasBookedSlotAlready(String slotId, String customerId, Date date) {
		return false;
	}


}
