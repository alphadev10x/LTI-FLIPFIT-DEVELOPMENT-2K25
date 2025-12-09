/**
 * 
 */
package com.flipfit.dao;

/**
 * 
 */
public class SchedulerResponse {

	private String fullName;
	private Long bookingId;
	private String slotName;
	private String centerName;
	
	public SchedulerResponse(String fullName, Long bookingId, String slotName, String centerName) {
		this.fullName = fullName;
		this.bookingId = bookingId;
		this.slotName = slotName;
		this.centerName = centerName;
	}
	
	
	/**
	 * @return the fullName
	 */
	public String getFullname() {
		return fullName;
	}


	/**
	 * @param fullname the fullName to set
	 */
	public void setFullname(String fullName) {
		this.fullName = fullName;
	}


	/**
	 * @return the bookingId
	 */
	public Long getBookingId() {
		return bookingId;
	}


	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}


	/**
	 * @return the slotName
	 */
	public String getSlotName() {
		return slotName;
	}


	/**
	 * @param slotName the slotName to set
	 */
	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}


	/**
	 * @return the centerName
	 */
	public String getCenterName() {
		return centerName;
	}


	/**
	 * @param centerName the centerName to set
	 */
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

}
