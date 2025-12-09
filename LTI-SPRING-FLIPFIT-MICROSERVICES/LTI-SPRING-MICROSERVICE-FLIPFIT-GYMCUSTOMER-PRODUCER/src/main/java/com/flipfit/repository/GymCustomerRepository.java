/**
 * 
 */
package com.flipfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipfit.entity.GymCustomer;



/**
 * 
 */
@Repository
public interface GymCustomerRepository extends JpaRepository<GymCustomer, Long>{
	
	


}
