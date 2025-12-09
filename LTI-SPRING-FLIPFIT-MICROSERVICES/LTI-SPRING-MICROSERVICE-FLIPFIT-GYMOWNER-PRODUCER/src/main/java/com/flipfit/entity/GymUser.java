package com.flipfit.entity;



import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"User Details"
 */
@Entity
@Table(name="user")
public class GymUser implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private	Long userId;
	private	String email;
	private	String password;
	@Column(name="roleid")
	private Long roleId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column(name="creationdate")
	private LocalDateTime creationDate =LocalDateTime.now();
	
	
	
	public GymUser(Long userId, String email, String password, Long roleId, LocalDateTime creationDate) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.roleId = roleId;
		this.creationDate = creationDate;
	}

	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "gymOwner_id", referencedColumnName = "userId") private
	 * GymOwner gymOwner;
	 * 
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "gymRole_id", referencedColumnName = "roleId") private
	 * GymRole gymRole;
	 * 
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "gymCustomer_id", referencedColumnName = "userId") private
	 * GymCustomer gymCustomer;
	 */
	
	 public GymUser() {
		
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
 	 * @return the creationDate
 	 */
	 public LocalDateTime getCreationDate() {
		 return creationDate;
	 }

	 /**
 	 * @param creationDate the creationDate to set
 	 */
	 public void setCreationDate(LocalDateTime creationDate) {
		 this.creationDate = creationDate;
	 }
	 
	 

	
}
