package com.flipkart.constants;

public class SQLConstants {

    public static final String SQL_SELECT_USER_LOGIN_CREDENTIAL = "select email, password, role from user where email = ?";
    public static final String SQL_SELECT_GYM_OWNER_DETAILS = "select email, name, phoneNum, aadharNum, panNum from gymOwner where email = ?";
    public static final String SQL_INSERT_USER = "INSERT INTO user (email, password, role) VALUES (?, ?, ?);";
	public static final String SQL_UPDATE_USER = "update user set email = ?, password = ?, role = ?" + " where email = ?;";
    
	public static final String SQL_INSERT_GYM_OWNER = "INSERT INTO gymOwner (email, password, name, phoneNum, aadharNum, panNum, isVerified) VALUES (?, ?, ?, ?, ?, ?, ?);";
	public static final String SQL_UPDATE_GYM_OWNER = "UPDATE gymOwner set email = ?, name = ?, phoneNum = ?, aadharNum = ?, panNum = ?, isVerified = ?"; 

	public static final String SQL_READ_GYM = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym where gymId = ?";
	public static final String SQL_INSERT_GYM = "INSERT INTO gym"
	+ "  (gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified) VALUES "
	+ " (?, ?, ?, ?, ?, ?, ?);";
	public static final String SQL_UPDATE_GYM ="update gym"
	+ "  set gymId = ?, gymName = ?, ownerEmail = ?, address = ?, slotCount = ?, seatsPerSlotCount = ?, isVerified = ? where gymId = ?;";
	
	public static final String SQL_READ_SLOT_FROM_GYMID = "select slotId, gymId, startTime, endTime, trainer, numOfSeats, numOfSeatsBooked from slot where gymId =  ?";
	public static final String SQL_INSERT_SLOT = "INSERT INTO slot" + "  (slotId, gymId, startTime, endTime, trainer, numOfSeats, numOfSeatsBooked) VALUES "
					+ " (?, ?, ?, ?, ?, ?, ?);";
}


