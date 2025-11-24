
package com.flipfit.services;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipfit.dao.CenterDto;
import com.flipfit.dao.GymCenterReponse;
import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymCenterAddress;
import com.flipfit.entity.GymSlot;
import com.flipfit.exception.DetailsNotAvailableException;
import com.flipfit.repository.GymCenterAddressRepository;
import com.flipfit.repository.GymCenterRepository;
import com.flipfit.repository.GymSlotRepository;
import com.flipfit.rest.GymCenterFlipFitController;
/*
 * @Class: GymCenterFlipFitServiceImpl
 * @Description: Requests related to Center 
 */
@Service
public class GymCenterFlipFitServiceImpl implements GymCenterFlipFitService {

    private static final Logger logger = LoggerFactory.getLogger(GymCenterFlipFitServiceImpl.class);

    @Autowired
    private GymCenterRepository gymCenterRepository;
    
    @Autowired
    private GymCenterAddressRepository gymCenterAddressRepository;
    
    @Autowired
    private GymSlotRepository gymSlotRepository;

    /**
     * @Method: findCenterByOwnerId
     * @Description: Fetch all gym centers associated with a specific owner ID
     * @Parameters: gymOwnerId - Long (ID of the gym owner)
     * @Return: List<GymCenter> - List of gym centers owned by the given owner
     * @Exception: DetailsNotAvailableException if no centers found for the given owner ID
     */
    @Override
    public List<GymCenter> findCenterByOwnerId(Long gymOwnerId) {
        logger.info("Fetching gym centers for owner ID: {}", gymOwnerId);
        List<GymCenter> centers = gymCenterRepository.findByGymOwnerId(gymOwnerId);
        if (centers.isEmpty()) {
            logger.warn("No gym centers found for owner ID: {}", gymOwnerId);
            throw new DetailsNotAvailableException("Center List Not Found for Owner Id " + gymOwnerId);
        }
        logger.debug("Total centers found for owner ID {}: {}", gymOwnerId, centers.size());
        return centers;
    }

	@Override
	public GymCenterReponse registerCenter(CenterDto centerDto) {
		// TODO Auto-generated method stub
		GymCenterReponse gymCenterResponse = new GymCenterReponse();
		GymCenter gymCenter = new GymCenter();
		gymCenter.setCenterName(centerDto.getCenterName());
		gymCenter.setGymOwnerId(centerDto.getGymOwnerId());
		gymCenter.setAmountPerSlot(centerDto.getAmountPerSlot());
		gymCenter.setCity(centerDto.getCity());
		gymCenter.setIsApproved(false);
		
		GymCenter center = gymCenterRepository.save(gymCenter);
		GymCenterAddress address = centerDto.getCenterLocation();
		address.setCenterId(center.getCenterId());
		
		gymCenterAddressRepository.save(address);
		
		List<GymSlot> gymSlots = centerDto.getGymSlots();
		for (GymSlot gymSlot : gymSlots) {
			
			gymSlot.setCenterId(center.getCenterId());
			gymSlotRepository.save(gymSlot);
		}
		gymCenterResponse.setCenterId(gymCenter.getCenterId());
		gymCenterResponse.setLocationStatus("Location Added Successfully");
		gymCenterResponse.setSlotStatus("Slots Added Successfully");
		
		return gymCenterResponse;
	}
}

