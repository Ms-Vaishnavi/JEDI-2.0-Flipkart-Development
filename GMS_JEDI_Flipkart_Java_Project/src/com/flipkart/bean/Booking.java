/**
 * 
 */
package com.flipkart.bean;

import java.util.Date;
import java.util.*;

/**
 * 
 */
public class Booking {
	private String bookingId;
	private String slotId;
	private String gymId;
	private String type;
	private Date date;
	private String customerEmail;
	private String trainer;

	public Booking() {
		super();
	}//default constructor

	public Booking(String bookingId,String slotId,String gymId,String type,Date date,String customerEmail,String trainer)
	{
		this.bookingId=bookingId;
		this.slotId=slotId;
		this.gymId=gymId;
		this.type=type;
		this.date=date;
		this.customerEmail=customerEmail;
		this.trainer=trainer;
	}


	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public String getGymId() {
		return gymId;
	}

	public void setGymId(String gymId) {
		this.gymId = gymId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
}
