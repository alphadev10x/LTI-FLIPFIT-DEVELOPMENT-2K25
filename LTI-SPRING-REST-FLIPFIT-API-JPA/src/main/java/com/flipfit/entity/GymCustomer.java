package com.flipfit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"GymCustomer Details"
 */
@Entity
@Table(name="gymcustomer")
public class GymCustomer {
	
	@Id
	@Column(name="userid")
	private Long userId;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="phonenumber")
    private String phoneNumber;
	@Column(name="cardname")
    private String cardDetails;
    private String gender;
    
    public GymCustomer(Long userId, String firstName, String lastName, String phoneNumber, String cardDetails,
			String gender) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.cardDetails = cardDetails;
		this.gender = gender;
	}
    
	
	/*
	 * @OneToOne(mappedBy = "gymCustomer") private GymUser user;
	 */
 
    public GymCustomer() {
        // Public no-argument constructor
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


	
	
	


	
}
