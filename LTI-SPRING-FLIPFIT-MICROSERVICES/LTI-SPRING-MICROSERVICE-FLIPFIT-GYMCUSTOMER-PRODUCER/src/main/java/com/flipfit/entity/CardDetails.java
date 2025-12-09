package com.flipfit.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"CardDetails Details"
 */
@Entity
@Table(name="carddetails")
public class CardDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cardid")
	private Long cardId;
	@Column(name="userid")
	private Long userId;
	@NotEmpty(message = "Card Number cannot be empty")
	@Column(name="cardnumber")
	private String cardNumber;
	@Column(name="validityfrom")
	@JsonFormat(pattern="MM/YY")
	private LocalDate validityFrom;
	@Column(name="validityto")
	@JsonFormat(pattern="MM/YY")
	private LocalDate validityTo ;
	@NotEmpty(message = "CVV cannot be empty")
	@Column(name="cvv")
	private int cvv;
	@NotEmpty(message = "Card Name cannot be empty")
	@Column(name="cardname")
	private String cardName;

	/**
	 * @return the cardId
	 */
	public Long getCardId() {
		return cardId;
	}
	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}
	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * @return the validityFrom
	 */
	public LocalDate getValidityFrom() {
		return validityFrom;
	}
	/**
	 * @param validityFrom the validityFrom to set
	 */
	public void setValidityFrom(LocalDate validityFrom) {
		this.validityFrom = validityFrom;
	}
	/**
	 * @return the validityTo
	 */
	public LocalDate getValidityTo() {
		return validityTo;
	}
	/**
	 * @param validityTo the validityTo to set
	 */
	public void setValidityTo(LocalDate validityTo) {
		this.validityTo = validityTo;
	}
	/**
	 * @return the cvv
	 */
	public int getCvv() {
		return cvv;
	}
	/**
	 * @param cvv the cvv to set
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	/**
	 * @return the cardName
	 */
	public String getCardName() {
		return cardName;
	}
	/**
	 * @param cardName the cardName to set
	 */
	public void setCardName(String cardName) {
		this.cardName = cardName;
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
	public CardDetails() {
	
	}
	public CardDetails(Long cardId, Long userId, String cardNumber, LocalDate validityFrom, LocalDate validityTo,
			int cvv, String cardName) {
		super();
		this.cardId = cardId;
		this.userId = userId;
		this.cardNumber = cardNumber;
		this.validityFrom = validityFrom;
		this.validityTo = validityTo;
		this.cvv = cvv;
		this.cardName = cardName;
	}
	
	
	
	

}