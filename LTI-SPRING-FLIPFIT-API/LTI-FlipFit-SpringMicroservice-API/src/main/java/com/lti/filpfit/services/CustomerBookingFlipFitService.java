package com.lti.filpfit.services;

import com.lti.filpfit.beans.Booking;
import com.lti.filpfit.beans.GymCustomer;
import com.lti.filpfit.beans.User;

public interface CustomerBookingFlipFitService {
	public String loginUser(User user);

	public String registerUser(GymCustomer customer);

	public String bookSlot(String userId, String scheduleId);

	public String cancelBooking(String scheduleId);

	public Booking viewUserBooking(String userId);

	public Booking getBookingDetails(String bookingId);
}
