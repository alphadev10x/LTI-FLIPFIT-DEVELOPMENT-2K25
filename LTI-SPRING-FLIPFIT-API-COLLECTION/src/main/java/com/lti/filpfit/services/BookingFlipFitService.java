package com.lti.filpfit.services;

import com.lti.filpfit.beans.Payment;

public interface BookingFlipFitService {
	public void checkBookingOverlap(String customerId, String date, String time);
	
	public String makePayment(Payment payment);
}
