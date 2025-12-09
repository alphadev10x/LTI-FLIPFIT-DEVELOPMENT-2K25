/**
 * 
 */
package com.flipfit.dao;


/**
 * 
 */
public class BookingRequest {

	private Long customerId;
	private Long centerId;
	private Long slotId;
	/**
	 * 
	 */
	public BookingRequest() {
	}
	/**
	 * @param customerId
	 * @param centerId
	 * @param slotId
	 */
	public BookingRequest(Long customerId, Long centerId, Long slotId) {
		this.customerId = customerId;
		this.centerId = centerId;
		this.slotId = slotId;
	}
	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
	
	
}
