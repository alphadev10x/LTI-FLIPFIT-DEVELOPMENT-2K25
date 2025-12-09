/**
 * 
 */
package com.flipfit.services;

import java.util.List;

import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymOwner;


/**
 * 
 */
public interface AdminFlipFitService {

	public GymOwner approveOwner(Long ownerId);
	public GymCenter approveCenter(Long centerid);
	public  List<GymOwner> getAllOwners();
	public List<GymCenter> getAllCenters();
}
