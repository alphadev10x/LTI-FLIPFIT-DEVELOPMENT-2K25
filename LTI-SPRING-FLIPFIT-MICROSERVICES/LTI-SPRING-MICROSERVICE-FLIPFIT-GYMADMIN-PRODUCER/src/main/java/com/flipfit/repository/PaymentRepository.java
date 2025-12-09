/**
 * 
 */
package com.flipfit.repository;

/**
 * 
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.flipfit.entity.GymPayment;
 

 
@Repository
public interface PaymentRepository extends JpaRepository<GymPayment, Long> {
	
	
	    
}