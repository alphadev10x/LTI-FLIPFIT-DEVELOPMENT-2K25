package com.flipfit.services;

import java.util.Optional;

import com.flipfit.dao.BookingDto;
import com.flipfit.dao.GymBookingReponse;
import com.flipfit.entity.GymBooking;




public interface BookingFlipFitService {
	
	public GymBookingReponse bookSlot(BookingDto bookingDto) ;

	public Optional<GymBooking> viewUserBooking(Long userId);

	public Optional<GymBooking> getBookingDetails(Long bookingId);
	
	public boolean isUserAvailable(Long userId);
	public boolean duplicateBookingCheck(GymBooking gymBooking);

	boolean isBookingAvailable(Long bookingId);
	
	public GymBooking cancelBooking(Long bookingId);
}
