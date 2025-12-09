package com.flipfit.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flipfit.constants.JPQLConstant;
import com.flipfit.entity.GymScheduler;

@Repository
public interface GymSchedulerRepository extends JpaRepository<GymScheduler, Long> {
	
	@Modifying
	@Query(value=JPQLConstant.JPQL_UPDATE_SCHEDULER, nativeQuery = true)
	public int updateScheduler(Long scheduleId, LocalDate date, Long slotid, Long bookingid);

	
	@Query(value = JPQLConstant.JPQL_USER_ID, nativeQuery = true)
	public Optional<GymScheduler> findByUserId(Long userId);
	
	@Query(value=JPQLConstant.JPQL_FIRST_NAME, nativeQuery = true)
	public String getFirstName(Long userId);
	
	@Query(value=JPQLConstant.JPQL_LAST_NAME, nativeQuery = true)
	public String getLastName(Long userId);
	
	@Query(value=JPQLConstant.JPQL_SLOT_NAME, nativeQuery = true)
	public String getSlotName(Long bookingid);
	
	@Query(value=JPQLConstant.JPQL_CENTER_NAME, nativeQuery = true)
	public String getCenterName(Long bookingid);
}
