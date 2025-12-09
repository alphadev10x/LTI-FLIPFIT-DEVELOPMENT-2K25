/**
 * 
 */
package com.flipfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flipfit.entity.GymAdmin;



/**
 * 
 */
@Repository
public interface GymAdminRepository extends JpaRepository<GymAdmin, Long> {
	
	

}
