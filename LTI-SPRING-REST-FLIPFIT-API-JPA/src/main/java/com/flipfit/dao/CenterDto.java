package com.flipfit.dao;

import java.util.List;

import com.flipfit.entity.GymCenterAddress;
import com.flipfit.entity.GymSlot;

public class CenterDto {

	private String centerName;

	private String city;

	private Long gymOwnerId;

	private Boolean isApproved;

	private Double amountPerSlot;
	
	private GymCenterAddress centerLocation;
	
	private List<GymSlot> gymSlots;

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

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the gymOwnerId
	 */
	public Long getGymOwnerId() {
		return gymOwnerId;
	}

	/**
	 * @param gymOwnerId the gymOwnerId to set
	 */
	public void setGymOwnerId(Long gymOwnerId) {
		this.gymOwnerId = gymOwnerId;
	}

	/**
	 * @return the isApproved
	 */
	public Boolean getIsApproved() {
		return isApproved;
	}

	/**
	 * @param isApproved the isApproved to set
	 */
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	/**
	 * @return the amountPerSlot
	 */
	public Double getAmountPerSlot() {
		return amountPerSlot;
	}

	/**
	 * @param amountPerSlot the amountPerSlot to set
	 */
	public void setAmountPerSlot(Double amountPerSlot) {
		this.amountPerSlot = amountPerSlot;
	}

	/**
	 * @return the centerLocation
	 */
	public GymCenterAddress getCenterLocation() {
		return centerLocation;
	}

	/**
	 * @param centerLocation the centerLocation to set
	 */
	public void setCenterLocation(GymCenterAddress centerLocation) {
		this.centerLocation = centerLocation;
	}

	/**
	 * @return the gymSlots
	 */
	public List<GymSlot> getGymSlots() {
		return gymSlots;
	}

	/**
	 * @param gymSlots the gymSlots to set
	 */
	public void setGymSlots(List<GymSlot> gymSlots) {
		this.gymSlots = gymSlots;
	}
	
	

}
