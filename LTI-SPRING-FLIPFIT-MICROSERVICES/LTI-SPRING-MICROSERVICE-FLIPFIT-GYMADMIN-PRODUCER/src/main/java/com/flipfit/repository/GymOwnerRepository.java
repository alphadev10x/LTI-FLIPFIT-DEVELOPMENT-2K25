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
import com.flipfit.entity.GymOwner;

/**
 * 
 */
@Repository
public interface GymOwnerRepository extends JpaRepository<GymOwner, Long> {

	@Query(value = JPQLConstant.JPQL_UNAPPROVEDOWNER, nativeQuery = true)
	List<GymOwner> findUnapprovedOwners();
	
	@Modifying 
    @Query(value = JPQLConstant.JPQL_UPDATEOWNERAPPROVAL, nativeQuery = true)
    public int approveGymOwner(Long ownerId);

}
