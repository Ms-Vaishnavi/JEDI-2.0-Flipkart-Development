/**
 * 
 */
package com.flipkart.DAO;
import com.flipkart.bean.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class AdminDAO {
	public List<GymOwner> getAllGymOwners() {
		List<GymOwner> gymOwners = new ArrayList<GymOwner>();
		String query = "select email, name, phoneNum, aadharNum, panNum, isVerified from gymOwner";
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/GMS?JEDI20Flip", "root", "root");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(query);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	GymOwner gymOwner = new GymOwner();
	                gymOwner.setEmail(rs.getString("email"));
	                gymOwner.setName(rs.getString("name"));
	                gymOwner.setPhoneNumber(rs.getString("phoneNum"));
	                gymOwner.setAadharNumber(rs.getString("aadharNum"));
	                gymOwner.setPanNumber(rs.getString("panNum"));
	                gymOwner.setVerified(rs.getBoolean("isVerified"));
	                gymOwners.add(gymOwner);
//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        // Step 4: try-with-resource statement will auto close the connection.
		return gymOwners;
	};
	
	public List<Gym> getAllGyms() {
		List<Gym> gyms = new ArrayList<Gym>();
		String query = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym";
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/GMS?JEDI20Flip", "root", "root");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(query);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

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
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        // Step 4: try-with-resource statement will auto close the connection.
		return gyms;
	};
	
	public List<GymOwner> getPendingGymOwnerRequests() {
		List<GymOwner> gymOwners = new ArrayList<GymOwner>();
		String query = "select email, name, phoneNum, aadharNum, panNum, isVerified from gymOwner where isVerified = ?;";
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/GMS?JEDI20Flip", "root", "root");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(query);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            preparedStatement.setBoolean(1, false);
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	GymOwner gymOwner = new GymOwner();
	                gymOwner.setEmail(rs.getString("email"));
	                gymOwner.setName(rs.getString("name"));
	                gymOwner.setPhoneNumber(rs.getString("phoneNum"));
	                gymOwner.setAadharNumber(rs.getString("aadharNum"));
	                gymOwner.setPanNumber(rs.getString("panNum"));
	                gymOwner.setVerified(rs.getBoolean("isVerified"));
	                gymOwners.add(gymOwner);
//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        // Step 4: try-with-resource statement will auto close the connection.
		return gymOwners;
		
	};
	
	public List<Gym> getPendingGymRequests() {
		List<Gym> gyms = new ArrayList<Gym>();
		String query = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym where isVerified = ?;";
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/GMS?JEDI20Flip", "root", "root");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(query);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            preparedStatement.setBoolean(1, false);
	            ResultSet rs = preparedStatement.executeQuery();

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
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        // Step 4: try-with-resource statement will auto close the connection.
		return gyms;
		
	};
	
	public void approveSingleOwnerRequest(String requestId) {
		
	};
	
	public void approveAllOwnerRequest() {
		
	};
	
	public void approveSingleGymRequest(int gymId) {
		
	};
	
	public void approveAllGymRequest() {
		
	};
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
