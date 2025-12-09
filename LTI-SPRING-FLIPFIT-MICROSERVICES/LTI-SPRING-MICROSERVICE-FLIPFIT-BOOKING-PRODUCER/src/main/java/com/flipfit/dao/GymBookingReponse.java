package com.flipfit.dao;

public class GymBookingReponse {
	
	private Long userId;
	private Long bookingId;
	private String bookingStatus;
	private String paymentStatus;
	private String notificationStatus;
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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
	 * @return the bookingStatus
	 */
	public String getBookingStatus() {
		return bookingStatus;
	}
	/**
	 * @param bookingStatus the bookingStatus to set
	 */
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}
	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	/**
	 * @return the notificationStatus
	 */
	public String getNotificationStatus() {
		return notificationStatus;
	}
	/**
	 * @param notificationStatus the notificationStatus to set
	 */
	public void setNotificationStatus(String notificationStatus) {
		this.notificationStatus = notificationStatus;
	}
	
	

}
