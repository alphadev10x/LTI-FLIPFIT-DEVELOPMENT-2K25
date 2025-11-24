package com.lti.filpfit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.filpfit.beans.Booking;
import com.lti.filpfit.beans.GymCustomer;
import com.lti.filpfit.beans.User;

@RestController
@RequestMapping("customer")
public class CustomerFlipFitController {
	
	private static final String BOOKING_ID = "bookingId";
	private static final String SCHEDULE_ID = "scheduleId";
	private static final String USER_ID = "userId";
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		return null;
	}
	@PostMapping("/register")
	public String register(@RequestBody GymCustomer customer) {
		return null;
		
	}
	@PostMapping("/bookSlot/{userId}/{scheduleId}")
	public String bookSlot(@PathVariable(USER_ID) String userId ,@PathVariable(SCHEDULE_ID) String scheduleId) {
		return null;
	}
	@PutMapping("cancel/{scheduleId}")
	public String cancelBooking(@PathVariable(SCHEDULE_ID) String scheduleId) {
		return scheduleId;
		
	}
	@GetMapping("Bookings/{userId}")
	public Booking viewUserBooking(@PathVariable(USER_ID) String userId){
		return null;
		
	}
	@GetMapping("BookingDetails/{bookingId}")
	public Booking getBookingDetails(@PathVariable(BOOKING_ID) String bookingId){
		return null;
		
		
	}

}
