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

import com.flipfit.dao.CustomerDto;
import com.flipfit.entity.CardDetails;
import com.flipfit.entity.GymCustomer;
import com.flipfit.entity.GymNotification;
import com.flipfit.entity.GymUser;
import com.flipfit.exception.RegistrationNotDoneException;
import com.flipfit.feignclient.NotificationClient;
import com.flipfit.feignclient.UserClient;
import com.flipfit.repository.CardDetailsRepository;
import com.flipfit.repository.GymCustomerRepository;
import com.flipfit.repository.GymNotificationRepository;
import com.flipfit.repository.GymUserRepository;



/*
 * Customer Service for Customer related responsibility
 */
@Service
public class CustomerBookingFlipFitServiceImpl implements CustomerBookingFlipFitService{
	
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerBookingFlipFitServiceImpl.class);	
	@Autowired
	private GymCustomerRepository gymCustomerRepository;
	
	
	@Autowired
	private CardDetailsRepository cardDetailsRepository;
	
	@Autowired
	 private  NotificationClient notificationClient;
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private GymNotificationRepository notificationRepository;
	
	@Autowired
	private GymUserRepository gymUserRepository;
	
	

	/*
     * @Method: registerCustomer
     * @Description: Register a new customer
     * @Parameters: GymCustomer
     * @Exception: RegistrationNotDoneException if registration fails
     */

	@Override
	public GymCustomer registerUser(CustomerDto customerDto) {
		logger.info("Register a new customer");

		GymUser user1 = saveUser(customerDto);
		GymCustomer registeredCustomer = saveCustomerDetails(customerDto, user1);
		//saveCardDetails(customerDto, user1);
		if (Objects.nonNull(registeredCustomer)) {
			saveNotification(customerDto);
		}

		return registeredCustomer;

	}

	 /*
     * @Method: getCustomerDetails
     * @Description: Fetch all customer details
     * @Parameters: None
     * @Exception: RegistrationNotDoneException if no customers found
     */
	@Override
	public List<GymCustomer> getCustomerDetails() {
		return gymCustomerRepository.findAll();
		
	}

	/*
     * @Method: getCustomerById
     * @Description: Fetch customer details by ID
     * @Parameters: id
     * @Exception: RegistrationNotDoneException if customer not found
     */

	@Override
	public GymCustomer getCustomerById(Long id) {
		return gymCustomerRepository.findById(id)
        .orElseThrow(() -> new RegistrationNotDoneException("Customer not found"));
	}


	@Override
	@CachePut(value = "myCache", key = "#id")
	public GymCustomer updateCustomer(Long id, GymCustomer customerDetails) {
		GymCustomer existingCustomer = gymCustomerRepository.findById(id)
				.orElseThrow(() -> new RegistrationNotDoneException("Customer not found"));
		existingCustomer.setFirstName(customerDetails.getFirstName());
		existingCustomer.setLastName(customerDetails.getLastName());
		existingCustomer.setGender(customerDetails.getGender());
		existingCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
		logger.info("Update customer for id" + id);
		return gymCustomerRepository.save(existingCustomer);
	}
	
	public GymUser saveUser(CustomerDto customerDto) {
		GymUser user = new GymUser();
		user.setCreationDate(LocalDateTime.now());
		user.setEmail(customerDto.getEmail());
		user.setPassword(customerDto.getPassword());
		user.setRoleId(2L);
		return gymUserRepository.save(user);
		//return userClient.addUserdetails(user);
		
	}
	
	public void saveNotification(CustomerDto customerDto) {
		GymNotification gymNotification = new GymNotification();
		gymNotification.setMessage("Customer Registration" + customerDto.getFirstName());
		gymNotification.setNotificationStatus("Successfully Registered");
		notificationRepository.save(gymNotification);
		//notificationClient.sendNotification(gymNotification);
	}
	
	/*
	 * public void saveCardDetails(CustomerDto customerDto ,GymUser user) {
	 * CardDetails cardDetails = new CardDetails();
	 * cardDetails.setCardName(customerDto.getCardDetails().getCardName());
	 * cardDetails.setCardNumber(customerDto.getCardDetails().getCardNumber());
	 * cardDetails.setCvv(customerDto.getCardDetails().getCvv());
	 * cardDetails.setUserId(user.getUserId());
	 * cardDetails.setCardId(customerDto.getCardDetails().getCardId());
	 * cardDetailsRepository.save(cardDetails); }
	 */
	
	public GymCustomer saveCustomerDetails(CustomerDto customerDto,GymUser user) {
		GymCustomer customer = new GymCustomer();
    	customer.setFirstName(customerDto.getFirstName());
    	customer.setGender(customerDto.getGender());
    	customer.setLastName(customerDto.getLastName());
    	customer.setPhoneNumber(customerDto.getPhoneNumber());
    	customer.setUserId(user.getUserId());
    	return gymCustomerRepository.save(customer);
		
	}

	

}
