/**
 * 
 */
package com.flipfit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flipfit.entity.GymCenter;


/**
 * 
 */
@Repository
public interface GymCenterRepository extends JpaRepository<GymCenter, Long> {
	
	List<GymCenter> findByCity(String city);
	
	List<GymCenter> findByGymOwnerId(Long gymOwnerId);
	
	@Query(value = "SELECT * FROM gymcenter WHERE is_approved = false", nativeQuery = true)
	List<GymCenter> findUnapprovedCenter();

}
