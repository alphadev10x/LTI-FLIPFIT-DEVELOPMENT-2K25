package com.flipfit.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"Booking Details"
 */
@Entity
@Table(name="gymbooking")
public class GymBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookingid")
	private Long bookingId;
	@Column(name="userid")
	private Long userId;
	@Column(name="slotid")
	private Long slotid;
	@Column(name="bookdate")
	private LocalDate bookDate;
	@Column(name="bookingstatus")
	private boolean bookingStatus;
	
	
	

	
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

	public GymBooking() {
		// Public no-argument constructor
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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @return the slotid
	 */
	public Long getSlotid() {
		return slotid;
	}

	/**
	 * @param slotid the slotid to set
	 */
	public void setSlotid(Long slotid) {
		this.slotid = slotid;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	

	
}