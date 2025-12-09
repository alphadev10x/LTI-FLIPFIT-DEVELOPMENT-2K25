package com.flipfit.entity;

import java.io.Serializable;

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
 * @Description :"Role Details"
 */
@Entity
@Table(name="gymrole")
public class GymRole  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="roleid")
	private Long roleId;
	@NotEmpty(message = "Role Name cannot be empty")
	@Column(name="rolename")
	@NotEmpty(message = "Role Description cannot be empty")
	private String roleName;
	@Column(name="roledescription")
	private String roleDesc;

	public GymRole() {

	}
	
	

	public GymRole(Long roleId, String roleName, String roleDesc) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

	/*
	 * @OneToOne(mappedBy = "gymRole") private GymUser user;
	 */
	

	


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
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleDesc
	 */
	public String getRoleDesc() {
		return roleDesc;
	}

	/**
	 * @param roleDesc the roleDesc to set
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}
