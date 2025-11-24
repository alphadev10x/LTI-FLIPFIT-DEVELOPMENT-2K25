/**
 * 
 */
package com.flipfit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipfit.entity.GymBooking;

/**
 * 
 */
@Repository
public interface GymBookingRepository extends JpaRepository<GymBooking, Long> {

	Optional<GymBooking> findByUserId(Long userId);

}
