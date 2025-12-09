package com.flipfit.services;

import java.util.List;
import java.util.Optional;

import com.flipfit.dao.BookingDto;
import com.flipfit.dao.BookingView;
import com.flipfit.dao.GymBookingReponse;
import com.flipfit.entity.GymBooking;
import com.flipfit.entity.GymPayment;




public interface BookingFlipFitService {
	
	public GymBookingReponse bookSlot(BookingDto bookingDto) ;

	public List<BookingView> viewUserBooking(Long userId);

	public Optional<GymBooking> getBookingDetails(Long bookingId);
	
	public boolean isUserAvailable(Long userId);
	public boolean duplicateBookingCheck(GymBooking gymBooking);

	boolean isBookingAvailable(Long bookingId);
	
	public GymBooking cancelBooking(Long bookingId);
	
	public List<GymPayment> getTransactionDetails(Long ownerId);
	
	//public void makePayment(GymBooking gymBookings, BookingDto bookingDto);
}
