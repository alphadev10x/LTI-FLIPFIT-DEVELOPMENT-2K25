package com.flipfit.dao;

public class GymCenterReponse {
	
	private Long centerId;
	private String locationStatus;
	private String slotStatus;
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
	 * @return the locationStatus
	 */
	public String getLocationStatus() {
		return locationStatus;
	}
	/**
	 * @param locationStatus the locationStatus to set
	 */
	public void setLocationStatus(String locationStatus) {
		this.locationStatus = locationStatus;
	}
	/**
	 * @return the slotStatus
	 */
	public String getSlotStatus() {
		return slotStatus;
	}
	/**
	 * @param slotStatus the slotStatus to set
	 */
	public void setSlotStatus(String slotStatus) {
		this.slotStatus = slotStatus;
	}
	
	

}
