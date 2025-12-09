package com.flipfit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"GymOwner Details"
 */
@Entity
@Table(name="owners")
public class GymOwner {
	
	@Id
	private Long id;
	
	private String name;
	private String email;
	private String phone;
	private String password;
	private boolean approved;
	private String status;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "userid")
    private GymUser user;
	/**
	 * 
	 */
	public GymOwner() {
	}
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param phone
	 * @param password
	 * @param approved
	 * @param status
	 */
	public GymOwner(Long id, GymUser user, String phone, boolean approved, String status) {
		this.id = id;
		this.user = user;
		this.phone = phone;
		this.approved = approved;
		this.status = status;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	public GymUser getUser() {
		return user;
	}
	public void setUser(GymUser user) {
		this.user = user;
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
	 * @return the approved
	 */
	public boolean isApproved() {
		return approved;
	}
	/**
	 * @param approved the approved to set
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		
		this.status = status;
		
	}
	
	
}
