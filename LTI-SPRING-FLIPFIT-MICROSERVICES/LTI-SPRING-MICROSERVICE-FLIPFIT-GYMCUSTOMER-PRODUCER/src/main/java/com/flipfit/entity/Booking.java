package com.flipfit.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long customerId;
	
	private Long slotId;
	private Long centerId;
	private Long paymentId;
	private String status;
	private LocalDateTime createAt = LocalDateTime.now();
	/**
	 * 
	 */
	public Booking() {
	}
	/**
	 * @param id
	 * @param customerId
	 * @param slotId
	 * @param centerId
	 * @param paymentId
	 * @param status
	 * @param createAt
	 */
	public Booking(Long id, Long customerId, Long slotId, Long centerId, Long paymentId, String status) {
		this.id = id;
		this.customerId = customerId;
		this.slotId = slotId;
		this.centerId = centerId;
		this.paymentId = paymentId;
		this.status = status;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
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
	 * @return the paymentId
	 */
	public Long getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the createAt
	 */
	public LocalDateTime getCreateAt() {
		return createAt;
	}
	/**
	 * @param createAt the createAt to set
	 */
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	
}
