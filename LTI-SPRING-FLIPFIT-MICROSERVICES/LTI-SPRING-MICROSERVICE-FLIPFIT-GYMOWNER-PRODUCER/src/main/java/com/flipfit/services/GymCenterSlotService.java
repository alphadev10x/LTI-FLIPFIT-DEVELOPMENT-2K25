/**
 * 
 */
package com.flipfit.services;

import java.util.List;

import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymSlot;

/**
 * 
 */
public interface GymCenterSlotService {
	
	GymCenter addCenter(GymCenter center);
	List<GymCenter> getCentersByOwner(Long ownerId);
	GymSlot addSlot(Long centerId, GymSlot slot);
	List<GymSlot> getSlotsByCenter(Long centerId);

}
