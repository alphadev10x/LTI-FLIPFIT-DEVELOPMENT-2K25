package com.flipfit.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flipfit.dao.OwnerDto;
import com.flipfit.entity.GymOwner;
import com.flipfit.exception.DetailsNotAvailableException;
import com.flipfit.repository.GymOwnerRepository;
import com.flipfit.services.GymOwnerFlipFitServiceImpl;

import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;


/*
 * @Class: GymOwnerFlipFitController
 * @Description: Requests related to gym owners
 */
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/owner")
public class GymOwnerFlipFitController {
	private static final Logger logger = LoggerFactory.getLogger(GymOwnerFlipFitController.class);

	@Autowired
	private GymOwnerFlipFitServiceImpl gymOwnerFlipFitServiceImpl;
	
	@Autowired
	private GymOwnerRepository gymOwnerRepository;
	
	
	

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
	public GymOwner getOwner(@PathVariable Long ownerId) {
		logger.info("Gym Owner Details");
		
		return gymOwnerFlipFitServiceImpl.getOwnerDetails(ownerId);

	}
	
	/*
     * @Method: getAllGymOwners
     * @Description: Fetch all gym centers
     * @Parameters: None
     * @Exception: DetailsNotAvailableException if no centers found
     */
	@RequestMapping(value = "/getAllGymOwners", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
    public List<GymOwner> getAllOwners() {
		logger.info("Get All Gym Owners");
		
		return gymOwnerFlipFitServiceImpl.getAllOwners();
    }
    
    /*
     * @Method: updateCenter
     * @Description: Update gym center details
     * @Parameters: id, GymCenter
     * @Exception: DetailsNotAvailableException if center not found
     */
	@RequestMapping(value ="/updateGymOwner/{id}",produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public GymOwner updateGymOwner(@PathVariable Long id, @Valid @RequestBody GymOwner ownerDetails) {
		logger.info("Update Gym Center Details Controller for id" + id);
		return gymOwnerFlipFitServiceImpl.updateGymOwner(id,ownerDetails);

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
	public ResponseEntity<GymOwner> registerOwner(@Valid @RequestBody OwnerDto ownerDto) {
		logger.info("Register User as Gym Owner");
		GymOwner registerGymOwner = gymOwnerFlipFitServiceImpl.registerUser(ownerDto);
		logger.info("Gym owner registration successful");
		return new ResponseEntity<>(registerGymOwner, HttpStatus.CREATED);

	}	
}