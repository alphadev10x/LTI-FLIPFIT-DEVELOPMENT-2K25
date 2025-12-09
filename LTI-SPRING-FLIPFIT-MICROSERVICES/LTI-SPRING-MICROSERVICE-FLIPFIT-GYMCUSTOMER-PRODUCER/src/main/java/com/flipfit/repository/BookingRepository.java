/**
 * 
 */
package com.flipfit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flipfit.entity.Booking;

/**
 * 
 */
public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	long countBySlotIdAndStatus(Long slotId, String status);
	
	List<Booking> findByCustomerId(Long customerId);
}
