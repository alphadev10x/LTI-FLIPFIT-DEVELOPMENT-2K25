package com.flipfit.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
 * @Author : "Group Alpha"
 * @Version :"v.0.1"
 * @Description :"Notification Details"
 */
@Entity
@Table(name="gymnotification")
public class GymNotification implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="notificationid")
	private Long notificationId;
	@Column(name="status")
    private String notificationStatus;
    private String message;
 
    public GymNotification() {
        // Public no-argument constructor
    }
 
   
 
    /**
	 * @return the notificationId
	 */
	public Long getNotificationId() {
		return notificationId;
	}



	/**
	 * @param notificationId the notificationId to set
	 */
	public void setNotificationId(Long notificationId) {
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



	public GymNotification(Long notificationId, String notificationStatus, String message) {
		super();
		this.notificationId = notificationId;
		this.notificationStatus = notificationStatus;
		this.message = message;
	}
    
    
}