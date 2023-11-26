package com.flipkart.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.flipkart.bean.Gym;
import com.flipkart.exception.*;

public class CustomerDAO {

	public List<Gym> fetchGymList(){
		List<Gym> gyms = new ArrayList<Gym>();
		String query = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym";
		try (
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS?JEDI20Flip", "root", "root");

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
	        } catch(SQLException e) {
		     printSQLException(e);
	    }
		return gyms;
	}
	
	public void fetchSlotList(int gymId) throws NoSlotsFoundException{
		String query = "Select * From Slot Where gymId=?";
		try (
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS?JEDI20Flip", "root", "root");
			PreparedStatement statement = connection.prepareStatement(query);)
		{
			System.out.println(statement);
			statement.setInt(1, gymId); 
		    ResultSet output = statement.executeQuery();
		    if(!output.next()) {
		    	throw new NoSlotsFoundException();
		    }
		    System.out.println("SlotId \t Capacity \t SlotTime \t GymId");
		    do {
		    	System.out.printf("%-7s\t", output.getString(1) );
				System.out.printf("  %-9s\t",output.getString(2));
				System.out.printf("  %-9s\t", output.getString(3) );
				System.out.printf("  %-9s\t", output.getString(4) );
		    	System.out.println("");
		    }while(output.next());
		    System.out.println("-----------------------------------------------");
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    }
	}
	
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
	public static void printSQLException(SQLException ex) {
		for (Throwable e: ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}