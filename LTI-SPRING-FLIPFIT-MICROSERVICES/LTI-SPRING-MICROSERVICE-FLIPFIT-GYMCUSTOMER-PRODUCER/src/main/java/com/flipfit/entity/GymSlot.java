package com.flipfit.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"Slot Details"
 */
@Entity
@Table(name="slot")
public class GymSlot {
	
	@Id
    private Long id;
	
	private String name;
    private Long centerId;
    private LocalTime startTime; 
    private LocalTime endTime;
    private int capacity;
    private int booked;

    /**
	 * 
	 */
	public GymSlot() {
	}
	
	/**
	 * @param id
	 * @param name
	 * @param centerId
	 * @param startTime
	 * @param endTime
	 * @param capacity
	 * @param booked
	 */
	public GymSlot(Long id, String name, Long centerId, LocalTime startTime, LocalTime endTime, int capacity,
			int booked) {
		this.id = id;
		this.name = name;
		this.centerId = centerId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.capacity = capacity;
		this.booked = booked;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the centerId
	 */
	public Long getCenterId() {
		return centerId;
	}
	/**
	 * @param centerId the centerId to set
	 */
	public void setCenterId(Long centerId) {
		this.centerId = centerId;
	}
	/**
	 * @return the startTime
	 */
	public LocalTime getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public LocalTime getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the booked
	 */
	public int getBooked() {
		return booked;
	}

	/**
	 * @param price the price to set
	 */
	public void setBooked(int booked) {
		this.booked = booked;
	}
	
    
}