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
 * @Description :"GymCenterAddress Details"
 */
@Entity
@Table(name="gymcenterlocation")
public class GymCenterAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="addressid")
	private Long addressId;
	@Column(name="centerid")
	private Long centerId;
	@Column(name="address1")
    private String address1;
	@Column(name="address2")
    private String address2;
	@Column(name="city")
    private String city;
	@Column(name="state")
    private String state;
	@Column(name="pincode")
    private String pincode;
	@Column(name="country")
    private String country;
	/**
	 * @return the addressId
	 */
	public Long getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
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
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	public GymCenterAddress(Long addressId, Long centerId, String address1, String address2, String city, String state,
			String pincode, String country) {
		super();
		this.addressId = addressId;
		this.centerId = centerId;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
	}
	public GymCenterAddress() {
		super();
	}
	
	
	
}