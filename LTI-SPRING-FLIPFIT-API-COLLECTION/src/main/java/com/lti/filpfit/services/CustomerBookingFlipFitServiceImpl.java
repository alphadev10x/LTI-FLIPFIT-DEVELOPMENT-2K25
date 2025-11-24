/**
 * 
 */
package com.lti.filpfit.services;

import org.springframework.stereotype.Service;

import com.lti.filpfit.beans.Booking;
import com.lti.filpfit.beans.GymCustomer;
import com.lti.filpfit.beans.User;

/**
 * 
 */
@Service
public class CustomerBookingFlipFitServiceImpl implements CustomerBookingFlipFitService{

	@Override
	public String bookSlot(String userId, String scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancelBooking(String scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking viewUserBooking(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking getBookingDetails(String bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loginUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerUser(GymCustomer customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
