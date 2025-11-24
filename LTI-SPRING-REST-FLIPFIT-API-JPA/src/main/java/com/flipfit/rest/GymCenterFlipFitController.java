
package com.flipfit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flipfit.dao.CenterDto;
import com.flipfit.dao.GymCenterReponse;
import com.flipfit.entity.GymCenter;
import com.flipfit.exception.DetailsNotAvailableException;
import com.flipfit.repository.GymCenterRepository;
import com.flipfit.services.GymCenterFlipFitServiceImpl;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * @Class: GymCenterFlipFitController
 * @Description: Requests related to Center 
 */
@RestController
@RequestMapping("/gymcenter")
public class GymCenterFlipFitController {
	private static final Logger logger = LoggerFactory.getLogger(GymCenterFlipFitController.class);

	@Autowired
	private GymCenterRepository gymCenterRepository;

	@Autowired
	private GymCenterFlipFitServiceImpl gymCenterFlipFitServiceImpl;

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

	@RequestMapping(value = "/getAllCenters", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<GymCenter> getAllCenters() {
		logger.info("Fetching all gym centers");
		List<GymCenter> centers = gymCenterRepository.findAll();
		if (centers.isEmpty()) {
			logger.warn("No gym centers found");
			throw new DetailsNotAvailableException("No Gym Centersfound");
		}
		logger.debug("Total centers fetched: {}", centers.size());
		return centers;
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

	@RequestMapping(value = "/getCenterByCity/{city}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<GymCenter> getCentersByCity(@PathVariable String city) {
		logger.info("Fetching gym centers for city: {}", city);
		List<GymCenter> centers = gymCenterRepository.findByCity(city);
		if (centers.isEmpty()) {
			logger.warn("No gym centers found in city: {}", city);
			throw new DetailsNotAvailableException("No Gym Centers found in city: " + city);
		}
		logger.debug("Centers found in {}: {}", city, centers.size());
		return centers;
	}

	/*
	 * @Method: registerCenter
	 * 
	 * @Description: Register a new gym center
	 * 
	 * @Parameters: GymCenter
	 * 
	 * @Exception: DetailsNotAvailableException if registration fails
	 */

	@RequestMapping(value = "/registerCenter", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)

	public ResponseEntity<GymCenterReponse> registerCenter(@RequestBody CenterDto centerDto) {
		logger.info("Registering new gym center: {}", centerDto.getCenterName());
		if (centerDto == null) {
			logger.error("Invalid gym center details provided");
			throw new DetailsNotAvailableException("Invalid Gym Center details");
		}

		GymCenterReponse savedCenter = gymCenterFlipFitServiceImpl.registerCenter(centerDto);
		logger.debug("Gym center registered successfully with ID: {}", savedCenter.getCenterId());
		return new ResponseEntity<>(savedCenter, HttpStatus.CREATED);
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

	@RequestMapping(value = "/updateCenter/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)

	public ResponseEntity<GymCenter> updateCenter(@PathVariable Long id, @RequestBody GymCenter centerDetails) {
		logger.info("Updating gym center with ID: {}", id);
		GymCenter existingCenter = gymCenterRepository.findById(id).orElseThrow(() -> {
			logger.error("Gym center not found for ID: {}", id);
			return new DetailsNotAvailableException("Gym Center not found");
		});
		existingCenter.setAmountPerSlot(centerDetails.getAmountPerSlot());
		existingCenter.setCenterName(centerDetails.getCenterName());
		existingCenter.setCity(centerDetails.getCity());
		existingCenter.setGymOwnerId(centerDetails.getGymOwnerId());
		existingCenter.setIsApproved(centerDetails.getIsApproved());

		GymCenter updatedCenter = gymCenterRepository.save(existingCenter);
		logger.debug("Gym center updated successfully for ID: {}", id);
		return new ResponseEntity<>(updatedCenter, HttpStatus.OK);
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

	@RequestMapping(value = "/getCenter/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)

	public ResponseEntity<GymCenter> getCenterById(@PathVariable Long id) {
		logger.info("Fetching gym center by ID: {}", id);
		GymCenter center = gymCenterRepository.findById(id).orElseThrow(() -> {
			logger.error("Gym center not found for ID: {}", id);
			return new DetailsNotAvailableException("Gym Center not found");
		});
		logger.debug("Gym center fetched successfully for ID: {}", id);
		return new ResponseEntity<>(center, HttpStatus.OK);
	}

	/*
	 * @Method: deleteCenter
	 * 
	 * @Description: Delete gym center by ID
	 * 
	 * @Parameters: id
	 * 
	 * @Exception: DetailsNotAvailableException if center not found
	 */

	@RequestMapping(value = "/deleteCenter/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCenter(@PathVariable Long id) {
		logger.info("Deleting gym center with ID: {}", id);
		if (gymCenterRepository.existsById(id)) {
			gymCenterRepository.deleteById(id);
			logger.debug("Gym center deleted successfully for ID: {}", id);
			return new ResponseEntity<>("Gym Center deleted successfully!", HttpStatus.OK);
		} else {
			logger.error("Gym center not found for deletion, ID: {}", id);
			throw new DetailsNotAvailableException("Gym Center not found");
		}
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

	@RequestMapping(value = "/getCenterByOwnerId/{gymOwnerId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)

	public ResponseEntity<List<GymCenter>> getCenterByOwnerId(@PathVariable("gymOwnerId") Long gymOwnerId) {
		logger.info("Fetching gym centers for owner ID: {}", gymOwnerId);
		List<GymCenter> gymCenterList = gymCenterFlipFitServiceImpl.findCenterByOwnerId(gymOwnerId);

		if (gymCenterList.isEmpty()) {
			logger.warn("No gym centers found for owner ID: {}", gymOwnerId);
			throw new DetailsNotAvailableException("Center List Not Found for Owner Id " + gymOwnerId);
		}

		logger.debug("Total centers found for owner ID {}: {}", gymOwnerId, gymCenterList.size());
		return new ResponseEntity<>(gymCenterList, HttpStatus.OK);
	}
}
