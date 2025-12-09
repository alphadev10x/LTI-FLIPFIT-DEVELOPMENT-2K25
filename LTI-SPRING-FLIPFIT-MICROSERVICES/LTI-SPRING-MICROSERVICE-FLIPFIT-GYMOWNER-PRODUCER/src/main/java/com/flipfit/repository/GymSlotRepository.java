/**
 * 
 */
package com.flipfit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flipfit.entity.GymSlot;

/**
 * 
 */
public interface GymSlotRepository extends JpaRepository<GymSlot, Long>{
	
	List<GymSlot> findByCenterId(Long centerId);

}
