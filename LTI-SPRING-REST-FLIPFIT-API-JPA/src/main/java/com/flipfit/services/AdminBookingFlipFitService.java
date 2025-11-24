/**
 * 
 */
package com.flipfit.services;

import java.util.List;
import java.util.Optional;

import com.flipfit.dao.AdminDto;
import com.flipfit.entity.GymAdmin;
import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymOwner;


/**
 * 
 */
public interface AdminBookingFlipFitService {

	public Optional<GymOwner> validateOwner( Long ownerId);
	public Optional<GymCenter> validateCenter( Long centerid);
	public  List<GymOwner> viewPendingOwnerRequest();
	public List<GymCenter> viewPendingCenterRequest();
	public GymAdmin registerAdmin(AdminDto adminDto);
	

}
