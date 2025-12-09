package com.flipfit.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="paymentmode")
public class PaymentMode implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pmodeid")
	private Long pModeId;
	@Column(name="modeofpayment")
	private String modeOfPayment;
	@Column(name="paymentDescription")
	private String paymentDesc;
	/**
	 * @return the pModeId
	 */
	public Long getpModeId() {
		return pModeId;
	}
	/**
	 * @param pModeId the pModeId to set
	 */
	public void setpModeId(Long pModeId) {
		this.pModeId = pModeId;
	}
	/**
	 * @return the modeOfPayment
	 */
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	/**
	 * @param modeOfPayment the modeOfPayment to set
	 */
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	/**
	 * @return the paymentDesc
	 */
	public String getPaymentDesc() {
		return paymentDesc;
	}
	/**
	 * @param paymentDesc the paymentDesc to set
	 */
	public void setPaymentDesc(String paymentDesc) {
		this.paymentDesc = paymentDesc;
	}
	public PaymentMode(Long pModeId, String modeOfPayment, String paymentDesc) {
		super();
		this.pModeId = pModeId;
		this.modeOfPayment = modeOfPayment;
		this.paymentDesc = paymentDesc;
	}
	public PaymentMode() {
		super();
	}
	
	

}
