package com.flipfit.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"Payment Details"
 */
@Entity
@Table(name="gympayment")
public class GymPayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="paymentid")
	private Long paymentId;
	@Column(name="bookingid")
    private Long bookingId;
	@Column(name="pmodeid")
	private Long pmodeid;
	@Column(name="phonenumber")
    private String phoneNumber;
	@Column(name="amount")
    private Double amount;
	@Column(name="dateofpayment")
    private LocalDateTime dateofPayment =LocalDateTime.now();
	@Column(name="paymentstatus")
    private String paymentStatus;
	
	
    
    public GymPayment() {
        // Public no-argument constructor
    }

	/**
	 * @return the paymentId
	 */
	

	

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
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	/**
	 * @return the dateofPayment
	 */
	public LocalDateTime getDateofPayment() {
		return dateofPayment;
	}

	/**
	 * @param dateofPayment the dateofPayment to set
	 */
	public void setDateofPayment(LocalDateTime dateofPayment) {
		this.dateofPayment = dateofPayment;
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
	 * @return the pmodeid
	 */
	public Long getPmodeid() {
		return pmodeid;
	}

	/**
	 * @param pmodeid the pmodeid to set
	 */
	public void setPmodeid(Long pmodeid) {
		this.pmodeid = pmodeid;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public GymPayment(Long paymentId, Long bookingId, Long pmodeid, String phoneNumber, Double amount,
			LocalDateTime dateofPayment, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.pmodeid = pmodeid;
		this.phoneNumber = phoneNumber;
		this.amount = amount;
		this.dateofPayment = dateofPayment;
		this.paymentStatus = paymentStatus;
	}

	
 
    
}
