package com.lti.filpfit.beans;
/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"User Details"
 */
public class User {
	private	String userId;
	private	String email;
	private	String password;
	private String roleId;
	 public User() {
		super();
	}
	 public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	

}
