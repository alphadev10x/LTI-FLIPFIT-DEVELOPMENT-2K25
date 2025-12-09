package com.flipfit.services;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.flipfit.entity.GymNotification;
import com.flipfit.repository.GymNotificationRepository;

@Service
public class NotificationFlipFitServiceImpl {
	private static final Logger logger = LoggerFactory.getLogger(NotificationFlipFitServiceImpl.class);

	
	@Autowired
	private GymNotificationRepository gymNotificationRepository;
	
	@KafkaListener(topics = "TestTopic", groupId = "test-group")
	public void sendNotification(String message) {
		logger.info("Received message: " + message);
		GymNotification gymNotification = new GymNotification();
		gymNotification.setMessage(message);
		gymNotification.setNotificationStatus("Successfully Approved");
		gymNotificationRepository.save(gymNotification);
		
	}
	
	
	
	

}
