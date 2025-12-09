package com.flipfit.services;

import java.util.List;

import com.flipfit.dao.OwnerDto;
import com.flipfit.entity.GymOwner;

public interface GymOwnerFlipFitService {

	

	public GymOwner registerUser(OwnerDto ownerDto);

	public GymOwner getOwnerDetails(Long ownerId);
	
	public List<GymOwner> getAllOwners();
	
	public GymOwner updateGymOwner(Long id,  GymOwner ownerDetails) ;

}
