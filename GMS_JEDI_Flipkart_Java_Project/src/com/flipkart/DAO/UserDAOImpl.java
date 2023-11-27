package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.bean.User;
import com.flipkart.exception.UserNotFoundException;

public class UserDAOImpl implements UserDAO {

	public boolean authenticateUser(User user) {
		// to run without authentication, make isUserValid = true
		boolean isUserValid = false;
		String query = "select email, password, role from user where email = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root", "");
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			preparedStatement.setString(1, user.getEmail());

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				if (user.getPassword().equals(rs.getString("password"))
						&& user.getRoleId().equalsIgnoreCase(rs.getString("role"))) {
					System.out.println(
							rs.getString("email") + " " + rs.getString("password") + " " + rs.getString("role"));
					isUserValid = true;
				}
			}

		} catch (SQLException e) {
			printSQLException(e);
		}

		return isUserValid;
	}

	public boolean registerCustomer(Customer customer) {
		boolean registerSuccess = false;
		String query = "INSERT INTO customer VALUES (?,?,?,?,?)";
		String queryUser = "INSERT INTO user VALUES (?,?,?)";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS_JEDI_Flip", "root", "");
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				PreparedStatement preparedStatementUser = connection.prepareStatement(queryUser);) {

			preparedStatement.setString(1, customer.getEmail());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getPhoneNumber());
			preparedStatement.setInt(4, customer.getAge());
			preparedStatement.setString(1, customer.getAddress());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected != 0)
				registerSuccess = true;

			preparedStatementUser.setString(1, customer.getEmail());
			preparedStatementUser.setString(2, customer.getPassword());
			preparedStatementUser.setString(3, "Customer");

			rowsAffected = preparedStatementUser.executeUpdate();
			if (rowsAffected != 0)
				registerSuccess = true;

		} catch (SQLException e) {
			printSQLException(e);
		}

		return registerSuccess;
	}

	public boolean registerGymOwner(GymOwner gymOwner) {
		boolean registerSuccess = false;
		String query = "INSERT INTO gymOwner VALUES (?,?,?,?,?,?)";
		String queryOwner = "INSERT INTO user VALUES (?,?,?)";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root", "");
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				PreparedStatement preparedStatementOwner = connection.prepareStatement(queryOwner);) {

			preparedStatement.setString(1, gymOwner.getEmail());
			preparedStatement.setString(2, gymOwner.getName());
			preparedStatement.setString(3, gymOwner.getPhoneNumber());
			preparedStatement.setString(4, gymOwner.getAadharNumber());
			preparedStatement.setString(5, gymOwner.getPanNumber());
			preparedStatement.setBoolean(6, gymOwner.isVerified());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected != 0)
				registerSuccess = true;

			preparedStatementOwner.setString(1, gymOwner.getEmail());
			preparedStatementOwner.setString(2, gymOwner.getPassword());
			preparedStatementOwner.setString(3, "GymOwner");

			rowsAffected = preparedStatementOwner.executeUpdate();
			if (rowsAffected != 0)
				registerSuccess = true;

		} catch (SQLException e) {
			printSQLException(e);
		}

		return registerSuccess;
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