package com.flipfit.entity;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="slotid")
    private Long slotId;
	@Column(name="centerid")
    private Long centerId;
	@Column(name="starttime")
	@JsonFormat(pattern = "HH:mm:ss")
    private String startTime; 
	@Column(name="endtime")
	@JsonFormat(pattern = "HH:mm:ss")
    private String endTime;
	@Column(name="slotname")
    private String slotName;
	@Column(name="capacity")
    private Integer capacity;
	
	public GymSlot() {
	
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
	public String getStartTime() {
		return startTime;
	}



	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}



	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}



	



	/**
	 * @return the capacity
	 */
	public Integer getCapacity() {
		return capacity;
	}



	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}



	public GymSlot(Long slotId, Long centerId, String startTime, String endTime, String slotName, Integer capacity) {
		super();
		this.slotId = slotId;
		this.centerId = centerId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.slotName = slotName;
		this.capacity = capacity;
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



	


	



	
	
	
	
	
	
	
 

}
