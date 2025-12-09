
package com.flipfit.services;

import java.util.ArrayList;
import java.util.List;

import  org.springframework.cache.annotation.CachePut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.flipfit.dao.CenterDto;
import com.flipfit.dao.GymCenterResponse;
import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymCenterAddress;
import com.flipfit.entity.GymSlot;
import com.flipfit.exception.DetailsNotAvailableException;
import com.flipfit.repository.GymCenterAddressRepository;
import com.flipfit.repository.GymCenterRepository;
import com.flipfit.repository.GymSlotRepository;

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
	public GymCenterResponse registerCenter(CenterDto centerDto) {
		// TODO Auto-generated method stub
		GymCenterResponse gymCenterResponse = new GymCenterResponse();
		GymCenter center = saveCenter(centerDto);
		GymCenterAddress address = centerDto.getCenterLocation();
		address.setCenterId(center.getCenterId());
		gymCenterAddressRepository.save(address);
		/*
		 * List<GymSlot> gymSlots = centerDto.getGymSlots(); for (GymSlot gymSlot :
		 * gymSlots) {
		 * 
		 * gymSlot.setCenterId(center.getCenterId()); gymSlotRepository.save(gymSlot); }
		 */
		gymCenterResponse.setCenterId(center.getCenterId());
		gymCenterResponse.setLocationStatus("Location Added Successfully");
		gymCenterResponse.setSlotStatus("Slots Added Successfully");
		
		return gymCenterResponse;
	}

	/*
	 * @Method: getAllCenters
	 * 
	 * @Description: Fetch all gym centers
	 * 
	 * @Parameters: None
	 * 
	 * @Exception: DetailsNotAvailableException if no centers found
	 * 
	 * 
	 */
	@Override
	public List<GymCenter> getAllCenters() {
		logger.info("Cache MISS - Fetching all gym centers from DB...");
		return gymCenterRepository.findAll();
	}

	/*
	 * @Method: getCentersByCity
	 * 
	 * @Description: Fetch gym centers by city
	 * 
	 * @Parameters: city
	 * 
	 * @Exception: DetailsNotAvailableException if no centers found in city
	 */
	@Override
	public List<GymCenter> getCentersByCity(String city) {
		logger.info("Fetching gym centers for city: {}", city);
		//List<GymCenter> centers = gymCenterRepository.findByCity(city);
		List<GymCenter> centers = new ArrayList<>();
		if (centers.isEmpty()) {
			logger.warn("No gym centers found in city: {}", city);
			throw new DetailsNotAvailableException("No Gym Centers found in city: " + city);
		}
		return centers;
	}

	/*
	 * @Method: getCenterByOwnerId
	 * 
	 * @Description: Fetch Center by Owner Id
	 * 
	 * @MethodParameters: ownerid
	 * 
	 * @Exception
	 */
	@Override
	public List<GymCenter> getCentersByOwnerId(Long gymOwnerId) {
		logger.info("Fetching gym centers for owner ID: {}", gymOwnerId);
		List<GymCenter> centers = gymCenterRepository.findByGymOwnerId(gymOwnerId);
		if (centers.isEmpty()) {
			logger.warn("No gym centers found for owner ID: {}", gymOwnerId);
			throw new DetailsNotAvailableException("No Gym Centers found for owner ID: " + gymOwnerId);
		}
		return centers;
	}


	/*
	 * @Method: getCenterById
	 * 
	 * @Description: Fetch gym center by ID
	 * 
	 * @Parameters: id
	 * 
	 * @Exception: DetailsNotAvailableException if center not found
	 */
	@Override
	public GymCenter getCenterById(Long id) {
		GymCenter center = gymCenterRepository.findById(id).orElseThrow(() -> {
			logger.error("Gym center not found for ID: {}", id);
			return new DetailsNotAvailableException("Gym Center not found");
		});
		return center;
	}
	
	/*
	 * @Method: updateCenter
	 * 
	 * @Description: Update gym center details
	 * 
	 * @Parameters: id, GymCenter
	 * 
	 * @Exception: DetailsNotAvailableException if center not found
	 */
	@Override
	public GymCenter updateCenter( Long id ,GymCenter centerDetails) {
		GymCenter existingCenter = gymCenterRepository.findById(id).orElseThrow(() -> {
			logger.error("Gym center not found for ID: {}", id);
			return new DetailsNotAvailableException("Gym Center not found");
		});
		existingCenter.setContactPerson(centerDetails.getContactPerson());
		existingCenter.setCenterName(centerDetails.getCenterName());
		existingCenter.setDescription(centerDetails.getDescription());
		existingCenter.setGymOwnerId(centerDetails.getGymOwnerId());
		existingCenter.setIsApproved(centerDetails.getIsApproved());
		existingCenter.setEmail(centerDetails.getEmail());
		existingCenter.setPhone(centerDetails.getPhone());

		return gymCenterRepository.save(existingCenter);
		
	}
	
	public GymCenter saveCenter(CenterDto centerDto) {
		GymCenter gymCenter = new GymCenter();
		gymCenter.setCenterName(centerDto.getCenterName());
		gymCenter.setGymOwnerId(centerDto.getGymOwnerId());
		gymCenter.setContactPerson(centerDto.getContactPerson());
		gymCenter.setDescription(centerDto.getDescription());
		gymCenter.setEmail(centerDto.getEmail());
		gymCenter.setPhone(centerDto.getPhone());
		gymCenter.setIsApproved(false);
		GymCenter center = gymCenterRepository.save(gymCenter);
		return center;
	}
	
	
}


