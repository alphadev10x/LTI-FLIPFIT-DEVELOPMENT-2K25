package com.flipfit.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.flipfit.entity.GymNotification;


@FeignClient(name ="LTI-SPRING-MICROSERVICE-FLIPFIT-NOTIFICATION-PRODUCER")
public interface NotificationClient {
	
	 @PostMapping("/notification/sendNotification")
	 public String sendNotification(@RequestBody GymNotification gymNotification);

}
