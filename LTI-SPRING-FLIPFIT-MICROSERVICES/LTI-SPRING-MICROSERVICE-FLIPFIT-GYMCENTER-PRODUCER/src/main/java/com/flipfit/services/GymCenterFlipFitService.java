package com.flipfit.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.flipfit.dao.CenterDto;
import com.flipfit.dao.GymCenterResponse;
import com.flipfit.entity.GymCenter;

public interface GymCenterFlipFitService {

	public List<GymCenter> findCenterByOwnerId(Long ownerId);

	public GymCenterResponse registerCenter(CenterDto centerDto);

	public List<GymCenter> getCentersByCity(String city);

	public List<GymCenter> getCentersByOwnerId(Long gymOwnerId);

	public List<GymCenter> getAllCenters();
	
	public GymCenter getCenterById( Long id);
	
	public GymCenter updateCenter(Long id ,GymCenter centerDetails);
}
