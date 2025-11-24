package com.flipfit.dao;

import java.time.LocalDate;

import com.flipfit.entity.GymPayment;



public class BookingDto {
	
	private Long userId;
	
	private Long slotId;
	
	private LocalDate bookDate;
	
	private boolean bookingStatus;
	
	private GymPayment payment;

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
	 * @return the slotId
	 */
	public Long getSlotId() {
		return slotId;
	}

	/**
	 * @param slotId the slotId to set
	 */
	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	/**
	 * @return the bookDate
	 */
	public LocalDate getBookDate() {
		return bookDate;
	}

	/**
	 * @param bookDate the bookDate to set
	 */
	public void setBookDate(LocalDate bookDate) {
		this.bookDate = bookDate;
	}

	/**
	 * @return the bookingStatus
	 */
	public boolean isBookingStatus() {
		return bookingStatus;
	}

	/**
	 * @param bookingStatus the bookingStatus to set
	 */
	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	/**
	 * @return the payment
	 */
	public GymPayment getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(GymPayment payment) {
		this.payment = payment;
	}
	
	

}
