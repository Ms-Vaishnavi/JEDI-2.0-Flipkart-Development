/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.constants.ColorConstants;

import java.util.Date;
import java.util.*;

public class CustomerBusiness {

	List<Customer> customers = new ArrayList<>();
	List<Booking> bookings=new ArrayList<>();

	List<Slot>slots=new ArrayList<>();
	List<Gym> gyms = new ArrayList<>();

	Date d1=new Date();
	Customer customer1 = new Customer("c1@gmail.com", "c1", "Customer", "Vaishnavi", "0000", 22, "Kanpur");
	Customer customer2 = new Customer("c2@gmail.com", "c2", "Customer", "Anjali", "0000", 32, "Vadodara");
	Customer customer3 = new Customer("c3@gmail.com", "c3", "Customer", "Sudha", "0000", 42, "Kolkata");
	Customer customer4 = new Customer("c4@gmail.com", "c4", "Customer", "Aaishu", "0000", 52, "Mumbai");



	Booking b1=new Booking("123","121","171","confirmed",d1,"c1@gmail.com","John");
	Booking b2=new Booking("173","191","131","waitlisted",d1,"c2@gmail.com","Jack");
	Booking b3=new Booking("113","129","173","confirmed",d1,"c3@gmail.com","Johnathon");
	Booking b4=new Booking("193","127","971","waitlisted",d1,"c4@gmail.com","J");

	Slot s1=new Slot("900","1400","1500",100,"John","g1");
	Slot s2=new Slot("910","1500","1600",100,"J","g2");
	Slot s3=new Slot("930","1600","1700",100,"Jack","g3");
	Slot s4=new Slot("950","1700","1800",100,"Johnny","g4");


	Gym gym1 = new Gym("g1", "gym1", "gymowner1@gmail.com", "Kanpur", 2, 5, true);
	Gym gym2 = new Gym("g2", "gym2", "gymowner2@gmail.com", "Hyderabad", 3, 5, true);
	Gym gym3 = new Gym("g3", "gym3", "gymowner3@gmail.com", "Bangalore", 2, 3, true);
	Gym gym4 = new Gym("g4", "gym4", "gymowner4@gmail.com", "Cochin", 6, 5, true);

	public CustomerBusiness()
	{
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		customers.add(customer4);

		bookings.add(b1);
		bookings.add(b2);
		bookings.add(b3);
		bookings.add(b4);

		slots.add(s1);
		slots.add(s2);
		slots.add(s3);
		slots.add(s4);

		gyms.add(gym1);
		gyms.add(gym2);
		gyms.add(gym3);
		gyms.add(gym4);
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

		List<Booking> customerBookings=new ArrayList<Booking>();

		for(Booking b:bookings)
		{
			if(b.getCustomerEmail().equals(email))
			{
				customerBookings.add(b);
			}
		}
		return customerBookings;
	}

	public boolean cancelBooking(String bookingId, String email) {
		
		for(Booking booking: bookings)
		{
			if(booking.getBookingId().equals(bookingId))
			{
				bookings.remove(booking);
				System.out.println(ColorConstants.GREEN+"Successfully cancelled your booking"+ColorConstants.RESET);
				return true;
			}
		}
		return false;
	}

	public List<Gym> getGymInCity(String city) {
			List<Gym> newGym = new ArrayList<Gym>();
			for(Gym gym:gyms)
			{
				if(gym.getAddress().equals(city))
				{
					newGym.add(gym);
				}
			}
			return newGym;
		}

	public List<Slot> getSlotInGym(String gymId) {
	     List<Slot> slotsOfGym=new ArrayList<>();
		 for(Slot s:slots)
		 {
			 if(s.getGymId().equals(gymId))
			 {
				 slotsOfGym.add(s);
			 }
		 }
		 return slotsOfGym;
	}

	public int bookSlot(String gymId, String slotId, String customerId, Date date) {
		return 0;
	}

	public boolean isSlotBooked(String slotId, Date date) {
		return false;
	}
	
	public boolean hasBookedSlotAlready(String slotId, String customerEmail, Date date) {
		for(Booking b:bookings)
		{
			if(b.getSlotId().equals(slotId))
			{
				if(b.getCustomerEmail().equals(customerEmail))
					return true;
			}
		}
		return false;
	}


}
