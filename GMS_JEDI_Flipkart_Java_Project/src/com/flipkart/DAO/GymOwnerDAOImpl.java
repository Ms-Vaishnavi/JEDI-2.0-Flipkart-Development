package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.*;

public class GymOwnerDAOImpl implements GymOwnerDAO{

	public GymOwner getGymOwnerDetails(String gymOwnerEmailId) {
		GymOwner gymOwner = new GymOwner();
		String query = "select email, name, phoneNum, aadharNum, panNum from gymOwner where email = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root",
				"JEDI20Flip");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
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

//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		// Step 4: try-with-resource statement will auto close the connection.
		return gymOwner;
	}

	public void addGymOwnerDetails(GymOwner gymOwnerDetails) {
		String INSERT_GYM_OWNER_SQL = "INSERT INTO gymOwner"
				+ "  (email, password, name, phoneNum, aadharNum, panNum, isVerified) VALUES "
				+ " (?, ?, ?, ?, ?, ?, ?);";
		System.out.println(INSERT_GYM_OWNER_SQL);
		// Step 1: Establishing a Connection
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root",
				"JEDI20Flip");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GYM_OWNER_SQL)) {
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

	public void editGymOwnerDetails(GymOwner gymOwnerDetails) {
		String UPDATE_GYM_OWNER_SQL = "update gymOwner set email = ?, password = ?, name = ?, phoneNum = ?, aadharNum = ?, panNum = ?, isVerified = ? "
				+ "where email = ?;";
		System.out.println(UPDATE_GYM_OWNER_SQL);
		// Step 1: Establishing a Connection
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root",
				"JEDI20Flip");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GYM_OWNER_SQL)) {
			preparedStatement.setString(1, gymOwnerDetails.getEmail());
			preparedStatement.setString(2, gymOwnerDetails.getPassword());
			preparedStatement.setString(3, gymOwnerDetails.getName());
			preparedStatement.setString(4, gymOwnerDetails.getPhoneNumber());
			preparedStatement.setString(5, gymOwnerDetails.getAadharNumber());
			preparedStatement.setString(6, gymOwnerDetails.getPanNumber());
			preparedStatement.setBoolean(7, gymOwnerDetails.isVerified());
			preparedStatement.setString(8, gymOwnerDetails.getEmail());
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// print SQL exception information
			printSQLException(e);
		}
	}

	public Gym getGym(String gymId) {
		Gym gym = new Gym();
		String query = "select gymId, gymName, gymOwnerEmail, address, slotCount, seatsPerSlot, isVerified from gym where gymId = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root",
				"JEDI20Flip");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
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

	public void addGym(Gym gymDetails) {
		String INSERT_GYM_SQL = "INSERT INTO gym"
				+ "  (gymId, gymName, gymOwnerEmail, address, slotCount, seatsPerSlot, isVerified) VALUES "
				+ " (?, ?, ?, ?, ?, ?, ?);";
		System.out.println(INSERT_GYM_SQL);
		// Step 1: Establishing a Connection
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root",
				"JEDI20Flip");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GYM_SQL)) {
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

	public void editGym(Gym gymDetails) {
		String INSERT_GYM_SQL = "update gym"
				+ "  set gymId = ?, gymName = ?, gymOwnerEmail = ?, address = ?, slotCount = ?, seatsPerSlot = ?, isVerified = ? where gymId = ?;";
		System.out.println(INSERT_GYM_SQL);
		// Step 1: Establishing a Connection
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root",
				"JEDI20Flip");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GYM_SQL)) {
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

	public List<Gym> getGymsOfGymOwner(String gymOwnerId) {
		List<Gym> gyms = new ArrayList<Gym>();
		String query = "select gymId, gymName, gymOwnerEmail, address, slotCount, seatsPerSlot, isVerified from gym where gymOwnerEmail =  ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root",
				"JEDI20Flip");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
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

	public List<Slot> getPossibleSlots(String gymId) {
		List<Slot> slots = new ArrayList<Slot>();
		String query = "select slotId, gymId, startTime, endTime, trainer from slot where gymId =  ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root",
				"JEDI20Flip");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
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

	public void addSlot(Slot slot) {
		String INSERT_SLOT_SQL = "INSERT INTO slot" + "  (slotId, gymId, startTime, endTime, trainer) VALUES "
				+ " (?, ?, ?, ?, ?);";
		System.out.println(INSERT_SLOT_SQL);
		// Step 1: Establishing a Connection
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root",
				"JEDI20Flip");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SLOT_SQL)) {
			preparedStatement.setString(1, slot.getSlotId());
			preparedStatement.setString(2, slot.getGymId());
			preparedStatement.setString(3, slot.getStartTime());
			preparedStatement.setString(4, slot.getEndTime());
			preparedStatement.setString(5, slot.getTrainer());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			// print SQL exception information
			printSQLException(e);
		}
	}

	public boolean checkOwnerApproval(String email) {
		String query = "select isVerified from gymOwner where email =  ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root",
				"JEDI20Flip");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
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

	public boolean checkGymApproval(String gymId) {
		String query = "select isVerified from gym where gymId =  ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root",
				"JEDI20Flip");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
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