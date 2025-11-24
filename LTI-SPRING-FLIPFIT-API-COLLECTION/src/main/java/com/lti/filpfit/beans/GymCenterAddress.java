package com.lti.filpfit.beans;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"GymCenterAddress Details"
 */
public class GymCenterAddress {
	
	private String addressId;
    private String addressLine1;
    private String addressLine2;
    private String streetName;
    private String district;
    private String city;
    private String state;
    private String pincode;
 
    public GymCenterAddress() {
        // Public no-argument constructor required for a JavaBean
    }
 
    public String getAddressId() {
        return addressId;
    }
 
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
 
    public String getAddressLine1() {
        return addressLine1;
    }
 
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
 
    public String getAddressLine2() {
        return addressLine2;
    }
 
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
 
    public String getStreetName() {
        return streetName;
    }
 
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
 
    public String getDistrict() {
        return district;
    }
 
    public void setDistrict(String district) {
        this.district = district;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public String getState() {
        return state;
    }
 
    public void setState(String state) {
        this.state = state;
    }
 
    public String getPincode() {
        return pincode;
    }
 
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

}
