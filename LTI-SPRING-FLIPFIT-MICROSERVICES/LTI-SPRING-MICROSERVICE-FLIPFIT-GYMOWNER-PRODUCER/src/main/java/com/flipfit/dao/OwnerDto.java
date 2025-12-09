package com.flipfit.dao;

import jakarta.validation.constraints.NotEmpty;

public class OwnerDto {

	@NotEmpty(message = "Email cannot be empty")
	private String email;
	@NotEmpty(message = "Password cannot be empty")
	private String password;
	private Long roleId;
	@NotEmpty(message = "Business Name cannot be empty")
	private String businessName;
	private String cardNumber;
	@NotEmpty(message = "GSTIN cannot be empty")
	private String gstin;
	private String pancard;
	private boolean isApproved =false;
	@NotEmpty(message = "First Name cannot be empty")
	private String firstName;
	@NotEmpty(message = "Last Name cannot be empty")
	private String lastName;
	/**
	 * 
	 */
	public OwnerDto() {
	}
	/**
	 * @param email
	 * @param password
	 * @param roleId
	 * @param businessName
	 * @param cardNumber
	 * @param gstin
	 * @param pancard
	 * @param isApproved
	 * @param firstName
	 * @param lastName
	 */
	public OwnerDto(@NotEmpty(message = "Email cannot be empty") String email,
			@NotEmpty(message = "Password cannot be empty") String password, Long roleId,
			@NotEmpty(message = "Business Name cannot be empty") String businessName, String cardNumber,
			@NotEmpty(message = "GSTIN cannot be empty") String gstin, String pancard, boolean isApproved,
			@NotEmpty(message = "First Name cannot be empty") String firstName,
			@NotEmpty(message = "Last Name cannot be empty") String lastName) {
		this.email = email;
		this.password = password;
		this.roleId = roleId;
		this.businessName = businessName;
		this.cardNumber = cardNumber;
		this.gstin = gstin;
		this.pancard = pancard;
		this.isApproved = isApproved;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the businessName
	 */
	public String getBusinessName() {
		return businessName;
	}
	/**
	 * @param businessName the businessName to set
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
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
	 * @return the gstin
	 */
	public String getGstin() {
		return gstin;
	}
	/**
	 * @param gstin the gstin to set
	 */
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	/**
	 * @return the pancard
	 */
	public String getPancard() {
		return pancard;
	}
	/**
	 * @param pancard the pancard to set
	 */
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	/**
	 * @return the isApproved
	 */
	public boolean isApproved() {
		return isApproved;
	}
	/**
	 * @param isApproved the isApproved to set
	 */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
