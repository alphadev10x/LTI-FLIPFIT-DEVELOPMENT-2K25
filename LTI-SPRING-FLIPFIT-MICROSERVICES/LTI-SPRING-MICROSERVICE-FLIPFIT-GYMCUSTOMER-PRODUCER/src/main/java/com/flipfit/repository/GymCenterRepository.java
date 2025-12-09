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
	
	@Query("SELECT g FROM GymCenter g WHERE g.approved = true")
	List<GymCenter> findByApproved();

}
