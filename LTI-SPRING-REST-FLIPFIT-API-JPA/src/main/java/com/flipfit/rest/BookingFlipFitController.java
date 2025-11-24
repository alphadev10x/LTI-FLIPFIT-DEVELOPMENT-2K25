package com.flipfit.rest;



import java.time.LocalDate;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.flipfit.dao.BookingDto;
import com.flipfit.dao.GymBookingReponse;
import com.flipfit.entity.GymBooking;
import com.flipfit.entity.GymNotification;
import com.flipfit.entity.GymPayment;
import com.flipfit.exception.BookingNotFoundException;
import com.flipfit.exception.SlotsNotAvailableException;
import com.flipfit.repository.GymNotificationRepository;
import com.flipfit.repository.GymPaymentRepository;
import com.flipfit.services.BookingFlipFitServiceImpl;
import jakarta.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.*;



@RestController
public class BookingFlipFitController {
	
	
	@Autowired
	BookingFlipFitServiceImpl bookingFlipFitServiceImpl;
	
	@Autowired
	GymNotificationRepository gymNotificationRepository;
	
	
	
	private final static Logger logger = LoggerFactory.getLogger(BookingFlipFitServiceImpl.class);
	

	private static final String BOOKING_ID = "bookingId";
	private static final String SCHEDULE_ID = "scheduleId";
	private static final String USER_ID = "userId";

	
	@RequestMapping(value = "/bookSlot", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<GymBookingReponse> bookSlot(@RequestBody BookingDto bookingDto) {
		
		logger.info("Booking Slot for user"+bookingDto.getUserId());
		GymBookingReponse gymBookings =bookingFlipFitServiceImpl.bookSlot(bookingDto);
		
		return new ResponseEntity<>(gymBookings, HttpStatus.CREATED);
	}

	/*
	 * @Method: viewUserBooking
	 * 
	 * @Description: View user Bookings
	 * 
	 * @MethodParameters: userId
	 * 
	 * @Exception
	 */
	@RequestMapping(value = "bookingsByUserId/{userId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<GymBooking> viewUserBooking(@PathVariable(USER_ID) Long userId) {
		boolean isUserAvailable = bookingFlipFitServiceImpl.isUserAvailable(userId);
		if (isUserAvailable) {
			logger.warn("Booking not available for user"+userId);
			throw new BookingNotFoundException("Specific Booking not for User");
		}
		return bookingFlipFitServiceImpl.viewUserBooking(userId).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());

	}

	/*
	 * @Method: getBookingDetails
	 * 
	 * @Description: Get Booking Details
	 * 
	 * @MethodParameters: bookingId
	 * 
	 * @Exception
	 */
	@RequestMapping(value = "bookingDetails/{bookingId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<GymBooking> getBookingDetails(@PathVariable(BOOKING_ID) Long bookingId) {
		boolean isBookingAvailable = bookingFlipFitServiceImpl.isBookingAvailable(bookingId);
		if (!isBookingAvailable) {
			logger.warn("Booking not found for the booking id: "+ bookingId);
			throw new BookingNotFoundException("Booking Not Found");
		}
		return bookingFlipFitServiceImpl.getBookingDetails(bookingId).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());

	}

	/*
	 * @Method: cancelBooking
	 * 
	 * @Description: Cancel Booking Details
	 * 
	 * @MethodParameters: bookingId
	 * 
	 * @Exception
	 */
	@PutMapping("/cancelBooking/{bookingId}")
	public ResponseEntity<GymBooking> cancelBooking(@PathVariable Long bookingId) {
		logger.info("Inside cancel booking method. Booking ID: " + bookingId);
		boolean isBookingAvailable = bookingFlipFitServiceImpl.isBookingAvailable(bookingId);
		if (!isBookingAvailable) {
			logger.debug("Booking not found for the user");
			throw new BookingNotFoundException("Booking Not Found");
		}
		GymBooking gymBookings = bookingFlipFitServiceImpl.cancelBooking(bookingId);
		logger.info("Booking cancelled successfully!");
 
		if (Objects.nonNull(gymBookings)) {
			GymNotification gymNotification = new GymNotification();
			gymNotification.setMessage("Booking cancelled successfully for booking ID " + bookingId);
			gymNotification.setNotificationStatus("Successfully Cancelled");
			gymNotificationRepository.save(gymNotification);
		}
		return new ResponseEntity<>(gymBookings, HttpStatus.OK);
	}
	
	
		
	}


