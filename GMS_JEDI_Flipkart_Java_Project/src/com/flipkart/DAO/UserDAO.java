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

public class UserDAO {

	public boolean authenticateUser(User user) {
		boolean isUserValid = false;
		String query = "select email, password, role from user where email = ?";
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/GMS", "root", "");
			PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			
			preparedStatement.setString(1, user.getEmail());
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				if(user.getPassword().equals(rs.getString("password")) && user.getRoleId().equalsIgnoreCase(rs.getString("role"))) {
					System.out.println(rs.getString("email") +" "+ rs.getString("password") +" "+ rs.getString("role"));
					isUserValid = true;
				}
			}
			
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		return isUserValid;
	}

	public boolean registerCustomer(Customer customerData) {
		return false;
	}

	public boolean registerGymOwner(GymOwner ownerData) {
		return false;
	}

	public void registerUser(User userData) {

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