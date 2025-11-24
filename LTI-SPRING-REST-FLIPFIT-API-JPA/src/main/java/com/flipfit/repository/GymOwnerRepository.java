/**
 * 
 */
package com.flipfit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flipfit.entity.GymOwner;

/**
 * 
 */
@Repository
public interface GymOwnerRepository extends JpaRepository<GymOwner, Long> {

	@Query(value = "SELECT * FROM gymowner WHERE isapproved = false", nativeQuery = true)
	List<GymOwner> findUnapprovedOwners();

}
