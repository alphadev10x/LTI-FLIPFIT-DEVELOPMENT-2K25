package com.lti.filpfit.beans;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"GymCustomer Details"
 */
public class GymCustomer {
	private String userId;
    private String customerId;
    private String phoneNumber;
    private String cardDetails;
    private String gender;
 
    public GymCustomer() {
        // Public no-argument constructor
    }
 
    public String getUserId() {
        return userId;
    }
 
    public void setUserId(String userId) {
        this.userId = userId;
    }
 
    public String getCustomerId() {
        return customerId;
    }
 
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
 
    public String getPhoneNumber() {
        return phoneNumber;
    }
 
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
 
    public String getCardDetails() {
        return cardDetails;
    }
 
    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }
 
    public String getGender() {
        return gender;
    }
 
    public void setGender(String gender) {
        this.gender = gender;
    }
 
    
}
