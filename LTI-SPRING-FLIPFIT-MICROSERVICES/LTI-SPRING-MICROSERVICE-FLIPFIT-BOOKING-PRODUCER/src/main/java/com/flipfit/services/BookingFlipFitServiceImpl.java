package com.flipfit.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flipfit.dao.BookingDto;
import com.flipfit.dao.BookingView;
import com.flipfit.dao.GymBookingReponse;
import com.flipfit.entity.GymBooking;
import com.flipfit.entity.GymNotification;
import com.flipfit.entity.GymPayment;
import com.flipfit.entity.GymSlot;
import com.flipfit.exception.BookingFullException;
import com.flipfit.exception.SlotsNotAvailableException;
import com.flipfit.feignclient.NotificationClient;
import com.flipfit.repository.GymBookingRepository;
import com.flipfit.repository.GymNotificationRepository;
import com.flipfit.repository.GymPaymentRepository;
import com.flipfit.repository.GymSlotRepository;

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
	NotificationClient notificationClient;
	
	@Autowired
	GymSlotRepository gymSlotRepository;
	
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
		/*
		 * GymSlot gymSlot = gymSlotRepository.findById(bookingDto.getSlotId()).get();
		 * logger.debug("Slot ID: " + bookingDto.getSlotId()); if (gymSlot == null) {
		 * throw new SlotsNotAvailableException("Slot not found for slot ID " +
		 * bookingDto.getSlotId()); } if (gymSlot.getCapacity() == null ||
		 * gymSlot.getCapacity() == 0) { throw new
		 * BookingFullException("Booking capacity reached for this slot."); }
		 * logger.debug("Gym Slot capacity=" + gymSlot.getCapacity());
		 * gymSlot.setCapacity(gymSlot.getCapacity() - 1);
		 * gymSlotRepository.save(gymSlot);
		 */
		GymBookingReponse gymBookingResp = new GymBookingReponse();
		logger.info("Booking Slot for user"+bookingDto.getUserId());
		GymBooking gymBookings =	saveBookingDetails( bookingDto) ;
		System.out.println("Booking" +gymBookings.getBookingId());
		gymBookingResp.setBookingId(gymBookings.getBookingId());
		gymBookingResp.setUserId(gymBookings.getUserId());
		if(Objects.nonNull(gymBookings)) {
		//	makePayment(gymBookings, bookingDto);
			gymBookingResp.setBookingStatus("Booking Successful");
			//gymBookingResp.setPaymentStatus("Payment Successfully");
			logger.info("Payment Successfully for user"+bookingDto.getUserId());
		//	sendNotification("Payment Successfully" ,"Payment Successfully" ,bookingDto.getUserId());
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
	public List<BookingView> viewUserBooking(Long userId) {
		logger.info("find user booking by user id: "+userId);
	
		
		List<Object[]> results = gymBookingRepository.findBookingsForUser(userId);
		return results.stream().map(this::mapToObject).collect(Collectors.toList());
		
	}
	
	 private BookingView mapToObject(Object[] result) {
		 System.out.println("Coming");
		 BookingView dto = new BookingView();
	        dto.setCenterId(((Number) result[0]).longValue());
	        dto.setSlotName((String) result[1]);
	        dto.setFirstName((String) result[2]);
	        dto.setLastName((String) result[3]);
	        dto.setBookDate(toDateString(result[4]));
	        dto.setBookingStatus((Boolean) result[5]);
	       // Assuming department_name is at index 5 based on the select clause
	        return dto;
	    }
		


	


private static String toDateString(Object o) {
    if (o == null) return null;
    DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE; // "yyyy-MM-dd"
    if (o instanceof java.sql.Date d) return d.toLocalDate().format(fmt);
    if (o instanceof java.sql.Timestamp ts) return ts.toLocalDateTime().toLocalDate().format(fmt);
    // Already a string? Return as-is or parse & reformat if you need strict ISO
    return o.toString();
}





	//	return gymBookingRepository.findByUserId(userId);

	
	
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
	//@Cacheable(value = "bookingCache", key = "#bookingId")
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
		Long count = gymBookingRepository.countDuplicateBooking(gymBooking.getSlotid(), gymBooking.getUserId());
		if (count != null && count > 0) {
			logger.warn("Duplicate booking found with the given details " + gymBooking.toString());
			return true;
		}
		return false;
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
		Long count = gymBookingRepository.isUserAvailable(userId);
		if (count == null || count == 0) {
			logger.warn("User is not available with user id " + userId);
			return false;
		}
		return true;
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
		Long count = gymBookingRepository.isBookingAvailable(bookingId);
		if (count == null || count == 0) {
			logger.warn("Booking is not available with user id " + bookingId);
			return false;
		}
		return true;
	}
	
	public GymBooking saveBookingDetails(BookingDto bookingDto) {
		GymBooking gymBooking = new GymBooking();
		gymBooking.setBookDate(LocalDate.now());
		gymBooking.setBookingStatus(true);
		gymBooking.setSlotid(bookingDto.getSlotId());
		gymBooking.setUserId(bookingDto.getUserId());
	//	GymPayment payment = bookingDto.getPayment();
		/*
		 * Boolean isDuplicateBooking = duplicateBookingCheck(gymBooking); if
		 * (isDuplicateBooking) {
		 * logger.warn("User already has a booking"+bookingDto.getUserId()); throw new
		 * SlotsNotAvailableException("User already has a booking"); }
		 */
		GymBooking gymBookings = gymBookingRepository.save(gymBooking);
		logger.info("Booking Slot Successfully for user"+bookingDto.getUserId());
		return gymBookings;
		
	}
	
	public void sendNotification(String message ,String status ,Long userId) {
		GymNotification gymNotification = new GymNotification();
		gymNotification.setMessage(message+ userId);
		gymNotification.setNotificationStatus(status);
		gymNotificationRepository.save(gymNotification);
		//notificationClient.sendNotification(gymNotification);
		
	}
	
	
	@Transactional
	@Override
	public GymBooking cancelBooking(Long bookingId) {
		gymBookingRepository.cancelBookingById(bookingId);
		Long slotId = gymBookingRepository.findSlotIdByBookingId(bookingId);
 
		logger.debug("Slot ID: " + slotId);
 
		if (slotId != null) {
			gymSlotRepository.increaseCapacity(slotId);
		}
 
		return gymBookingRepository.findById(bookingId).get();
	}

	@Override
	public List<GymPayment> getTransactionDetails(Long userId) {
		return gymPaymentRepository.findByUserId(userId);
	}
	
	/*
	 * public void makePayment(GymBooking gymBookings, BookingDto bookingDto) {
	 * GymPayment payment = new GymPayment();
	 * payment.setAmount(bookingDto.getPayment().getAmount());
	 * payment.setBookingId(gymBookings.getBookingId());
	 * payment.setPaymentStatus(bookingDto.getPayment().getPaymentStatus());
	 * payment.setPhoneNumber(bookingDto.getPayment().getPhoneNumber());
	 * payment.setPmodeid(bookingDto.getPayment().getPmodeid());
	 * payment.setUserId(bookingDto.getUserId());
	 * gymPaymentRepository.save(payment); }
	 */
	
	/*
	 * public CardDetails getCardDetails(Long userId) { CardDetails cardDetails =
	 * cardDetailsRepository.findByUserId(userId); return cardDetails; }
	 */

}
