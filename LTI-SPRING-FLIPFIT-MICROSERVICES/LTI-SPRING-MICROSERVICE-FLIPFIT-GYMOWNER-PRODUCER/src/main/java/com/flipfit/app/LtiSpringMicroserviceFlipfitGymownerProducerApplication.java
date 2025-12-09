package com.flipfit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan("com.flipfit.*")
@EntityScan("com.flipfit.entity")
@EnableJpaRepositories("com.flipfit.repository")
@EnableFeignClients(basePackages = "com.flipfit.feignclient")
public class LtiSpringMicroserviceFlipfitGymownerProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LtiSpringMicroserviceFlipfitGymownerProducerApplication.class, args);
	}

}
