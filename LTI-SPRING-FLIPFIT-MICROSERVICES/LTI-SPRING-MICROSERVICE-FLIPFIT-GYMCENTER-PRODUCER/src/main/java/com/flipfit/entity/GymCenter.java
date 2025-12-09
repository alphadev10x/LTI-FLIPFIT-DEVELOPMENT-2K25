package com.flipfit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"GymCenter Details"
 */
@Entity
@Table(name="gymcenter")
public class GymCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="centerid")
	private Long centerId;
	@Column(name="centername")
    private String centerName;
	@Column(name="ownerid")
    private Long gymOwnerId;
	@Column(name="isApproved")
    private Boolean isApproved;
	@Column(name="description")
	private String description;
	@Column(name="contactperson")
	private String contactPerson;
	@Column(name="phone")
	private String phone;
	@Column(name="email")
	private String email;
 
    public GymCenter() {
        // Public no-argument constructor
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



	public String getCenterName() {
        return centerName;
    }
 
    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }



	/**
	 * @return the gymOwnerId
	 */
	public Long getGymOwnerId() {
		return gymOwnerId;
	}



	/**
	 * @param gymOwnerId the gymOwnerId to set
	 */
	public void setGymOwnerId(Long gymOwnerId) {
		this.gymOwnerId = gymOwnerId;
	}



	/**
	 * @return the isApproved
	 */
	public Boolean getIsApproved() {
		return isApproved;
	}



	/**
	 * @param isApproved the isApproved to set
	 */
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}



	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}



	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



	/**
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		return contactPerson;
	}



	/**
	 * @param contactPerson the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}



	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}



	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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



	public GymCenter(Long centerId, String centerName, Long gymOwnerId, Boolean isApproved, String description,
			String contactPerson, String phone, String email) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.gymOwnerId = gymOwnerId;
		this.isApproved = isApproved;
		this.description = description;
		this.contactPerson = contactPerson;
		this.phone = phone;
		this.email = email;
	}
 
   
 
  
}


