package com.flipfit.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
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
public class GymPayment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="paymentid")
	private Long paymentId;
	@Column(name="bookingid")
    private Long bookingId;
	@Column(name = "userid")
	private Long userId;
	@Column(name="pmodeid")
	private Long pmodeid;
	@Column(name="phonenumber")
    private String phoneNumber;
	@Column(name="amount")
    private Double amount;
	@Column(name="dateofpayment")
    private LocalDate dateofPayment =LocalDate.now();
	@Column(name="paymentstatus")
    private String paymentStatus;
	
	
    
    public GymPayment() {
        // Public no-argument constructor
    }
    

	

	/**
	 * @return the paymentId
	 */
	public Long getPaymentId() {
		return paymentId;
	}




	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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


	public GymPayment(Long paymentId, Long bookingId, Long userId, Long pmodeid, String phoneNumber, Double amount,
			LocalDate dateofPayment, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.userId = userId;
		this.pmodeid = pmodeid;
		this.phoneNumber = phoneNumber;
		this.amount = amount;
		this.dateofPayment = dateofPayment;
		this.paymentStatus = paymentStatus;
	}


	/**
	 * @return the dateofPayment
	 */
	public LocalDate getDateofPayment() {
		return dateofPayment;
	}


	/**
	 * @param dateofPayment the dateofPayment to set
	 */
	public void setDateofPayment(LocalDate dateofPayment) {
		this.dateofPayment = dateofPayment;
	}


	

	
 
    
}
