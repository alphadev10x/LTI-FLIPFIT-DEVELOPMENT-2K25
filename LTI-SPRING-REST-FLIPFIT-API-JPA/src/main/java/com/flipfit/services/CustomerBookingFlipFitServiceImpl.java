/**
 * 
 */
package com.flipfit.services;

import java.time.LocalDateTime;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipfit.dao.CustomerDto;
import com.flipfit.entity.GymCustomer;
import com.flipfit.entity.GymNotification;
import com.flipfit.entity.GymUser;
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
	private GymNotificationRepository gymNotificationRepository;
	
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
		GymUser user = new GymUser();
    	user.setCreationDate(LocalDateTime.now());
    	user.setEmail(customerDto.getEmail());
    	user.setPassword(customerDto.getPassword());
    	user.setRoleId(customerDto.getRoleId());
    	GymUser user1 =gymUserRepository.save(user);
    	GymCustomer customer = new GymCustomer();
    	customer.setCardDetails(customerDto.getCardDetails());
    	customer.setFirstName(customerDto.getFirstName());
    	customer.setGender(customerDto.getGender());
    	customer.setLastName(customerDto.getLastName());
    	customer.setPhoneNumber(customerDto.getPhoneNumber());
    	customer.setUserId(user1.getUserId());
    	GymCustomer registeredCustomer =gymCustomerRepository.save(customer);
    	if(Objects.nonNull(registeredCustomer)) {
    		GymNotification gymNotification = new GymNotification();
    		gymNotification.setMessage("Customer Registration" + customer.getFirstName());
    		gymNotification.setNotificationStatus("Successfully Registered");
    		gymNotificationRepository.save(gymNotification);
    	}
    	
        return registeredCustomer;
		
	}

	

}
