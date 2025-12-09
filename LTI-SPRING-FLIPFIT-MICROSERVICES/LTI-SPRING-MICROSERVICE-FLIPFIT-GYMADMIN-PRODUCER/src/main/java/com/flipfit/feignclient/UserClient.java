/**
 * 
 */
package com.flipfit.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.flipfit.entity.GymUser;

/**
 * 
 */
@FeignClient(name ="LTI-SPRING-MICROSERVICE-FLIPFIT-GYMUSER-PRODUCER")
public interface UserClient {
	
	@PostMapping(value = "user/addUserDetails")
	public GymUser addUserdetails(@RequestBody GymUser user) ;

}
