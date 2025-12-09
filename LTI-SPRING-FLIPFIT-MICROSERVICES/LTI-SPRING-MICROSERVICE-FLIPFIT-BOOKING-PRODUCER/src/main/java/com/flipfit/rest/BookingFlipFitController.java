package com.flipfit.rest;



import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flipfit.dao.BookingDto;
import com.flipfit.dao.BookingView;
import com.flipfit.dao.GymBookingReponse;
import com.flipfit.entity.GymBooking;
import com.flipfit.entity.GymNotification;
import com.flipfit.exception.BookingNotFoundException;
import com.flipfit.exception.UserNotFoundException;
import com.flipfit.repository.GymNotificationRepository;
import com.flipfit.services.BookingFlipFitServiceImpl;
import com.flipfit.entity.GymPayment;

import jakarta.ws.rs.core.MediaType;


@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/booking")
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
	public List<BookingView> viewUserBooking(@PathVariable(USER_ID) Long userId) {
		/*
		 * boolean isUserAvailable = bookingFlipFitServiceImpl.isUserAvailable(userId);
		 * if (!isUserAvailable) { logger.warn("User not available with userId " +
		 * userId); throw new UserNotFoundException("No User Found"); }
		 */
		return  bookingFlipFitServiceImpl.viewUserBooking(userId);
 
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
	
	@GetMapping("/getTransactionByOwnerID/{ownerid}")
	public ResponseEntity<List<GymPayment>> getTransactionByOwnerID(@PathVariable Long ownerid) {
		logger.info("Inside getTransactionByOwnerID method. Owner ID: " + ownerid);
		List<GymPayment> transactionDetails = bookingFlipFitServiceImpl.getTransactionDetails(ownerid);
		logger.info("Booking cancelled successfully!");

		return new ResponseEntity<>(transactionDetails, HttpStatus.OK);
	}
	
	
		
	}


