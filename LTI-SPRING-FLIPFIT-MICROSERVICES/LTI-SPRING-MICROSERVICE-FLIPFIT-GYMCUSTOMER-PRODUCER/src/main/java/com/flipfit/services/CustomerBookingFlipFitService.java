package com.flipfit.services;

import java.util.List;



import com.flipfit.dao.CustomerDto;
import com.flipfit.entity.GymCustomer;



public interface CustomerBookingFlipFitService {
	

	public GymCustomer registerUser(CustomerDto customer);
	
	public List<GymCustomer> getCustomerDetails() ;
	
	 public GymCustomer getCustomerById(Long id);
	 
	 public GymCustomer updateCustomer(Long id,  GymCustomer customerDetails);
	
	

	
}
