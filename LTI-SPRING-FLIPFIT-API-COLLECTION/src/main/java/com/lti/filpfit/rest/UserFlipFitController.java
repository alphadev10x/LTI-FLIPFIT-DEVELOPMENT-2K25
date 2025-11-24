package com.lti.filpfit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.filpfit.beans.User;

@RestController
public class UserFlipFitController {
	@PostMapping("addUserDetails")
	public String addUserdetails(@RequestBody User user){
		return null;
		
	}
	@GetMapping("verifyUserDetails")
	public String verifyUserdetails(@RequestBody User user) {
		return null;
		
	}

}
