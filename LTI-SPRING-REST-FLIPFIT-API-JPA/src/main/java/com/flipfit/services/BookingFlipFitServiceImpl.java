package com.flipfit.services;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipfit.dao.BookingDto;
import com.flipfit.dao.GymBookingReponse;
import com.flipfit.entity.GymBooking;
import com.flipfit.entity.GymNotification;
import com.flipfit.entity.GymPayment;
import com.flipfit.exception.SlotsNotAvailableException;
import com.flipfit.repository.GymBookingRepository;
import com.flipfit.repository.GymNotificationRepository;
import com.flipfit.repository.GymPaymentRepository;

/*
 * Author: GroupAlpha
 * Version: v0.1
 * Description: Flip Fit Booking Service Implementation 
 */
@Service
public class BookingFlipFitServiceImpl implements BookingFlipFitService {

	@Autowired
	GymBookingRepository gymBookingRepository;
	
	@Autowired
	GymPaymentRepository  gymPaymentRepository;
	
	@Autowired
	GymNotificationRepository gymNotificationRepository;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/*
	 * @Method: Override bookSlot
	 * 
	 * @Description: book a slot
	 * 
	 * @Parameters: gymBooking of type GymBooking
	 * 
	 * @Exception: None
	 */
	@Override
	public GymBookingReponse bookSlot(BookingDto bookingDto) {
		GymBookingReponse gymBookingResp = new GymBookingReponse();
		logger.info("Booking Slot for user"+bookingDto.getUserId());
		GymBooking gymBookings =	saveBookingDetails( bookingDto) ;
		gymBookingResp.setBookingId(gymBookings.getBookingId());
		gymBookingResp.setUserId(gymBookings.getUserId());
		if(Objects.nonNull(gymBookings)) {
			gymPaymentRepository.save(bookingDto.getPayment());
			gymBookingResp.setBookingStatus("Booking Successful");
			gymBookingResp.setPaymentStatus("Payment Successfully");
			logger.info("Payment Successfully for user"+bookingDto.getUserId());
			sendNotification("Payment Successfully" ,"Payment Successfully" ,bookingDto.getUserId());
    		logger.info("Notification send successfully for payment");
		}
		
		if(Objects.nonNull(gymBookings)) {
			sendNotification("Slot Booked Sucessfully" ,"Successfully Booked" ,bookingDto.getUserId());
    		logger.info("Notification send successfully for Slot Booking");
    		gymBookingResp.setNotificationStatus("Notification send successfully");
    	}
		logger.info("Slot booked successfully");
		return gymBookingResp;
	}
	
	/*
	 * @Method: Override viewUserBooking
	 * 
	 * @Description: view user booking for user id
	 * 
	 * @Parameters: gymBooking of type GymBooking
	 * 
	 * @Exception: None
	 */
	@Override
	public Optional<GymBooking> viewUserBooking(Long userId) {
		logger.info("find user booking by user id: "+userId);
		return gymBookingRepository.findByUserId(userId);

	}
	
	/*
	 * @Method: Override getBookingDetails
	 * 
	 * @Description: get booking details for an id
	 * 
	 * @Parameters: bookingId of type Long
	 * 
	 * @Exception: None
	 */
	@Override
	public Optional<GymBooking> getBookingDetails(Long bookingId) {
		logger.info("find booking details by the booking id: "+bookingId);
		return gymBookingRepository.findById(bookingId);
	}
	
	/*
	 * @Method: Override duplicateBookingCheck
	 * 
	 * @Description: check a duplicate booking
	 * 
	 * @Parameters: gymBooking of type GymBooking
	 * 
	 * @Exception: None
	 */
	@Override
	public boolean duplicateBookingCheck(GymBooking gymBooking) {
		boolean isDuplicateBooking = gymBookingRepository.findAll().stream()
				.anyMatch(b -> gymBooking.getSlotid().equals(b.getSlotid())
						&& gymBooking.getUserId().equals(b.getUserId()));
		if (isDuplicateBooking) {
			logger.warn("duplicate booking found with the given details "+ gymBooking.toString());
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * @Method: Override isUserAvailable
	 * 
	 * @Description: check if the user is available or not based on the ID
	 * 
	 * @Parameters: userId of type Long
	 * 
	 * @Exception: None
	 */
	@Override
	public boolean isUserAvailable(Long userId) {
		Optional<GymBooking> isUserAvailable = gymBookingRepository.findAll().stream()
				.filter(b -> userId.equals(b.getUserId())).findFirst();
		if (isUserAvailable.isEmpty()) {
			logger.warn("user is available with user id"+ userId);
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * @Method: Override isBookingAvailable
	 * 
	 * @Description: check if the booking available based on the booking ID
	 * 
	 * @Parameters: bookingId of type Long
	 * 
	 * @Exception: None
	 */
	@Override
	public boolean isBookingAvailable(Long bookingId) {
		Optional<GymBooking> isBookingAvailable = gymBookingRepository.findAll().stream()
				.filter(b -> b.getBookingId().equals(bookingId)).findFirst();
		if (isBookingAvailable.isEmpty()) {
			logger.warn("Booking is not available for the id: "+ bookingId);
			return false;
		} else {
			return true;
		}
	}
	
	public GymBooking saveBookingDetails(BookingDto bookingDto) {
		GymBooking gymBooking = new GymBooking();
		gymBooking.setBookDate(LocalDate.now());
		gymBooking.setBookingStatus(bookingDto.isBookingStatus());
		gymBooking.setSlotid(bookingDto.getSlotId());
		gymBooking.setUserId(bookingDto.getUserId());
		GymPayment payment = bookingDto.getPayment();
		Boolean isDuplicateBooking = duplicateBookingCheck(gymBooking);
		if (isDuplicateBooking) {
			logger.warn("User already has a booking"+bookingDto.getUserId());
			throw new SlotsNotAvailableException("User already has a booking");
		}
		GymBooking gymBookings = gymBookingRepository.save(gymBooking);
		logger.info("Booking Slot Successfully for user"+bookingDto.getUserId());
		return gymBookings;
		
	}
	
	public void sendNotification(String message ,String status ,Long userId) {
		GymNotification gymNotification = new GymNotification();
		gymNotification.setMessage(message+ userId);
		gymNotification.setNotificationStatus(status);
		gymNotificationRepository.save(gymNotification);
		
	}
	
	
	@Override
	public GymBooking cancelBooking(Long bookingId) {
		GymBooking cancelBooking = gymBookingRepository.findById(bookingId).get();
		cancelBooking.setBookingStatus(false);
		return gymBookingRepository.save(cancelBooking);
	}

}
