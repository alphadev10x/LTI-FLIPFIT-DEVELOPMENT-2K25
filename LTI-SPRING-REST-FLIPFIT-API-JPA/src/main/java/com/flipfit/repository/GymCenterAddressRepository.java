/**
 * 
 */
package com.flipfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipfit.entity.GymCenterAddress;

/**
 * 
 */
@Repository
public interface GymCenterAddressRepository extends JpaRepository<GymCenterAddress, Long>  {

}
