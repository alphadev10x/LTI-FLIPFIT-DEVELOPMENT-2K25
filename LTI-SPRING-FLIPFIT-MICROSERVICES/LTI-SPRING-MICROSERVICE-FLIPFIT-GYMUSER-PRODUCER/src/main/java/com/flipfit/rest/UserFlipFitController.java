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

import com.flipfit.dao.LoginDto;
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

import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;

/*
 * @Class: UserFlipFitController
 * @Description: Requests related to user 
 */
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/user")
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
	public ResponseEntity<GymUser> addUserdetails(@Valid @RequestBody GymUser user) {
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

	@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) {
		logger.info("Check user for email: {}", loginDto.getEmail());
		String verifyUser = userFlipFitServiceImpl.loginUser(loginDto.getEmail(), loginDto.getPassword());
		if ("Valid User".equals(verifyUser)) {
			logger.debug("User verification successful for ID: {}", loginDto.getEmail());
			return new ResponseEntity<>(verifyUser, HttpStatus.OK);
		} else {
			logger.error("User verification failed for ID: {}", loginDto.getEmail());
			throw new UserNotFoundException("User Not Found " + loginDto.getEmail());			
		}
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
	public ResponseEntity<GymRole> addRoledetails(@Valid @RequestBody GymRole role) {
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
	
	@RequestMapping(value = "/getUserDetails/{userid}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public GymUser getUserdetails(@PathVariable Long userid) {
		logger.info("get User details: {}", userid);
		return userFlipFitServiceImpl.getUserdetails(userid);
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
	@RequestMapping(value = "/getRoleDetails/{roleid}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public GymRole getRoledetails(@PathVariable Long roleid) {
		logger.debug("Get Role details with ID: {}", roleid);
		return userFlipFitServiceImpl.getRoledetails(roleid);
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
	
	@RequestMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<GymUser> getAllUsers() {
	
		return userFlipFitServiceImpl.getAllUsers();
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
	
	@RequestMapping(value = "/getAllRoles", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<GymRole> getAllRoles() {
	
		return userFlipFitServiceImpl.getAllRoles();
	}
	
	
	@RequestMapping(value = "/getUserDetailsByEmail/{email}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public GymUser getUserdetailsByEmail(@PathVariable String email) {
		logger.info("get User details: {}", email);
		return userFlipFitServiceImpl.getUserDetailsByEmail(email);
	}
}