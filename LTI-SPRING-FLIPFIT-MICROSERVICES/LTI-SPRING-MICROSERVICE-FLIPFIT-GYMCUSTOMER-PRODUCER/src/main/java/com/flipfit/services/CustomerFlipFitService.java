package com.flipfit.services;

import java.util.List;

import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymCustomer;
import com.flipfit.entity.GymSlot;

public interface CustomerFlipFitService {

	public GymCustomer register(String name, String email, String phone, String password);

	public GymCustomer login(String email, String password);
	
	public List<GymCustomer> getAll();

	public GymCustomer getById(Long id);
	
	public List<GymCenter> getAllApprovedCenters();
	
	public List<GymSlot> getSlotsByCenter(Long centerId);

}
