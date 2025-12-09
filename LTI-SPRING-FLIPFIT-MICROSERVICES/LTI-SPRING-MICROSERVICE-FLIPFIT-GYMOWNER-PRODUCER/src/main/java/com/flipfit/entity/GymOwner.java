package com.flipfit.entity;



import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"GymOwner Details"
 */
@Entity
@Table(name="gymowner")
public class GymOwner implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="userid")
	private Long userId;
	@Column(name="businessname")
    private String businessName;
	@Column(name="cardnumber")
    private String cardNumber;
	@Column(name="gst")
    private String GSTIN;
	@Column(name="pancard")
    private String PANCard;
	@Column(name="isapproved")
    private boolean isApproved;
	@Column(name="firstname")
    private String firstName;
	@Column(name="lastname")
	private String lastName;
	
	
	
	public GymOwner(Long userId, String businessName, String cardNumber, String gSTIN, String pANCard,
			boolean isApproved, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.businessName = businessName;
		this.cardNumber = cardNumber;
		GSTIN = gSTIN;
		PANCard = pANCard;
		this.isApproved = isApproved;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	
	/*
	 * @OneToOne(mappedBy = "gymOwner") private GymUser user;
	 */
	 
 
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



	public GymOwner() {
        // Public no-argument constructor
    }
 
    
 
    public String getBusinessName() {
        return businessName;
    }
 
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
	 * @return the gSTIN
	 */
	public String getGSTIN() {
		return GSTIN;
	}



	/**
	 * @param gSTIN the gSTIN to set
	 */
	public void setGSTIN(String gSTIN) {
		GSTIN = gSTIN;
	}



	/**
	 * @return the pANCard
	 */
	public String getPANCard() {
		return PANCard;
	}



	/**
	 * @param pANCard the pANCard to set
	 */
	public void setPANCard(String pANCard) {
		PANCard = pANCard;
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
