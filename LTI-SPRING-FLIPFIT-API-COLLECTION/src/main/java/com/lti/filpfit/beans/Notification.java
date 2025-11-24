package com.lti.filpfit.beans;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"Notification Details"
 */
public class Notification {

	private String notificationId;
    private String notificationStatus;
    private String message;
 
    public Notification() {
        // Public no-argument constructor
    }
 
    public String getNotificationId() {
        return notificationId;
    }
 
    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }
 
    public String getNotificationStatus() {
        return notificationStatus;
    }
 
    public void setNotificationStatus(String notificationStatus) {
        this.notificationStatus = notificationStatus;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
}