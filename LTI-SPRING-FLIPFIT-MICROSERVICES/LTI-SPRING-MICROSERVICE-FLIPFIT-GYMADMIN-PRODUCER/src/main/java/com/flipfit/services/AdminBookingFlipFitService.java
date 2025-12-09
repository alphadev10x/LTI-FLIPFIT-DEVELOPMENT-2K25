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
import com.flipfit.entity.GymPayment;


/**
 * 
 */
public interface AdminBookingFlipFitService {

	public int validateOwner( Long ownerId);
	public int validateCenter( Long centerid);
	public  List<GymOwner> viewPendingOwnerRequest();
	public List<GymCenter> viewPendingCenterRequest();
	public GymAdmin registerAdmin(AdminDto adminDto);
	public List<GymAdmin> getAllAdmin();
	public List<GymPayment> getAllPayments();
	

}
