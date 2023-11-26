package com.flipkart.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.flipkart.bean.Gym;

public class CustomerDAO {

	public List<Gym> fetchGymList(){
		List<Gym> gyms = new ArrayList<Gym>();
		String query = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS?JEDI20Flip", "root", "root");

	            // Step 2:Create a statement using connection object
	            PreparedStatement statement = connection.prepareStatement(query);) {
	            System.out.println(statement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = statement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	Gym gym = new Gym();
	                gym.setGymId(rs.getString("gymId"));
	                gym.setGymName(rs.getString("gymName"));
	                gym.setOwnerEmail(rs.getString("ownerEmail"));
	                gym.setAddress(rs.getString("address"));
	                gym.setSlotCount(rs.getInt("slotCount"));
	                gym.setSeatsPerSlotCount(rs.getInt("seatsPerSlotCount"));
	                gym.setVerified(rs.getBoolean("isVerified"));
	                gyms.add(gym);
//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
	            }
	        } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    }
		return gyms;
	}
	
	public void fetchSlotList(int gymId) {}
	
	public void fetchBookedSlots(String email) {}
	
	public void bookSlots(int gymId, String slotId,String email,String date) {}
	
	public boolean isFull(String slotId,String date) {
		return true;
	}

	public boolean alreadyBooked(String slotId, String email, String date) {
		return true;
	}

	public void cancelBooking(String slotId, String email, String date) {
		
	}

	public boolean checkSlotExists(String slotId, int gymId) {
		return true;
	}

	public void cancelBookedSlots(String email, int bookingId) {
		
	}

	public boolean checkGymApprove(int gymId) {
		return true;
	}

}