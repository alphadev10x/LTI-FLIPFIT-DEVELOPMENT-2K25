package com.flipfit.entity;


import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"Scheduler Details"
 */
@Entity
@Table(name="gymscheduler")
public class GymScheduler {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="scheduleid")
	private Long scheduleId;
	@Column(name="bookingid")
    private Long bookingId;
	@Column(name="schedulerdate")
    private LocalDate schedulerDate;
   
 
    public GymScheduler() {
        // Public no-argument constructor
    }


	/**
	 * @return the scheduleId
	 */
	public Long getScheduleId() {
		return scheduleId;
	}


	/**
	 * @param scheduleId the scheduleId to set
	 */
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}


	




	/**
	 * @return the schedulerDate
	 */
	public LocalDate getSchedulerDate() {
		return schedulerDate;
	}


	/**
	 * @param schedulerDate the schedulerDate to set
	 */
	public void setSchedulerDate(LocalDate schedulerDate) {
		this.schedulerDate = schedulerDate;
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


	public GymScheduler(Long scheduleId, Long bookingId, LocalDate schedulerDate) {
		super();
		this.scheduleId = scheduleId;
		this.bookingId = bookingId;
		this.schedulerDate = schedulerDate;
	}


	

	
	
	
 
   
  

}
