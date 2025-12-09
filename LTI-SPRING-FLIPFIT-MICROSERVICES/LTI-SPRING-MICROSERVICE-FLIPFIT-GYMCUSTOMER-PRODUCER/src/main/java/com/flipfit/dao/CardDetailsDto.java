package com.flipfit.dao;

import java.time.LocalDate;

public class CardDetailsDto {

	private Long cardId;
	private String cardNumber;
	private LocalDate validityFrom;
	private LocalDate validityTo;
	private int cvv;
	private String nameOnCard;
	
	public CardDetailsDto() {
		super();
	}
	
	public CardDetailsDto(Long cardId, String cardNumber, LocalDate validityFrom, LocalDate validityTo, int cvv, String nameOnCard) {
		super();
		this.cardId = cardId;
		this.cardNumber = cardNumber;
		this.validityFrom = validityFrom;
		this.validityTo = validityTo;
		this.cvv = cvv;
		this.nameOnCard = nameOnCard;

	}

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
		return nameOnCard;
	}
	/**
	 * @param cardName the cardName to set
	 */
	public void setCardName(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	
	
	

}
