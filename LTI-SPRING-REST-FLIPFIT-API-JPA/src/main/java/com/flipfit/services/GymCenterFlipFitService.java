package com.flipfit.services;

import java.util.List;

import com.flipfit.dao.CenterDto;
import com.flipfit.dao.GymCenterReponse;
import com.flipfit.entity.GymCenter;



public interface GymCenterFlipFitService {
	
	
	List<GymCenter> findCenterByOwnerId(Long ownerId);
	
	GymCenterReponse registerCenter( CenterDto centerDto) ;
}
