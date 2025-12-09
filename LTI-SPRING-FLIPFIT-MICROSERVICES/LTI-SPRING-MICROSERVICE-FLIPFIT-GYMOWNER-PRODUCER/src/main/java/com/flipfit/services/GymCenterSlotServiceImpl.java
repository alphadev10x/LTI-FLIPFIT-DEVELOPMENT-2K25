/**
 * 
 */
package com.flipfit.services;

import java.util.List;

import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymSlot;
import com.flipfit.repository.GymCenterRepository;
import com.flipfit.repository.GymSlotRepository;

/**
 * 
 */
public class GymCenterSlotServiceImpl implements GymCenterSlotService{
	
	private GymCenterRepository gymCenterRepository;
	private GymSlotRepository gymSlotRepository;
	
	/**
	 * @param gymCenterRepository
	 * @param gymSlotRepository
	 */
	public GymCenterSlotServiceImpl(GymCenterRepository gymCenterRepository, GymSlotRepository gymSlotRepository) {
		this.gymCenterRepository = gymCenterRepository;
		this.gymSlotRepository = gymSlotRepository;
	}

	@Override
	public GymCenter addCenter(GymCenter center) {
		center.setApproved(false);
		return gymCenterRepository.save(center);
	}

	@Override
	public List<GymCenter> getCentersByOwner(Long ownerId) {
		return gymCenterRepository.findByOwnerId(ownerId);
	}

	@Override
	public GymSlot addSlot(Long centerId, GymSlot slot) {
		slot.setCenterId(centerId);
		return gymSlotRepository.save(slot);
	}

	@Override
	public List<GymSlot> getSlotsByCenter(Long centerId) {
		return gymSlotRepository.findByCenterId(centerId);
	}
	
	

}
