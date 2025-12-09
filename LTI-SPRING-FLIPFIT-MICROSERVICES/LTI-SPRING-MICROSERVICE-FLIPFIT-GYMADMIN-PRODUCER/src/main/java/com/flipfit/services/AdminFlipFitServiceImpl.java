/**
 * 
 */
package com.flipfit.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymOwner;
import com.flipfit.repository.GymCenterRepository;
import com.flipfit.repository.GymOwnerRepository;

/*
* Admin Service for handling Admin responsibilities
*/
@Service
public class AdminFlipFitServiceImpl implements AdminFlipFitService {
	private static final Logger logger = LoggerFactory.getLogger(AdminFlipFitServiceImpl.class);

	@Autowired
	private GymOwnerRepository gymOwnerRepository;
	@Autowired
	private GymCenterRepository gymCenterRepository;
	
	/**
	 * @param gymOwnerRepository
	 * @param gymCenterRepository
	 */
	public AdminFlipFitServiceImpl(GymOwnerRepository gymOwnerRepository, GymCenterRepository gymCenterRepository) {
		this.gymOwnerRepository = gymOwnerRepository;
		this.gymCenterRepository = gymCenterRepository;
	}
	
	@Override
	public GymOwner approveOwner(Long ownerId) {
		GymOwner owner = gymOwnerRepository.findById(ownerId).get();
		
		if(owner != null) {
			owner.setApproved(true);
			return gymOwnerRepository.save(owner);
		}
		return null;
	}
	
	@Override
	public GymCenter approveCenter(Long centerId) {
		GymCenter center = gymCenterRepository.findById(centerId).get();
		
		if(center != null) {
//			center.setApproved(true);
			return gymCenterRepository.save(center);
		}
		return null;
	}
	
	@Override
	public List<GymOwner> getAllOwners() {
		logger.info("Get all owners");
		return gymOwnerRepository.findAll();
	}
	
	@Override
	public List<GymCenter> getAllCenters() {
		return gymCenterRepository.findAll();
	}

}