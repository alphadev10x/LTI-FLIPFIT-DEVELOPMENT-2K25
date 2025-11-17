package com.lti.filpfit.beans;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"Booking Details"
 */
public class Booking {

	private String bookingId;
	private String userId;
	private String scheduleId;

	public Booking() {
		// Public no-argument constructor
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
}