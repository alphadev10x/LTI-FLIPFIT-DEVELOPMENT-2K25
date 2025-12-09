/**
 * 
 */
package com.flipfit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flipfit.entity.GymNotification;
import com.flipfit.repository.GymNotificationRepository;

import jakarta.ws.rs.core.MediaType;

/**
 * 
 */
@RestController
@RequestMapping("/notification")
public class NotificationFlipFitController {
	
	@Autowired
	private GymNotificationRepository gymNotificationRepository;
	
	 /*
     * @Method: sendNotification
     * @Description: Send Notification
     * @Parameters: GymCustomer
     * @Exception: RegistrationNotDoneException if registration fails
     */
	@RequestMapping(value = "/sendNotification", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
    public void sendNotification(@RequestBody GymNotification gymNotification) {
		GymNotification gymNotifications = new GymNotification();
		gymNotifications.setMessage(gymNotification.getMessage());
		gymNotifications.setNotificationStatus(gymNotification.getNotificationStatus());
		gymNotificationRepository.save(gymNotifications);
		
    }

}
