/**
 * 
 */
package com.flipfit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flipfit.entity.GymBooking;
import com.flipfit.constants.JPQLConstant;
import com.flipfit.dao.BookingView;

/**
 * 
 */
@Repository
public interface GymBookingRepository extends JpaRepository<GymBooking, Long> {

	Optional<GymBooking> findByUserId(Long userId);
	@Query(JPQLConstant.JPQL_COUNTUSERBOOKING)
	Long countDuplicateBooking(@Param("slotId") Long slotId, @Param("userId") long userId);
 
	@Query(JPQLConstant.JPQL_CHECKUSERAVAILABILITY)
	Long isUserAvailable(@Param("userId") long userId);
 
	@Query(JPQLConstant.JPQL_CHECKBOOKINGAVAILABILITY)
	Long isBookingAvailable(@Param("bookingId") long bookingId);
 
	@Query(JPQLConstant.JPQL_FINDSLOTBYBOOKINGID)
	Long findSlotIdByBookingId(@Param("bookingId") Long bookingId);
 
	@Modifying
	@Query(JPQLConstant.JPQL_UPDATEBOOKINGSTATUS)
	int cancelBookingById(@Param("bookingId") Long bookingId);
	
   
      
	
			 

	
	@Query(value = "SELECT s.centerid, s.slotname, c.firstname, c.lastname,  b.bookdate, b.bookingstatus FROM gymbooking b 	INNER JOIN slot s ON b.slotid= s.slotid INNER JOIN gymcustomer c ON c.userid=b.userid WHERE b.userid=?1", nativeQuery = true)
	List<Object[]> findBookingsForUser( Long userId);
	 
}
