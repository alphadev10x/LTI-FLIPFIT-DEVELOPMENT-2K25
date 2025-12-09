/**
 * 
 */
package com.flipfit.services;

import com.flipfit.entity.Booking;

/**
 * 
 */
public interface BookingService {
	
	Booking bookSlot(Long customerId, Long centerId, Long slotId);

}
