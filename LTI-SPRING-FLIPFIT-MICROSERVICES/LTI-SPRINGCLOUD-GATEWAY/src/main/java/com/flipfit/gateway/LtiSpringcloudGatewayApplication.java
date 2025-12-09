package com.flipfit.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.flipfit.config.SpringCloudConfig;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@Import({SpringCloudConfig.class})
@EnableDiscoveryClient
public class LtiSpringcloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(LtiSpringcloudGatewayApplication.class, args);
	}

}
