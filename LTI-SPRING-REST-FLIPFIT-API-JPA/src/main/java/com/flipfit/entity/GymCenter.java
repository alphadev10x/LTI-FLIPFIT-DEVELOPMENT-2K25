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
	@Column(name="city")
    private String city;
	@Column(name="ownerid")
    private Long gymOwnerId;
	@Column(name="isApproved")
    private Boolean isApproved;
	@Column(name="amountperslot")
    private Double amountPerSlot;
 
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
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
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
	 * @return the amountPerSlot
	 */
	public Double getAmountPerSlot() {
		return amountPerSlot;
	}



	/**
	 * @param amountPerSlot the amountPerSlot to set
	 */
	public void setAmountPerSlot(Double amountPerSlot) {
		this.amountPerSlot = amountPerSlot;
	}



	public GymCenter(Long centerId, String centerName, String city, Long gymOwnerId, Boolean isApproved,
			Double amountPerSlot) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.city = city;
		this.gymOwnerId = gymOwnerId;
		this.isApproved = isApproved;
		this.amountPerSlot = amountPerSlot;
	}

 
    
 
  
}


