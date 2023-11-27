package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtils;

public class GymOwnerDAOImpl implements GymOwnerDAO{

	/**
	 * Retrieves gym owner details from the database
	 * @param gymOwnerEmail The Email Id of the gym owner
	 * @return GymOwner object
	 */
	public GymOwner getGymOwnerDetails(String gymOwnerEmailId) {
		Connection connection = null;
		GymOwner gymOwner = new GymOwner();
		String query = "select email, name, phoneNum, aadharNum, panNum from gymOwner where email = ?";
		try {connection = DBUtils.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, gymOwnerEmailId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				gymOwner.setEmail(rs.getString("email"));
				gymOwner.setName(rs.getString("name"));
				gymOwner.setPhoneNumber(rs.getString("phoneNum"));
				gymOwner.setAadharNumber(rs.getString("aadharNum"));
				gymOwner.setPanNumber(rs.getString("panNum"));

	                // System.out.println(id + "," + name + "," + email + "," + country + "," + password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		// Step 4: try-with-resource statement will auto close the connection.
		return gymOwner;
	}

	/**
	 * Adds a gym owner to the database
	 * @param GymOwner object
	 */
	public void addGymOwnerDetails(GymOwner gymOwnerDetails) {
		Connection connection = null;
		try {connection = DBUtils.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_INSERT_USER);
			preparedStatement.setString(1, gymOwnerDetails.getEmail());
			preparedStatement.setString(2, gymOwnerDetails.getPassword());
			preparedStatement.setString(3, "GymOwner");

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// print SQL exception information
			printSQLException(e);
		}
		
		System.out.println(SQLConstants.SQL_INSERT_GYM_OWNER);
		// Step 1: Establishing a Connection
		try {connection = DBUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_INSERT_GYM_OWNER);
			preparedStatement.setString(1, gymOwnerDetails.getEmail());
			preparedStatement.setString(2, gymOwnerDetails.getPassword());
			preparedStatement.setString(3, gymOwnerDetails.getName());
			preparedStatement.setString(4, gymOwnerDetails.getPhoneNumber());
			preparedStatement.setString(5, gymOwnerDetails.getAadharNumber());
			preparedStatement.setString(6, gymOwnerDetails.getPanNumber());
			preparedStatement.setBoolean(7, gymOwnerDetails.isVerified());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// print SQL exception information
			printSQLException(e);
		}
	}

	/**
	 * Edits gym owner details in the database
	 * @param GymOwner object
	 */
	public void editGymOwnerDetails(GymOwner gymOwnerDetails) {
		Connection connection = null;
		try {connection = DBUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_UPDATE_USER);
			preparedStatement.setString(1, gymOwnerDetails.getEmail());
			preparedStatement.setString(2, gymOwnerDetails.getPassword());
			preparedStatement.setString(3, "GymOwner");
			preparedStatement.setString(4, gymOwnerDetails.getEmail());
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// print SQL exception information
			printSQLException(e);
		}
		
		System.out.println(SQLConstants.SQL_UPDATE_GYM_OWNER);
		// Step 1: Establishing a Connection
		try {connection = DBUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_UPDATE_GYM_OWNER);
			preparedStatement.setString(1, gymOwnerDetails.getEmail());
			preparedStatement.setString(2, gymOwnerDetails.getName());
			preparedStatement.setString(3, gymOwnerDetails.getPhoneNumber());
			preparedStatement.setString(4, gymOwnerDetails.getAadharNumber());
			preparedStatement.setString(5, gymOwnerDetails.getPanNumber());
			preparedStatement.setBoolean(6, gymOwnerDetails.isVerified());
			preparedStatement.setString(7, gymOwnerDetails.getEmail());
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// print SQL exception information
			printSQLException(e);
		}
	}
	
	/**
	 * Retrieves gym details from the database
	 * @param gymId The Id of the gym
	 * @return Gym object
	 */
	public Gym getGym(String gymId) {
		Connection connection = null;
		Gym gym = new Gym();
		try {connection = DBUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_READ_GYM);
			preparedStatement.setString(1, gymId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				gym.setGymId(rs.getString("gymId"));
				gym.setGymName(rs.getString("gymName"));
				gym.setOwnerEmail(rs.getString("gymOwnerEmail"));
				gym.setAddress(rs.getString("address"));
				gym.setSlotCount(rs.getInt("slotCount"));
				gym.setSeatsPerSlotCount(rs.getInt("seatsPerSlot"));
				gym.setVerified(rs.getBoolean("isVerified"));

//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		// Step 4: try-with-resource statement will auto close the connection.
		return gym;
	}
	
	/**
	 * Adds a gym to the database
	 * @param Gym object
	 */
	public void addGym(Gym gymDetails) {
		Connection connection = null;
		System.out.println(SQLConstants.SQL_INSERT_GYM);
		// Step 1: Establishing a Connection
		try {connection = DBUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_INSERT_GYM);
			preparedStatement.setString(1, gymDetails.getGymId());
			preparedStatement.setString(2, gymDetails.getGymName());
			preparedStatement.setString(3, gymDetails.getOwnerEmail());
			preparedStatement.setString(4, gymDetails.getAddress());
			preparedStatement.setInt(5, gymDetails.getSlotCount());
			preparedStatement.setInt(6, gymDetails.getSeatsPerSlotCount());
			preparedStatement.setBoolean(7, gymDetails.isVerified());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// print SQL exception information
			printSQLException(e);
		}
	}
	
	/**
	 * Edits a gym in the database
	 * @param Gym object
	 */
	public void editGym(Gym gymDetails) {
		Connection connection = null;
		System.out.println(SQLConstants.SQL_UPDATE_GYM);
		// Step 1: Establishing a Connection
		try {connection = DBUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_UPDATE_GYM);
			preparedStatement.setString(1, gymDetails.getGymId());
			preparedStatement.setString(2, gymDetails.getGymName());
			preparedStatement.setString(3, gymDetails.getOwnerEmail());
			preparedStatement.setString(4, gymDetails.getAddress());
			preparedStatement.setInt(5, gymDetails.getSlotCount());
			preparedStatement.setInt(6, gymDetails.getSeatsPerSlotCount());
			preparedStatement.setBoolean(7, gymDetails.isVerified());
			preparedStatement.setString(8, gymDetails.getGymId());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// print SQL exception information
			printSQLException(e);
		}
	}
	
	/**
	 * Retrieves all gym details of a gym owner from the database
	 * @param gymOwnerId The Email Id of the gym owner
	 * @return List of Gym objects
	 */
	public List<Gym> getGymsOfGymOwner(String gymOwnerId) {
		Connection connection = null;
		List<Gym> gyms = new ArrayList<Gym>();
		String query = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym where gymOwnerEmail =  ?";
		try {connection = DBUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, gymOwnerId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Gym gym = new Gym();
				gym.setGymId(rs.getString("gymId"));
				gym.setGymName(rs.getString("gymName"));
				gym.setOwnerEmail(rs.getString("gymOwnerEmail"));
				gym.setAddress(rs.getString("address"));
				gym.setSlotCount(rs.getInt("slotCount"));
				gym.setSeatsPerSlotCount(rs.getInt("seatsPerSlot"));
				gym.setVerified(rs.getBoolean("isVerified"));
				gyms.add(gym);
//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		// Step 4: try-with-resource statement will auto close the connection.
		return gyms;
	}

	/**
	 * Retrieves all the possible slots of a gym from the database
	 * @param gymId The Id of the gym
	 * @return List of the Slot objects
	 */
	public List<Slot> getPossibleSlots(String gymId) {
		Connection connection = null;
		List<Slot> slots = new ArrayList<Slot>();
		try {connection = DBUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_READ_SLOT_FROM_GYMID);
			preparedStatement.setString(1, gymId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Slot slot = new Slot();
				slot.setSlotId(rs.getString("slotId"));
				slot.setGymId(rs.getString("gymId"));
				slot.setStartTime(rs.getString("startTime"));
				slot.setEndTime(rs.getString("endTime"));
				slot.setTrainer(rs.getString("trainer"));
				slots.add(slot);
//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		// Step 4: try-with-resource statement will auto close the connection.
		return slots;
	}

	/**
	 * Adds a slot in the database
	 * @param Slot object
	 */
	public void addSlot(Slot slot) {
		Connection connection = null;
		System.out.println(SQLConstants.SQL_INSERT_SLOT);
		// Step 1: Establishing a Connection
		try {connection = DBUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_INSERT_SLOT);
			preparedStatement.setString(1, slot.getSlotId());
			preparedStatement.setString(2, slot.getGymId());
			preparedStatement.setString(3, slot.getStartTime());
			preparedStatement.setString(4, slot.getEndTime());
			preparedStatement.setString(5, slot.getTrainer());
			preparedStatement.setInt(6, slot.getNumOfSeats());
			preparedStatement.setInt(7, slot.getNumOfSeatsBooked());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			// print SQL exception information
			printSQLException(e);
		}
	}

	/**
	 * Checks if a gym owner is verified by the Administrator
	 * @param email The emailId of the gym owner
	 */
	public boolean checkOwnerApproval(String email) {
		Connection connection = null;
		String query = "select isVerified from gymOwner where email =  ?";
		try {connection = DBUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			return rs.next();
		} catch (SQLException e) {
			printSQLException(e);
		}
		// Step 4: try-with-resource statement will auto close the connection.
		return false;
	}

	/**
	 * Checks if a gym is verified by the Administrator
	 * @param gymId The Id of the gym
	 */
	public boolean checkGymApproval(String gymId) {
		Connection connection = null;
		String query = "select isVerified from gym where gymId =  ?";
		try {connection = DBUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, gymId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			return rs.next();
		} catch (SQLException e) {
			printSQLException(e);
		}
		// Step 4: try-with-resource statement will auto close the connection.
		return false;
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
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