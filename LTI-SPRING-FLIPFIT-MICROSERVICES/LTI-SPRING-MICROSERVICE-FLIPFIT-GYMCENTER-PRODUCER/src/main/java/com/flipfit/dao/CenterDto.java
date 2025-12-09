package com.flipfit.dao;

import com.flipfit.entity.GymCenterAddress;

public class CenterDto {

	private String centerName;

	private Long gymOwnerId;

	private Boolean isApproved;
	
    private String description;
	
	private String contactPerson;
	
	private String phone;
	private String email;
	
	private GymCenterAddress centerLocation;
	
	//private List<GymSlot> gymSlots;

	/**
	 * @return the centerName
	 */
	public String getCenterName() {
		return centerName;
	}

	/**
	 * @param centerName the centerName to set
	 */
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

	/**
	 * @return the centerLocation
	 */
	public GymCenterAddress getCenterLocation() {
		return centerLocation;
	}

	/**
	 * @param centerLocation the centerLocation to set
	 */
	public void setCenterLocation(GymCenterAddress centerLocation) {
		this.centerLocation = centerLocation;
	}
	
	

	public CenterDto(String centerName, Long gymOwnerId, Boolean isApproved, String description, String contactPerson,
			String phone, String email, GymCenterAddress centerLocation) {
		super();
		this.centerName = centerName;
		this.gymOwnerId = gymOwnerId;
		this.isApproved = isApproved;
		this.description = description;
		this.contactPerson = contactPerson;
		this.phone = phone;
		this.email = email;
		this.centerLocation = centerLocation;
	}

	public CenterDto() {
		
	}
	
	
	
	

}
