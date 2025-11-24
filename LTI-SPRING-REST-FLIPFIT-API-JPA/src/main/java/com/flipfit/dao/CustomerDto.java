package com.flipfit.dao;

import java.time.LocalDateTime;

public class CustomerDto {

	private Long userId;
	private String email;
	private String password;
	private Long roleId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String cardDetails;
	private String gender;
	
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
	 * @return the cardDetails
	 */
	public String getCardDetails() {
		return cardDetails;
	}
	/**
	 * @param cardDetails the cardDetails to set
	 */
	public void setCardDetails(String cardDetails) {
		this.cardDetails = cardDetails;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public CustomerDto() {
		super();
	}
	public CustomerDto(Long userId, String email, String password, Long roleId, String firstName, String lastName,
			String phoneNumber, String cardDetails, String gender) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.roleId = roleId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.cardDetails = cardDetails;
		this.gender = gender;
	}
	
	
	

}
