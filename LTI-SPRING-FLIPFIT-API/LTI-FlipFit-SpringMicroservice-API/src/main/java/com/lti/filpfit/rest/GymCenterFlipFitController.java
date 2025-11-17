package com.lti.filpfit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.filpfit.beans.GymCenter;

@RestController
public class GymCenterFlipFitController {
	
	@GetMapping("getCentersByCity/{city}")
	public GymCenter getCentersByCity(@PathVariable("city") String city){
		return null;
		
	}
	
	@PutMapping("requestCenterApproval/{centerId}")
	public String requestCenterApproval(@PathVariable("centerId") String centerId){
		return null;
	}

}
