package com.flipfit.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flipfit.entity.GymNotification;
import com.flipfit.entity.GymRole;
import com.flipfit.entity.GymUser;
import com.flipfit.entity.PaymentMode;
import com.flipfit.exception.RegistrationNotDoneException;
import com.flipfit.exception.UserNotFoundException;
import com.flipfit.repository.GymNotificationRepository;
import com.flipfit.repository.GymRoleRepository;
import com.flipfit.repository.GymUserRepository;
import com.flipfit.repository.PaymentModeRepository;
import com.flipfit.services.UserFlipFitServiceImpl;

import jakarta.ws.rs.core.MediaType;

/*
 * @Class: UserFlipFitController
 * @Description: Requests related to user 
 */
@RestController
public class UserFlipFitController {
	private static final Logger logger = LoggerFactory.getLogger(UserFlipFitController.class);

	@Autowired
	private UserFlipFitServiceImpl userFlipFitServiceImpl;


	@Autowired
	private PaymentModeRepository paymentModeRepository;

	@Autowired
	private GymNotificationRepository gymNotificationRepository;

	

	/*
	 * @Method: addUserdetails
	 *
	 * @Description: Create UserDetails
	 *
	 * @MethodParameters: GymRole
	 *
	 * @Exception
	 *
	 */
	@RequestMapping(value = "/addUserDetails", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<GymUser> addUserdetails(@RequestBody GymUser user) {
		logger.info("Adding new user details: {}", user.getUserId());
		GymUser savedUser = userFlipFitServiceImpl.addUserdetails(user);
		logger.debug("User added successfully with ID: {}", savedUser.getUserId());
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	/*
	 * @Method: verifyUserdetails
	 *
	 * @Description: Verify user Details
	 *
	 * @MethodParameters: GymUser
	 *
	 * @Exception
	 */

	@RequestMapping(value = "/verifyUserDetails", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<String> verifyUserdetails(@RequestBody GymUser user) {
		logger.info("Verifying user details for ID: {}", user.getUserId());
		String verifyUser = userFlipFitServiceImpl.verifyUserdetails(user);
		if ("Invalid User".equals(verifyUser)) {
			logger.error("User verification failed for ID: {}", user.getUserId());
			throw new UserNotFoundException("User Not Found " + user.getUserId());
		}
		logger.debug("User verification successful for ID: {}", user.getUserId());
		return new ResponseEntity<>(verifyUser, HttpStatus.OK);
	}

	/*
	 * @Method: addRoledetails
	 *
	 * @Description: Create Role Details
	 *
	 * @MethodParameters: GymRole
	 *
	 * @Exception
	 */

	@RequestMapping(value = "/addRoleDetails", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<GymRole> addRoledetails(@RequestBody GymRole role) {
		logger.info("Adding new role: {}", role.getRoleName());
		GymRole savedRole = userFlipFitServiceImpl.addRoleDetails(role);
		logger.debug("Role added successfully with ID: {}", savedRole.getRoleId());
		return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
	}
	
	/*
	 * @Method: addPaymentMode
	 *
	 * @Description: Add payment Modes
	 *
	 * @MethodParameters: PaymentMode
	 *
	 * @Exception
	 */

	@RequestMapping(value = "/addPaymentMode", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<PaymentMode> addPaymentMode(@RequestBody PaymentMode paymentMode) {
		logger.info("Adding new payment mode: {}", paymentMode.getModeOfPayment());
		PaymentMode paymentModes = paymentModeRepository.save(paymentMode);
		logger.debug("Payment mode added successfully with ID: {}", paymentModes.getModeOfPayment());
		return new ResponseEntity<>(paymentModes, HttpStatus.CREATED);
	}

	/*
	 * @Method: getCustomerDetails
	 * 
	 * @Description: Fetch all Notification details
	 * 
	 * @Parameters: None
	 * 
	 * @Exception: RegistrationNotDoneException if no customers found
	 */

	@RequestMapping(value = "/getAllNotifications", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<GymNotification> getAllNotifications() {
		logger.info("Fetching all notifications");
		List<GymNotification> notifications = gymNotificationRepository.findAll();
		if (notifications.isEmpty()) {
			logger.warn("No notifications found");
			throw new RegistrationNotDoneException("No Notification found");
		}
		logger.debug("Total notifications fetched: {}", notifications.size());
		return notifications;
	}
}