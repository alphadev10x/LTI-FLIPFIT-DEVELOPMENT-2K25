/**
 * 
 */
package com.flipfit.config;

/**
 * 
 */
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

		System.out.println("n router");
		return builder.routes().route(r -> r.path("/admin/**").uri("http://localhost:8081/"))
				.route(r -> r.path("/booking/**").uri("http://localhost:8088/"))
				.route(r -> r.path("/gymcenter/**").uri("http://localhost:8083/"))
				.route(r -> r.path("/customer/**").uri("http://localhost:8084"))
				.route(r -> r.path("/owner/**").uri("http://localhost:8085/"))
				.route(r -> r.path("/user/**").uri("http://localhost:8086/"))
				.route(r -> r.path("/notification/**").uri("http://localhost:8089"))
				.route(r -> r.path("/scheduler/**").uri("http://localhost:8087")
				).build();

	}

}
