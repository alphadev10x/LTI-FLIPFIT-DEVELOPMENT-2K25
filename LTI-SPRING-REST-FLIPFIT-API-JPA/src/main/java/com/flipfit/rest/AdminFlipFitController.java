package com.flipfit.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flipfit.dao.AdminDto;
import com.flipfit.entity.GymAdmin;
import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymOwner;
import com.flipfit.exception.DetailsNotAvailableException;
import com.flipfit.exception.NoPendingCenterException;
import com.flipfit.exception.NoPendingOwnerException;
import com.flipfit.repository.GymAdminRepository;
import com.flipfit.repository.GymCenterRepository;
import com.flipfit.repository.GymOwnerRepository;
import com.flipfit.services.AdminBookingFlipFitServiceImpl;
import com.flipfit.services.GymOwnerFlipFitServiceImpl;

import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Admin Controller for handling Admin responsibilities
 */
@RestController
@RequestMapping("/admin")
public class AdminFlipFitController {
	private static final Logger logger = LoggerFactory.getLogger(AdminFlipFitController.class);

	@Autowired
	AdminBookingFlipFitServiceImpl adminBookingFlipFitServiceImpl;

	@Autowired
	GymOwnerFlipFitServiceImpl gymOwnerFlipFitServiceImpl;

	@Autowired
	private GymOwnerRepository gymOwnerRepository;

	@Autowired
	private GymCenterRepository gymCenterRepository;

	@Autowired
	private GymAdminRepository gymAdminRepository;

	/*
	 * @Method: approveGymOwner
	 * 
	 * @Description: Approve Owner details
	 * 
	 * @MethodParameters: GymOwner
	 * 
	 * @Exception: DetailsNotAvailableException
	 */
	
	@RequestMapping(value = "/approveGymOwner/{ownerId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public ResponseEntity<String> approveGymOwner(@PathVariable Long ownerId) {
		logger.info("Approve Gym Owner for Ownerid " + ownerId);

		Optional<GymOwner> owner = adminBookingFlipFitServiceImpl.validateOwner(ownerId);
		if (owner.isPresent()) {
			GymOwner o = owner.get();
			o.setApproved(true);
			gymOwnerRepository.save(o);
			logger.info("Approved Successfully for ownerId" + ownerId);
			return new ResponseEntity<>("Successfully Approved", HttpStatus.OK);
		} else {
			logger.debug("Owner List is empty");
			throw new DetailsNotAvailableException("Requesting Queue is empty");
		}

	}

	/*
	 * @Method: approveGymCenter
	 * 
	 * @Description: Approve GymCenter details
	 * 
	 * @MethodParameters: GymCenter
	 * 
	 * @Exception
	 */
	
	@RequestMapping(value = "/approveGymCenter/{centerId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public ResponseEntity<String> approveGymCenter(@PathVariable Long centerId) {
		logger.info("Approve Gym Center for Centerid " + centerId);
		Optional<GymCenter> center = adminBookingFlipFitServiceImpl.validateCenter(centerId);
		if (center.isPresent()) {
			GymCenter c = center.get();
			c.setIsApproved(true);
			gymCenterRepository.save(c);
			logger.info("Approved Successfully for centerid" + centerId);
			return new ResponseEntity<>("Successfully Approved", HttpStatus.OK);
		} else {
			logger.debug("center List is empty");
			throw new DetailsNotAvailableException("Requesting Queue is empty");
		}

	}

	/*
	 * @Method: viewPendingOwnerRequest
	 * 
	 * @Description: View Pending Owner request
	 * 
	 * @MethodParameters: No Args
	 * 
	 * @Exception :NoPendingOwnerException
	 */
	
	@RequestMapping(value = "/viewPendingOwnerRequests", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<GymOwner>> viewPendingOwnerRequest() {
		logger.info("View pending owner request");
		List<GymOwner> gymOwners = adminBookingFlipFitServiceImpl.viewPendingOwnerRequest();
		if (gymOwners.isEmpty()) {
			throw new NoPendingOwnerException("No Pending Owner remaining");
		}
		return new ResponseEntity<>(gymOwners, HttpStatus.OK);

	}

	/*
	 * @Method: viewPendingCenterRequest
	 * 
	 * @Description: View Pending Center request
	 * 
	 * @MethodParameters: No Args
	 * 
	 * @Exception :NoPendingCenterException
	 */
	
	@RequestMapping(value = "/viewPendingCenterRequests", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<GymCenter>> viewPendingCenterRequest() {
		logger.info("View pending Center request");
		List<GymCenter> gymCenters = adminBookingFlipFitServiceImpl.viewPendingCenterRequest();
		if (gymCenters.isEmpty()) {
			throw new NoPendingCenterException("No Pending Center remaining");
		}

		return new ResponseEntity<>(gymCenters, HttpStatus.OK);

	}

	/*
	 * @Method: getAllAdmin
	 * 
	 * @Description: Fetch all gym Admins
	 * 
	 * @Parameters: None
	 * 
	 * @Exception: DetailsNotAvailableException if no centers found
	 */
	@RequestMapping(value = "/getAllAdmin", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<GymAdmin> getAllAdmin() {
		logger.info("Fetch all gym Admins");
		if (gymAdminRepository.findAll().isEmpty()) {
			logger.warn("No Gym Admin found");
			throw new DetailsNotAvailableException("No Gym Admin found");
		}
		return gymAdminRepository.findAll();
	}

	/*
	 * @Method: registerAdmin
	 * 
	 * @Description: Register a new Admin
	 * 
	 * @Parameters: AdminDto
	 * 
	 * @Exception:
	 */
	@RequestMapping(value = "/registerAdmin", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public GymAdmin registerAdmin(@RequestBody AdminDto adminDto) {
		logger.info("Register gym Admins" +adminDto.getFirstName());
		return adminBookingFlipFitServiceImpl.registerAdmin(adminDto);
	}

}
