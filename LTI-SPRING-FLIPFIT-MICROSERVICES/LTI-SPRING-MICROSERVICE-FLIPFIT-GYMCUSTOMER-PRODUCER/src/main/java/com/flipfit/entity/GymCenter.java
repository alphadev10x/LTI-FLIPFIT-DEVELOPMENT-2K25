package com.flipfit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"GymCenter Details"
 */
@Entity
@Table(name="centers")
public class GymCenter {
	@Id
	private Long id;
	
	private Long ownerId;
	private String name;
	private String location;
	private boolean approved;
	/**
	 * 
	 */
	public GymCenter() {
	}

	/**
	 * @param id
	 * @param ownerId
	 * @param name
	 * @param location
	 * @param approved
	 */
	public GymCenter(Long id, Long ownerId, String name, String location, boolean approved) {
		this.id = id;
		this.ownerId = ownerId;
		this.name = name;
		this.location = location;
		this.approved = approved;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the ownerId
	 */
	public Long getOwnerId() {
		return ownerId;
	}
	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
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
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the approved
	 */
	public boolean isApproved() {
		return approved;
	}
	/**
	 * @param approved the approved to set
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	  
}