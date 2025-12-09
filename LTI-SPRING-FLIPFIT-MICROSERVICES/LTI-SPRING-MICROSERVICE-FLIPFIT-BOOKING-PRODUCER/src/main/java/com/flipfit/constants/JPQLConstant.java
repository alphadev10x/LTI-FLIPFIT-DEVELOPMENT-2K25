package com.flipfit.constants;

public class JPQLConstant {
	
	public static final String JPQL_COUNTUSERBOOKING = "SELECT COUNT(b) FROM GymBooking b WHERE b.slotid = :slotId AND b.userId = :userId";
	public static final String JPQL_CHECKUSERAVAILABILITY = "SELECT COUNT(b) FROM GymBooking b WHERE b.userId = :userId";
	public static final String JPQL_CHECKBOOKINGAVAILABILITY = "SELECT COUNT(b) FROM GymBooking b WHERE b.bookingId = :bookingId";
	public static final String JPQL_FINDSLOTBYBOOKINGID = "SELECT b.slotid FROM GymBooking b WHERE b.bookingId = :bookingId";
	public static final String JPQL_UPDATEBOOKINGSTATUS = "UPDATE GymBooking b SET b.bookingStatus = false WHERE b.bookingId = :bookingId";
}
