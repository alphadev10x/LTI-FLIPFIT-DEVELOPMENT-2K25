/**
 * 
 */
package com.flipfit.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flipfit.entity.Booking;
import com.flipfit.entity.GymSlot;
import com.flipfit.entity.Payment;
import com.flipfit.repository.BookingRepository;
import com.flipfit.repository.GymSlotRepository;

import jakarta.transaction.Transactional;

/**
 * 
 */
@Service
public class BookingServiceImpl {
	
	private final BookingRepository bookingRepository;
	private final GymSlotRepository gymSlotRepository;

	/**
	 * @param bookingrepository
	 * @param gymSlotRepository
	 * @param paymentService
	 */
	public BookingServiceImpl(BookingRepository bookingRepository, GymSlotRepository gymSlotRepository,
			PaymentService paymentService) {
		this.bookingRepository = bookingRepository;
		this.gymSlotRepository = gymSlotRepository;
	}
	
	
	@Transactional
	public Booking bookSlot(Long customerId, Long centerId, Long slotId) {
		GymSlot slot = gymSlotRepository.findById(slotId).orElse(null);
		if(slot == null) return null;
		if(!slot.getCenterId().equals(centerId)) return null;
		
		if(slot.getBooked() >= slot.getCapacity()) return null;
		
		slot.setBooked(slot.getBooked() + 1);
		gymSlotRepository.save(slot);
		
		Booking booking = new Booking();
		booking.setCustomerId(customerId);
		booking.setCenterId(centerId);
		booking.setSlotId(slotId);
		booking.setCreateAt(LocalDateTime.now());
		booking.setStatus("BOOKED");
		return bookingRepository.save(booking);
	}
	
	public List<Booking> getBookingsForCustomer(Long customerId) {
		return bookingRepository.findByCustomerId(customerId);
	}
	
	public Booking cancelBooking(Long bookingId, Long customerId) {
		Booking booking = bookingRepository.findById(bookingId)
				.orElseThrow(() -> new RuntimeException("Booking not found"));
		if(!booking.getCustomerId().equals(customerId)) {
			throw new RuntimeException("Not Allowed!");
		}
		booking.setStatus("CANCELLED");
		return bookingRepository.save(booking);
	}
}
