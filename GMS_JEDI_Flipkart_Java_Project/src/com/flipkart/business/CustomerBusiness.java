/**
 *
 */
package com.flipkart.business;

import com.flipkart.DAO.*;
import com.flipkart.bean.*;
import com.flipkart.constants.ColorConstants;
import com.flipkart.exception.SlotNotFoundException;
import com.flipkart.utils.IdGenerator;
import java.util.Date;
import java.util.*;

public class CustomerBusiness implements CustomerBusinessInterface {

	CustomerDAOImpl customerDAO = new CustomerDAOImpl();
	List<Customer> customers = new ArrayList<>();
	List<Booking> bookings = new ArrayList<>();

	List<Slot> slots = new ArrayList<>();
	List<Gym> gyms = new ArrayList<>();
	//Date d1 = new Date();
	

	/**
	 * Obtains customer's profile details 
	 * @param customer the Customer object for which the profile details are requested
	 * @return Customer the Customer's object
	 */
	public Customer getProfile(Customer customer) {
		System.out.println(ColorConstants.GREEN+"Successfully fetched the customer profile"+ColorConstants.RESET);
		return customerDAO.getProfile(customer);
	}

	/**
	 * Gives functionality of updating customer's personal data. 
	 * @param customer the Customer object for which the profile data needs to be updated
	 */
	public void editProfile(Customer customer) {
		for (Customer cust : customers) {
			if (cust.getEmail().equals(customer.getEmail())) {
				cust.setName(customer.getName());
				cust.setPhoneNumber(customer.getPhoneNumber());
				cust.setAge(customer.getAge());
				cust.setAddress(customer.getAddress());
				customers.add(cust);
				System.out.println(ColorConstants.GREEN+"Successfully edited your profile\ns"+ColorConstants.RESET);
				break;
			}
		}
	}
	/**
	 * Obtains all the bookings done by the given customer email.
	 * @param email the Customer email for which the bookings data are requested
	 * @return List of bookings done by the given customer email
	 */
	public List<Booking> getBookings(String email) {
		System.out.println(ColorConstants.GREEN+"Successfully fetched the list of bookings"+ColorConstants.RESET);
	      return customerDAO.fetchBookedSlots(email);
	}
	/**
	 * Performs booking cancellation operation for the given customer email.
	 * @param bookingId the id of booking for which cancellation needs to be performed
	 * @param email the Customer email for which the booking cancellation is requested
	 * @return returns true of the booking gets cancelled successfully else returns false
	 */
	public boolean cancelBooking(String bookingId, String email)  {
		System.out.println(ColorConstants.GREEN+"Successfully deleted the booking "+ColorConstants.RESET);
		return customerDAO.cancelBooking(bookingId, email);
	}
	/**
	 * Obtains all the gyms for the given city.
	 * @param city the city name for which the gym list is requested
	 * @return returns List of gyms available for the given city
	 */
	public List<Gym> getGymInCity(String city) {
		System.out.println(ColorConstants.GREEN+"Successfully fetched the gyms in city "+city+ColorConstants.RESET);
		return customerDAO.fetchGymList(city);
		
	}
	/**
	 * Obtains all the slots for the given gymId.
	 * @param gymId the Gym Id for which the slot details are requested
	 * @return returns List of available slots for the given gymId
	 */
	public List<Slot> getSlotInGym(String gymId) {
		try {
			List<Slot> slotsOfGym = customerDAO.fetchSlotList(gymId);
			return slotsOfGym;
		} catch(SlotNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	/**
	 * Performs booking operation for the given customer email on the given date for the given slotId
	 * @param email the email of customer who requested the booking operation
	 * @param slotId the slot id in which the customer wants to book a seat
	 * @param date the date on which the customer wants to book a seat
	 * @return returns integer signal based on the customer's booking status
	 */
	public int bookSlot(String gymId, String slotId, String email, Date date)
	{
		int num = customerDAO.getNumberOfSeatsBooked(slotId);
		if(customerDAO.alreadyBooked(slotId, email, date))
		{
			customerDAO.cancelBooking(slotId, email);
			customerDAO.updateNumOfSeats(slotId,num++);
			if(num>0)
			{
				customerDAO.updateNumOfSeats(slotId,num--);
				customerDAO.bookSlots(IdGenerator.generateId("Booking"), slotId, gymId,"confirmed",date,email);
			}
			else
			{
				customerDAO.updateNumOfSeats(slotId,num--);
				customerDAO.bookSlots(IdGenerator.generateId("Booking"), slotId, gymId,"waitlisted",date,email);
			}
			return 0;
		}
		if(customerDAO.isFull(slotId, date))
		{
			customerDAO.updateNumOfSeats(slotId,num--);
			customerDAO.bookSlots(IdGenerator.generateId("Booking"), slotId, gymId,"waitlisted",date,email);
			return 1;
		}
		else
		{
			if(num>0)
			{
				customerDAO.updateNumOfSeats(slotId,num--);
				customerDAO.bookSlots(IdGenerator.generateId("Booking"), slotId, gymId,"confirmed",date,email);
			}
			else
			{
				customerDAO.updateNumOfSeats(slotId,num--);
				customerDAO.bookSlots(IdGenerator.generateId("Booking"), slotId, gymId,"waitlisted",date,email);
			}
			return 2;
		}
		
	}
	
	/**
	 * Checks if the slot is already booked or not
	 * @param slotId the slot id for which the booking status is requested
	 * @param date the date on which the booking status is requested
	 * @return returns true if the slot id for the given date is fully booked else returns false
	 */
	public boolean isSlotBooked(String slotId, Date date) {
		return customerDAO.isFull(slotId, date);
	}
	/**
	 * Checks if the customer has already booked a seat in the same slot for the given date
	 * @param slotId the slot id for which the booking status is requested
	 * @param date the date on which the booking status is requested
	 * @param customerEmail the email of customer for which the booking status is getting checked
	 * @return returns true if the customer has already booked a seat on the same date in the same slot
	 */
	public boolean hasBookedSlotAlready(String slotId, String customerEmail, Date date) {
		return customerDAO.alreadyBooked(slotId, customerEmail, date);
	}
	
	/**
	 * Checks if a gym is approved for a specified gym ID.
	 * @param gymId The ID of the gym
	 * @return true if the gym is approved, false otherwise
	 */
	public boolean checkGymApprove(String gymId) {
		return customerDAO.checkGymApprove(gymId);
	}

}
