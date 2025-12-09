package com.flipfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan("com.flipfit.*")
@EnableCaching
public class LtiSpringMicroserviceFlipfitGymcenterProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LtiSpringMicroserviceFlipfitGymcenterProducerApplication.class, args);
	}

}
