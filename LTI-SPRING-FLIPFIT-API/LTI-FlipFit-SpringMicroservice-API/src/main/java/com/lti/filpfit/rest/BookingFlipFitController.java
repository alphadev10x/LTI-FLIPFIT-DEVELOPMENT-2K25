package com.lti.filpfit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.filpfit.beans.Payment;

@RestController
public class BookingFlipFitController {
	
	private static final String TIME2 = "time";
	private static final String DATE2 = "date";
	private static final String CUSTOMER_ID = "customerId";
	
	@GetMapping("/CheckBookingOverlap/{customerId}/{date}/{time}")
	public void checkBookingOverlap(@PathVariable(CUSTOMER_ID)String customerId 
			,@PathVariable(DATE2) String date,@PathVariable(TIME2) String time){
		
	}
	@PostMapping("/makePayment")
	public String makePayment(@RequestBody Payment payment){
		return null;
		
		
	}

}
