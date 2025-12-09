package com.flipfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan("com.flipfit.*")
public class LtiSpringMicroserviceFlipfitNotificationProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LtiSpringMicroserviceFlipfitNotificationProducerApplication.class, args);
	}

}
