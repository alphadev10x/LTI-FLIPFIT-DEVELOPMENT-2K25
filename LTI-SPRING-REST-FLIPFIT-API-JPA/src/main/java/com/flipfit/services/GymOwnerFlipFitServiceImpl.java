/**
 * 
 */
package com.flipfit.services;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipfit.dao.OwnerDto;
import com.flipfit.entity.GymNotification;
import com.flipfit.entity.GymOwner;
import com.flipfit.entity.GymUser;
import com.flipfit.exception.RegistrationNotDoneException;
import com.flipfit.repository.GymNotificationRepository;
import com.flipfit.repository.GymOwnerRepository;
import com.flipfit.repository.GymUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * 
 */
@Service
public class GymOwnerFlipFitServiceImpl implements GymOwnerFlipFitService {
	private static final Logger logger = LoggerFactory.getLogger(GymOwnerFlipFitService.class);
	
	@Autowired
	private GymOwnerRepository gymOwnerRepository;
	
	@Autowired
	private GymNotificationRepository gymNotificationRepository;
	
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
	@Override
	public GymOwner registerUser(OwnerDto ownerDto) {
		logger.info("Register owner Details" +ownerDto);
		GymUser user = new GymUser();
    	user.setCreationDate(LocalDateTime.now());
    	user.setEmail(ownerDto.getEmail());
    	user.setPassword(ownerDto.getPassword());
    	user.setRoleId(ownerDto.getRoleId());
    	GymUser user1 =gymUserRepository.save(user);
    	GymOwner existingOwner = new GymOwner();
    	existingOwner.setApproved(ownerDto.isApproved());
		existingOwner.setBusinessName(ownerDto.getBusinessName());
		existingOwner.setCardNumber(ownerDto.getCardNumber());
		existingOwner.setFirstName(ownerDto.getFirstName());
		existingOwner.setLastName(ownerDto.getLastName());
		existingOwner.setGSTIN(ownerDto.getGSTIN());
		existingOwner.setPANCard(ownerDto.getPanCard());
		existingOwner.setUserId(user1.getUserId());
		GymOwner registerGymOwner = gymOwnerRepository.save(existingOwner);
		if(Objects.isNull(registerGymOwner)) {
			throw new RegistrationNotDoneException("GymOwner Registration Failed");
		}
		if(Objects.nonNull(registerGymOwner)) {
    		GymNotification gymNotification = new GymNotification();
    		gymNotification.setMessage("Gymowner Registration" + existingOwner.getFirstName());
    		gymNotification.setNotificationStatus("Successfully Registered");
    		gymNotificationRepository.save(gymNotification);
    	}
		
		return registerGymOwner;
	}

	

	

	

}
