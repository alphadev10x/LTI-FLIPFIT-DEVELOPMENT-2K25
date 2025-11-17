package com.lti.filpfit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.filpfit.beans.GymCenter;
import com.lti.filpfit.beans.GymOwner;
import com.lti.filpfit.beans.User;

@RestController
@RequestMapping("/admin")
public class AdminFlipFitController {
	
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		return null;
	}
	@PostMapping("/validateGymOwner")
	public String validateOwner(@RequestBody GymOwner gymOwner){
		return null;
		
	}
	@PostMapping("/validateGymCenter")
	public String validateCenter(@RequestBody GymCenter gymCenter){
		return null;
	}
	@GetMapping("/viewPendingOwnerRequest/{ownerId}")
	public GymOwner viewPendingOwnerRequest(@PathVariable("ownerId") String ownerId){
		return null;
		
		
	}
	@GetMapping("/viewPendingCenterRequest/{centerId}")
	public GymCenter viewPendingCenterRequest(@PathVariable("centerId") String centerId){
		return null;
	}
	

}
