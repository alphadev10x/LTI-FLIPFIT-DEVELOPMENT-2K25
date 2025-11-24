package com.flipfit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.flipfit.dao.OwnerDto;
import com.flipfit.entity.GymOwner;
import com.flipfit.exception.DetailsNotAvailableException;
import com.flipfit.repository.GymOwnerRepository;
import com.flipfit.services.GymOwnerFlipFitServiceImpl;
import org.springframework.web.bind.annotation.*;
import jakarta.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * @Class: GymOwnerFlipFitController
 * @Description: Requests related to gym owners
 */
@RestController
@RequestMapping("/owner")
public class GymOwnerFlipFitController {
	private static final Logger logger = LoggerFactory.getLogger(GymOwnerFlipFitController.class);

	@Autowired
	private GymOwnerFlipFitServiceImpl gymOwnerFlipFitServiceImpl;
	
	@Autowired
	private GymOwnerRepository gymownerRepository;
	
	
	

	/*
	 * @Method: getowner
	 * 
	 * @Description: Get Gym Owner Details
	 * 
	 * @MethodParameters: OwnerId
	 * 
	 * @Exception DetailsNotAvailableException
	 */
	@RequestMapping(value = "/getOwnerDetails/{ownerId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public GymOwner getowner(@PathVariable("ownerId") Long ownerId) {
		logger.info("Gym Owner Details");
		return gymownerRepository.findById(ownerId).orElseThrow(() -> new DetailsNotAvailableException("Gym Owner not found"));
		

	}
	
	/*
     * @Method: getAllGymOwners
     * @Description: Fetch all gym centers
     * @Parameters: None
     * @Exception: DetailsNotAvailableException if no centers found
     */
	@RequestMapping(value = "/getAllGymOwners", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
    public List<GymOwner> getAllCenters() {
		logger.info("Get All Gym Owners");
        if (gymownerRepository.findAll().isEmpty()) {
        	logger.warn("No gym owner found");
            throw new DetailsNotAvailableException("No Gym Owner found");
        }
        return gymownerRepository.findAll();
    }
    
    /*
     * @Method: updateCenter
     * @Description: Update gym center details
     * @Parameters: id, GymCenter
     * @Exception: DetailsNotAvailableException if center not found
     */
	@RequestMapping(value ="/updateGymOwner/{id}",produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public GymOwner updateGymOwner(@PathVariable Long id, @RequestBody GymOwner ownerDetails) {
		logger.info("Update Gym Center Details Controller");
		logger.debug("Gym owner id: " + id);
		GymOwner existingOwner = gymownerRepository.findById(id)
				.orElseThrow(() -> new DetailsNotAvailableException("Gym Owner not found"));
		existingOwner.setApproved(ownerDetails.isApproved());
		existingOwner.setBusinessName(ownerDetails.getBusinessName());
		existingOwner.setCardNumber(ownerDetails.getCardNumber());
		existingOwner.setFirstName(ownerDetails.getFirstName());
		existingOwner.setGSTIN(ownerDetails.getGSTIN());
		existingOwner.setPANCard(ownerDetails.getPANCard());
		logger.info("Gym onwer details updated");
		return gymownerRepository.save(existingOwner);

	}
	
	/*
	 * @Method: register
	 * 
	 * @Description: Register Gym Owner
	 * 
	 * @MethodParameters: GymOwner
	 * 
	 * @Exception: 
	 */
	@RequestMapping(value = "/registerOwner", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<GymOwner> registerOwner(@RequestBody OwnerDto ownerDto) {
		logger.info("Register User as Gym Owner");
		GymOwner registerGymOwner = gymOwnerFlipFitServiceImpl.registerUser(ownerDto);
		logger.info("Gym owner registration successful");
		return new ResponseEntity<>(registerGymOwner, HttpStatus.CREATED);

	}
	
	
}
	
	

