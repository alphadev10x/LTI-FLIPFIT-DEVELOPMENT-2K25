/**
 * 
 */
package com.flipfit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flipfit.constants.JPQLConstant;
import com.flipfit.entity.GymCenter;


/**
 * 
 */
@Repository
public interface GymCenterRepository extends JpaRepository<GymCenter, Long> {
	
	@Query(value = JPQLConstant.JPQL_UNAPPROVEDCENTER, nativeQuery = true)
	List<GymCenter> findUnapprovedCenter();
	
	@Modifying 
    @Query(value = JPQLConstant.JPQL_UPDATECENTERAPPROVAL, nativeQuery = true)
    public int approveGymCenter(Long centerId);

}
