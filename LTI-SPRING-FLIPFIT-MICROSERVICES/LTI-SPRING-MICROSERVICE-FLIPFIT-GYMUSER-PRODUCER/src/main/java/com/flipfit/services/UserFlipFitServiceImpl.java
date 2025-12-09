package com.flipfit.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
		logger.info("Adding new user details:");
		Boolean existEmail = gymUserRepository.existsByEmail(user.getEmail());
		if (existEmail) {
			throw new UserNotFoundException("Email already exist");
		}
		GymUser savedUser = gymUserRepository.save(user);
		logger.debug("User added successfully with ID: {}", savedUser.getUserId());
		return savedUser;
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

	/**
	 * @Method: loginUser
	 * @Description: Verify user credentials and details.
	 * @Parameters: user - email,password login details.
	 * @Return: String - Verification status ("Valid User" or "Invalid User").
	 * @Exception: Throws UserNotFoundException if user is not found.
	 */

	@Override
	public String loginUser(String email, String password) {
		logger.info("Check user for email: {}", email);
		Optional<GymUser> user = gymUserRepository.findByEmailAndPassword(email, password);
		if (user.isPresent()) {
			logger.debug("User verification successful for Email Address: {}", email);
			return "Valid User";
		} else {
			logger.error("User verification failed for Email Address: {}", email);
			throw new UserNotFoundException("User verification failed for Email Address:" + email);
		}
	}

	/*
	 * @Method: getUserdetails
	 *
	 * @Description: get UserDetails
	 *
	 * @MethodParameters: userid of type Long
	 *
	 * @Exception
	 *
	 */

	@Override
	public GymUser getUserdetails(Long userid) {
		logger.info("get User details: {}", userid);
		Optional<GymUser> user = gymUserRepository.findById(userid);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new UserNotFoundException("User Not Found");
		}

	}

	/*
	 * @Method: getRoledetails
	 *
	 * @Description: Get Role Details
	 *
	 * @MethodParameters: Long
	 *
	 * @Exception
	 */

	@Override
	@Cacheable(value = "roleCache", key = "#roleid")
	public GymRole getRoledetails(Long roleid) {
		logger.debug("Get Role details with ID: {}", roleid);
		Optional<GymRole> role = gymRoleRepository.findById(roleid);
		if (role.isPresent()) {
			return role.get();
		} else {
			throw new UserNotFoundException("Role Not Found");
		}

	}

	/*
	 * @Method: getAllUsers
	 *
	 * @Description: get Users
	 *
	 * @MethodParameters: No-Args
	 *
	 * @Exception
	 *
	 */

	@Override
	public List<GymUser> getAllUsers() {
		logger.info("get All User details");
		return gymUserRepository.findAll();
	}

	/*
	 * @Method: getAllRoles
	 *
	 * @Description: get Roles
	 *
	 * @MethodParameters: No-Args
	 *
	 * @Exception
	 *
	 */

	@Override
	public List<GymRole> getAllRoles() {
		logger.info("get All Role details");
		return gymRoleRepository.findAll();
	}

	@Override
	public GymUser getUserDetailsByEmail(String email) {
		GymUser user = gymUserRepository.findByEmail(email).get();

		return user;
	}
}
