/**
 * 
 */
package com.flipfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipfit.entity.GymNotification;

/**
 * 
 */

@Repository
public interface GymNotificationRepository extends JpaRepository<GymNotification, Long>{
	

}
