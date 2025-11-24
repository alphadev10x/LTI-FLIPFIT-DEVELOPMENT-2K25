package com.flipfit.services;
 
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipfit.entity.GymRole;
import com.flipfit.entity.GymUser;
import com.flipfit.exception.UserNotFoundException;
import com.flipfit.repository.GymRoleRepository;
import com.flipfit.repository.GymUserRepository;

/*
 * @Class: UserFlipFitServiceImpl
 * @Description: Requests related to User 
 */
@Service
public class UserFlipFitServiceImpl implements UserFlipFitService {
	private static final Logger logger = LoggerFactory.getLogger(UserFlipFitServiceImpl.class);
 
	@Autowired
	GymRoleRepository gymRoleRepository;
 
	@Autowired
	GymUserRepository gymUserRepository;
 
/**
     * @Method: addUserdetails
     * @Description: Create and save user details in the system.
     * @Parameters: user - GymUser object containing user details.
     * @Return: GymUser - The saved user entity.
     * @Exception: Throws exception if user details are invalid or cannot be saved.
     */
 
	@Override
	public GymUser addUserdetails(GymUser user) {
 
       logger.info("Adding new user details: {}", user.getUserId());
        GymUser savedUser = gymUserRepository.save(user);
        logger.debug("User added successfully with ID: {}", savedUser.getUserId());
        return savedUser;
    }
 
	 /**
	     * @Method: verifyUserdetails
	     * @Description: Verify user credentials and details.
	     * @Parameters: user - GymUser object containing login details.
	     * @Return: String - Verification status ("Valid User" or "Invalid User").
	     * @Exception: Throws UserNotFoundException if user is not found.
	     */
 
	@Override
    public String verifyUserdetails(GymUser user) {
        logger.info("Verifying user details for ID: {}", user.getUserId());
        Optional<GymUser> verifyUser = gymUserRepository.findById(user.getUserId());
        if (verifyUser.isPresent()) {
            logger.debug("User verification successful for ID: {}", user.getUserId());
            return "Valid User";
        } else {
            logger.error("User verification failed for ID: {}", user.getUserId());
            throw new UserNotFoundException("User Not Found " + user.getUserId());
        }
    }
 
/**
     * @Method: addRoleDetails
     * @Description: Create and save role details in the system.
     * @Parameters: role - GymRole object containing role details.
     * @Return: GymRole - The saved role entity.
     * @Exception: Throws exception if role details are invalid or cannot be saved.
     */
    public GymRole addRoleDetails(GymRole role) {
        logger.info("Adding new role: {}", role.getRoleName());
        GymRole savedRole = gymRoleRepository.save(role);
        logger.debug("Role added successfully with ID: {}", savedRole.getRoleId());
        return savedRole;
    }
}
 
	
 
	
 
 