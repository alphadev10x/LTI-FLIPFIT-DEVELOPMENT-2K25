package com.flipfit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flipfit.entity.GymSlot;


@Repository
public interface GymSlotRepository extends JpaRepository<GymSlot, Long> {
	
	@Modifying
	@Query("UPDATE GymSlot s SET s.capacity = s.capacity + 1 WHERE s.slotId = :slotId")
	int increaseCapacity(@Param("slotId") Long slotId);
	
	
		

}
