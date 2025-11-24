package com.lti.filpfit.beans;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"GymCenter Details"
 */
public class GymCenter {
	
	private String centerId;
    private String centerName;
    private String city;
    private String ownerId;
    private Integer capacity;
    private Boolean isApproved;
    private Double amountPerSlot;
 
    public GymCenter() {
        // Public no-argument constructor
    }
 
    public String getCenterId() {
        return centerId;
    }
 
    public void setCenterId(String centerId) {
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
 
    public String getOwnerId() {
        return ownerId;
    }
 
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
 
    public Integer getCapacity() {
        return capacity;
    }
 
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
 
    public Boolean getIsApproved() {
        return isApproved;
    }
 
    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }
 
    public Double getAmountPerSlot() {
        return amountPerSlot;
    }
 
    public void setAmountPerSlot(Double amountPerSlot) {
        this.amountPerSlot = amountPerSlot;
    }
 
  
}


