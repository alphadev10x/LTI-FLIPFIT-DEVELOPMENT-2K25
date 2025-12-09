package com.flipfit.constants;

public class JPQLConstant {

	public static final String JPQL_UPDATE_SCHEDULER = "UPDATE GymScheduler SET schedulerdate=?2, slotid=?3, bookingid=?4where scheduleid=?1";
	
	public static final String JPQL_USER_ID = "SELECT gs.* FROM gymscheduler gs join user u on gs.userid = u.userid WHERE gb.userid = ?1";
	public static final String JPQL_FIRST_NAME = "SELECT gu.firstname FROM gymscheduler gs join gymbooking gb on gs.bookingid = gb.bookingid join gymcustomer gu on gu.userid=gb.userid WHERE gb.userid =  ?1";
	public static final String JPQL_LAST_NAME = "SELECT gu.lastname FROM gymscheduler gs join gymbooking gb on gs.bookingid = gb.bookingid join gymcustomer gu on gu.userid=gb.userid WHERE gb.userid = ?1";
	public static final String JPQL_SLOT_NAME = "SELECT s.slotname FROM gymscheduler gs join gymbooking gb on gb.bookingid=gs.bookingid join slot s on s.slotid=gb.slotid where gb.bookingid = ?1";
	public static final String JPQL_CENTER_NAME= "SELECT gc.centerName  FROM gymscheduler gs join gymbooking gb on gb.bookingid=gs.bookingid join slot s on s.slotid=gb.slotid join gymcenter gc on gc.centerid=s.centerid where gb.bookingid = ?1";
}
