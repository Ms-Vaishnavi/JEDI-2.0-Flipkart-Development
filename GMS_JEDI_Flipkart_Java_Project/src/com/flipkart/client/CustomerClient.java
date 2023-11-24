/**
 * 
 */
package com.flipkart.client;
import com.flipkart.business.*;
import com.flipkart.bean.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 
 */
public class CustomerClient {

	/**
	 * @param args
	 */
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		CustomerBusiness customerBusiness = new CustomerBusiness();
		Scanner sc = new Scanner(System.in);
		
		public void registerCustomer() {
			System.out.println("Enter email: ");
			customer.setName(sc.next());
			System.out.println("Enter password: ");
			customer.setPassword(sc.next());
			System.out.println("Enter Name: ");
			customer.setName(sc.next());
			System.out.println("Enter Phone Number: ");
			customer.setPhoneNumber(sc.next());
			System.out.println("Enter Age: ");
			customer.setAge(Integer.valueOf(sc.next()));
			System.out.println("Enter Address: ");
			customer.setAddress(sc.next());
			UserBusiness userBusiness = new UserBusiness();
			userBusiness.registerCustomer(customer);
			
			System.out.println("Customer registered successfully!");
			
		}
		
		
		public void viewGyms(String email) throws ParseException {
			getGyms();
			System.out.print("Enter gym ID");
			String gymId = sc.next();
			System.out.print("Enter Date (yyyy-mm-dd): ");
			String dateStr = sc.next();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse(dateStr);
			
			List<Slot> slots = customerBusiness.getSlotInGym(gymId);
			for (Slot slot: slots) {
				System.out.print("Slot Id: " + slot.getSlotId());
				System.out.print("Availability: " + customerBusiness.isSlotBooked(slot.getSlotId(), date));
			}
			System.out.print("Enter the slot ID which you want to book: " );
			String slotId = sc.next();
			int bookingResponse = customerBusiness.bookSlot(gymId, slotId, email, date);
			switch(bookingResponse) {
			case 0: 
				System.out.println("You have already booked this time. Cancelling the previous one and booking this slot");
				break;
			case 1:
				System.out.println("Slot is already booked");
				break;
			case 2:
				System.out.println("Successfully booked the slot");
				break;
			default:
				System.out.println("Booking falied");
			}
		}
		
		public void editProfile(String email)
		{
			System.out.println("Enter password: ");
			customer.setPassword(sc.next());
			System.out.println("Enter Name: ");
			customer.setName(sc.next());
			System.out.println("Enter Phone Number: ");
			customer.setPhoneNumber(sc.next());
			System.out.println("Enter Age: ");
			customer.setAge(Integer.valueOf(sc.next()));
			System.out.println("Enter Address: ");
			customer.setAddress(sc.next());
			System.out.println("Successfully edited your profile");
		}
		
		public void getGyms() {
			System.out.println("Enter your city: ");
			List<Gym> gyms = customerBusiness.getGymInCity(sc.next());
			for (Gym gym: gyms) {
				System.out.print("Gym Id: " + gym.getGymId());
				System.out.print("Gym Owner Email: " + gym.getOwnerEmail());
				System.out.print("Gym Name: " + gym.getGymName());
				System.out.println();
			}
		}
		
		public void cancelBooking(String email) {
			System.out.print("Enter booking ID that you want to cancel");
			String bookingId = sc.next();
			customerBusiness.cancelBooking(bookingId, email);
		}
		
		public void customerMenu(String email) throws ParseException {
			int choice = 0;
			
			while(choice != 4) {				
				System.out.println("Menu:-");
				System.out.println("1.View Gyms \n2.View Booked Slots \n3.Cancel Booked Slots \n4. Edit Profile \n5.Exit");
				System.out.print("Enter your choice: ");
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
//						applicationClient.mainPage();
						break;
					case 5:
						break;
					default:
						System.out.println("Invalid choice!");
				}
			}
		}
}
