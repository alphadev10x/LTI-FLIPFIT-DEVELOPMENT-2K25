package com.flipfit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import jakarta.ws.rs.core.MediaType;

import com.flipfit.dao.CustomerDto;
import com.flipfit.entity.GymCustomer;
import com.flipfit.exception.RegistrationNotDoneException;
import com.flipfit.repository.GymCustomerRepository;
import com.flipfit.services.CustomerBookingFlipFitServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Customer Controller for Customer related responsibility
 */
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/customer")
public class CustomerFlipFitController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerFlipFitController.class);
	
	@Autowired
	private GymCustomerRepository gymCustomerRepository;
	
	@Autowired
	private CustomerBookingFlipFitServiceImpl customerBookingFlipFitServiceImpl;
	

	

    /*
     * @Method: getCustomerDetails
     * @Description: Fetch all customer details
     * @Parameters: None
     * @Exception: RegistrationNotDoneException if no customers found
     */
	@RequestMapping(value = "/getAllCustomerDetails", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
    public List<GymCustomer> getCustomerDetails() {
		logger.info("Fetch all customer detail");
        if (customerBookingFlipFitServiceImpl.getCustomerDetails().isEmpty()) {
            throw new RegistrationNotDoneException("No customers found");
        }
        return gymCustomerRepository.findAll();
    }

    
    
    /*
     * @Method: registerCustomer
     * @Description: Register a new customer
     * @Parameters: GymCustomer
     * @Exception: RegistrationNotDoneException if registration fails
     */
	@RequestMapping(value = "/registerCustomer", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
    public GymCustomer registerCustomers(@RequestBody CustomerDto customerDto) {
		logger.info("Register a new customer");
        return customerBookingFlipFitServiceImpl.registerUser(customerDto);
    }


    /*
     * @Method: updateCustomer
     * @Description: Update customer details
     * @Parameters: id, GymCustomer
     * @Exception: RegistrationNotDoneException if customer not found
     */
	@RequestMapping(value = "/updateCustomer/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public GymCustomer updateCustomer(@PathVariable Long id, @RequestBody GymCustomer customerDetails) {
		logger.info("Update customer for id" + id);
		return customerBookingFlipFitServiceImpl.updateCustomer(id, customerDetails);
    	
    }
    /*
     * @Method: getCustomerById
     * @Description: Fetch customer details by ID
     * @Parameters: id
     * @Exception: RegistrationNotDoneException if customer not found
     */
	@RequestMapping(value ="/getCustomer/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
    public GymCustomer getCustomerById(@PathVariable Long id) {
		logger.info(" Fetch customer details by ID");
        return customerBookingFlipFitServiceImpl.getCustomerById(id);
	}

    /*
     * @Method: deleteCustomer
     * @Description: Delete customer by ID
     * @Parameters: id
     * @Exception: RegistrationNotDoneException if customer not found
     */
	@RequestMapping(value ="/deleteCustomer/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable Long id) {
		logger.info("Delete customer by ID");
        if (gymCustomerRepository.existsById(id)) {
            gymCustomerRepository.deleteById(id);
            return "Customer deleted successfully!";
        } else {
            throw new RegistrationNotDoneException("Customer not found");
        }
    }
}
