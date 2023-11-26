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

    public List<Gym> fetchGymList() {
        List<Gym> gyms = new ArrayList<Gym>();
        String query = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym";
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root", "JEDI20Flip");

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
        } catch (SQLException e) {
            printSQLException(e);
        }
        return gyms;
    }

    public void fetchSlotList(int gymId) throws NoSlotsFoundException {
        String query = "Select * From Slot Where gymId=?";
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root", "JEDI20Flip");
                PreparedStatement statement = connection.prepareStatement(query);) {
            System.out.println(statement);
            statement.setInt(1, gymId);
            ResultSet output = statement.executeQuery();
            if (!output.next()) {
                throw new NoSlotsFoundException("No slot found");
            }
            System.out.println("SlotId \t Capacity \t SlotTime \t GymId");
            do {
                System.out.printf("%-7s\t", output.getString(1));
                System.out.printf("  %-9s\t", output.getString(2));
                System.out.printf("  %-9s\t", output.getString(3));
                System.out.printf("  %-9s\t", output.getString(4));
                System.out.println("");
            } while (output.next());
            System.out.println("-----------------------------------------------");
        } catch (SQLException sqlExcep) {
            printSQLException(sqlExcep);
        }
    }

    public void fetchBookedSlots(String email) {
        String query = "Select * From Booking where customerEmail = ?";
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root", "JEDI20Flip");
                PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setString(1, email);
            ResultSet output = statement.executeQuery();
            System.out.println("BookingId \t Date \t    GymId");
            while (output.next()) {
                System.out.printf("%-12s\t", output.getInt(1));
                System.out.printf("  %-7s\t", output.getString(5));
                System.out.printf("%-8s\t", output.getString(3));
                System.out.println("");
            }
            System.out.println("-----------------------------------------------");
        } catch (SQLException sqlExcep) {
            printSQLException(sqlExcep);
        }
    }

    public void bookSlots(int gymId, String slotId, String email, String date) {
        String query = "INSERT INTO Booking (slotId,gymId,email,date) values(?, ?, ?, ?)";
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root", "JEDI20Flip");
                PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setString(1, slotId);
            statement.setInt(2, gymId);
            statement.setString(3, email);
            statement.setString(4, date);
            statement.executeUpdate();
            System.out.println("-----------------------------------------------");
        } catch (SQLException sqlExcep) {
            System.out.println(sqlExcep);
        }
    }

    public boolean isFull(String slotId, String date) {
        String query = "Select * slot where slotId=? and (numOfSeatsBooked>=numOfSeats)";
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root", "JEDI20Flip");
                PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setString(1, slotId);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
         return rs.next();
        }
     catch(SQLException e)

    {
        printSQLException(e);
    }

        return false;
}

    public boolean alreadyBooked(String slotId, String email, String date) {
        String query = "select isVerified from Booking where slotId=? and customerEmail =  ?";
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/GMS", "root", "JEDI20Flip");


             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, slotId);
            preparedStatement.setString(2, email);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            printSQLException(e);
        }

        return false;
    }

    public void cancelBooking(String slotId, String email, String date) {
        String query = "Delete from Booking where email = ? and slotId = ? and date = ?";
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMS", "root", "JEDI20Flip");
                PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setString(1, email);
            statement.setString(2, slotId);
            statement.setString(3, date);
            statement.executeUpdate();
            System.out.println("-----------------------------------------------");
        } catch (SQLException sqlExcep) {
            printSQLException(sqlExcep);
        }
    }

    public boolean checkSlotExists(String slotId, String gymId) {
        String query = "select isVerified from slot where slotId=? and gymId =  ?";
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/GMS", "root", "JEDI20Flip");


             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, slotId);
            preparedStatement.setString(2, gymId);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

          return rs.next();
        } catch (SQLException e) {
            printSQLException(e);
        }

        return false;
    }


    public boolean checkGymApprove(String gymId) {
        String query = "select isVerified from gym where gymId =  ?";
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/GMS", "root", "JEDI20Flip");


             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, gymId);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            return rs.next();
        } catch (SQLException e) {
            printSQLException(e);
        }

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