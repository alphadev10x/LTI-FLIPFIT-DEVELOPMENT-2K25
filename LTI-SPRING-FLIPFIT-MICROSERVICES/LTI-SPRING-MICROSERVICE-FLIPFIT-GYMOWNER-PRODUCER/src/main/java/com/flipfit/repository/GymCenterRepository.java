/**
 * 
 */
package com.flipfit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flipfit.entity.GymCenter;

/**
 * 
 */
public interface GymCenterRepository extends JpaRepository<GymCenter, Long>{
	
	List<GymCenter> findByOwnerId(Long ownerId); 

}
