/**
 * 
 */
package com.flipfit.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.flipfit.dao.OwnerDto;
import com.flipfit.entity.GymNotification;
import com.flipfit.entity.GymOwner;
import com.flipfit.entity.GymUser;
import com.flipfit.exception.DetailsNotAvailableException;
import com.flipfit.exception.RegistrationNotDoneException;
import com.flipfit.exception.UserNotFoundException;
import com.flipfit.feignclient.NotificationClient;
import com.flipfit.feignclient.UserClient;
import com.flipfit.repository.GymNotificationRepository;
import com.flipfit.repository.GymOwnerRepository;
import com.flipfit.repository.GymUserRepository;

import feign.FeignException.FeignClientException;




/**
 * 
 */
@Service
public class GymOwnerFlipFitServiceImpl implements GymOwnerFlipFitService {
	private static final Logger logger = LoggerFactory.getLogger(GymOwnerFlipFitService.class);
	
	@Autowired
	private GymOwnerRepository gymOwnerRepository;
	
	@Autowired
	 private  NotificationClient notificationClient;
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private GymNotificationRepository notificationRepository;
	
	@Autowired
	private GymUserRepository gymUserRepository;
	
	
	
	
	/*
	 * @Method: registerUser
	 * 
	 * @Description: Register owner Details
	 * 
	 * @MethodParameters: OwnerDto
	 * 
	 * @Exception RegistrationNotDoneException
	 */
	@Transactional
	@Override
	public GymOwner registerUser(OwnerDto ownerDto) {
		logger.info("Register owner Details" +ownerDto);
    	GymUser user1 =saveUser( ownerDto);
    	
		GymOwner registerGymOwner =saveGymOwnerDetails(ownerDto ,user1);
		if(Objects.isNull(registerGymOwner)) {
			throw new RegistrationNotDoneException("GymOwner Registration Failed");
		}
		if(Objects.nonNull(registerGymOwner)) {
			saveNotification(ownerDto);
    	}
		
		return registerGymOwner;
	}
	
	@Override
	public GymOwner getOwnerDetails(Long ownerId) {
		GymOwner owner = gymOwnerRepository.findById(ownerId).get();
		if(owner == null) {
			throw new DetailsNotAvailableException("Gym Owner not found");
		}
		return owner;
	}
	
	@Override
	public List<GymOwner> getAllOwners() {
		logger.info("Get All Gym Owners");
        if (gymOwnerRepository.findAll().isEmpty()) {
        	logger.warn("No gym owner found");
            throw new DetailsNotAvailableException("No Gym Owner found");
        }
        return gymOwnerRepository.findAll();
    }

	
	 /*
     * @Method: updateCenter
     * @Description: Update gym center details
     * @Parameters: id, GymCenter
     * @Exception: DetailsNotAvailableException if center not found
     */
	@Override
	public GymOwner updateGymOwner(Long id, GymOwner ownerDetails) {
		GymOwner existingOwner = gymOwnerRepository.findById(id)
				.orElseThrow(() -> new DetailsNotAvailableException("Gym Owner not found"));
		existingOwner.setApproved(ownerDetails.isApproved());
		existingOwner.setBusinessName(ownerDetails.getBusinessName());
		existingOwner.setCardNumber(ownerDetails.getCardNumber());
		existingOwner.setFirstName(ownerDetails.getFirstName());
		existingOwner.setGSTIN(ownerDetails.getGSTIN());
		existingOwner.setPANCard(ownerDetails.getPANCard());
		logger.info("Gym onwer details updated");
		return gymOwnerRepository.save(existingOwner);
	}
	
	public GymOwner saveGymOwnerDetails(OwnerDto ownerDto ,GymUser user) {
		GymOwner existingOwner = new GymOwner();
    	existingOwner.setApproved(false);
		existingOwner.setBusinessName(ownerDto.getBusinessName());
		existingOwner.setCardNumber(ownerDto.getCardNumber());
		existingOwner.setFirstName(ownerDto.getFirstName());
		existingOwner.setLastName(ownerDto.getLastName());
		existingOwner.setGSTIN(ownerDto.getGstin());
		existingOwner.setPANCard(ownerDto.getPancard());
		existingOwner.setUserId(user.getUserId());
		GymOwner registerGymOwner = gymOwnerRepository.save(existingOwner);
		return registerGymOwner;
		
	}
	
	public GymUser saveUser(OwnerDto ownerDto) {
		GymUser user = new GymUser();
		user.setCreationDate(LocalDateTime.now());
		user.setEmail(ownerDto.getEmail());
		user.setPassword(ownerDto.getPassword());
		user.setRoleId(3L);
		
		// GymUser user1 = userClient.addUserdetails(user);
		
		return gymUserRepository.save(user);
		
	}
	
	public void saveNotification(OwnerDto ownerDto) {
		GymNotification gymNotification = new GymNotification();
		gymNotification.setMessage("GymOwner Registration" );
		gymNotification.setNotificationStatus("Successfully Registered");
		notificationRepository.save(gymNotification);
		//notificationClient.sendNotification(gymNotification);
	}
}