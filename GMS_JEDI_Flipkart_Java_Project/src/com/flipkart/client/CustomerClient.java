package com.flipkart.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;
import com.flipkart.business.CustomerBusiness;
import com.flipkart.business.UserBusiness;
import com.flipkart.constants.ColorConstants;
import com.flipkart.exception.UserAlreadyExistsException;

public class CustomerClient {

	Customer customer = new Customer();
	CustomerBusiness customerBusiness = new CustomerBusiness();
	Scanner sc = new Scanner(System.in);

	public void registerCustomer() {
		System.out.print("Enter email: ");
		customer.setEmail(sc.next());
		System.out.print("Enter password: ");
		customer.setPassword(sc.next());
		System.out.print("Enter Name: ");
		customer.setName(sc.next());
		System.out.print("Enter Phone Number: ");
		customer.setPhoneNumber(sc.next());
		System.out.print("Enter Age: ");
		customer.setAge(Integer.valueOf(sc.next()));
		System.out.print("Enter Address: ");
		customer.setAddress(sc.next());
		
		UserBusiness userBusiness = new UserBusiness();
		try {
			userBusiness.registerCustomer(customer);
			System.out
			.println("\n" + ColorConstants.GREEN + "Customer registered successfully!" + ColorConstants.RESET);
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
			System.out.println(
					"\n" + ColorConstants.RED + "Customer registration failed! Try again!" + ColorConstants.RESET);

		}	
	}

	public void viewGyms(String email) throws ParseException {
		getGyms();
		System.out.print("Enter gym ID: ");
		String gymId = sc.next();
		System.out.print("\nEnter Date (yyyy-mm-dd): ");
		String dateStr = sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(dateStr);

		List<Slot> slots = customerBusiness.getSlotInGym(gymId);
		slots.forEach(slot -> {
		    System.out.print("\nSlot Id: " + slot.getSlotId());
		    System.out.print("\nAvailability: " + customerBusiness.isSlotBooked(slot.getSlotId(), date));
		});
		System.out.println("__________________________________________________________________________________\n");
		System.out.print("Enter the slot ID which you want to book: ");
		String slotId = sc.next();
		int bookingResponse = customerBusiness.bookSlot(gymId,slotId, email, date);
		switch (bookingResponse) {
		case 0:
			System.out.println(ColorConstants.GREEN +"You have already booked this time. Cancelling the previous one and booking this slot"+ColorConstants.RESET);
			break;
		case 1:
			System.out.println(ColorConstants.GREEN +"Slot is already booked, added to the waiting list"+ColorConstants.RESET);
			break;
		case 2:
			System.out.println(ColorConstants.GREEN +"Successfully booked the slot"+ColorConstants.RESET);
			break;
		case 3:
			System.out.println(ColorConstants.RED +"Slot not found"+ColorConstants.RESET);
			break;
		default:
			System.out.println(ColorConstants.RED +"Booking failed"+ColorConstants.RESET);
		}
	}

	public void editProfile(String email) {
		System.out.println("Enter Details: ");
		System.out.print("Enter Email: ");
		customer.setEmail(sc.next());
		System.out.print("Enter password: ");
		customer.setPassword(sc.next());
		System.out.print("Enter Name: ");
		customer.setName(sc.next());
		System.out.print("Enter Phone Number: ");
		customer.setPhoneNumber(sc.next());
		System.out.print("Enter Age: ");
		customer.setAge(Integer.valueOf(sc.next()));
		System.out.print("Enter Address: ");
		customer.setAddress(sc.next());
		System.out.println(ColorConstants.GREEN +"\nSuccessfully edited your profile"+ColorConstants.RESET);
	}

	public void getGyms() {
		System.out.print("\nEnter your city: ");
		List<Gym> gyms = customerBusiness.getGymInCity(sc.next());
		gyms.forEach(gym -> {
		    System.out.print("Gym Id: " + gym.getGymId());
		    System.out.print("Gym Owner Email: " + gym.getOwnerEmail());
		    System.out.print("Gym Name: " + gym.getGymName());
		    System.out.println();
		});
	}

	public void cancelBooking(String email) {
		System.out.print("\nEnter booking ID that you want to cancel: ");
		String bookingId = sc.next();
		customerBusiness.cancelBooking(bookingId, email);
	}

	public void customerMenu(String email) throws ParseException {
		int choice = 0;

		while (choice != 5) {
			System.out.println("\nMenu:-");
			System.out.println("1.View Gyms \n2.View Booked Slots \n3.Cancel Booked Slots \n4. Edit Profile \n5.Exit");
			System.out.print("\nEnter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				viewGyms(email);
				break;
			case 2:
				customerBusiness.getBookings(email);
				break;
			case 3:
				cancelBooking(email);
				break;
			case 4:
				editProfile(email);
				break;
			case 5:
				break;
			default:
				System.out.println(ColorConstants.RED +"\nInvalid choice!\n"+ColorConstants.RESET);
			}
		}
	}
}
