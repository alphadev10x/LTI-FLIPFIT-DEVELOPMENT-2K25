package com.lti.filpfit.beans;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"GymOwner Details"
 */
public class GymOwner {
	
	private String gymOwnerId;
    private String businessName;
    private String centerList;
    private String phoneNumber;
    private String GSTIN;
    private String PANCard;
 
    public GymOwner() {
        // Public no-argument constructor
    }
 
    public String getGymOwnerId() {
        return gymOwnerId;
    }
 
    public void setGymOwnerId(String gymOwnerId) {
        this.gymOwnerId = gymOwnerId;
    }
 
    public String getBusinessName() {
        return businessName;
    }
 
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
 
    public String getCenterList() {
        return centerList;
    }
 
    public void setCenterList(String centerList) {
        this.centerList = centerList;
    }
 
    public String getPhoneNumber() {
        return phoneNumber;
    }
 
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
 
    public String getGSTIN() {
        return GSTIN;
    }
 
    public void setGSTIN(String GSTIN) {
        this.GSTIN = GSTIN;
    }
 
    public String getPANCard() {
        return PANCard;
    }
 
    public void setPANCard(String PANCard) {
        this.PANCard = PANCard;
    }
 
    
}
