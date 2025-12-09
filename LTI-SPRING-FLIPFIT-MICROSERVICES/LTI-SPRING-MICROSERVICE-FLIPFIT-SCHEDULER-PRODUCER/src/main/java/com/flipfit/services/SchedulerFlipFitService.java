package com.flipfit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.flipfit.dao.SchedulerResponse;
import com.flipfit.entity.GymScheduler;



public interface SchedulerFlipFitService {

	public GymScheduler updateSchedule(Long id, GymScheduler scheduleDeatils);

	public Optional<GymScheduler> getScheduleDetailsById(Long schedulerId);

	public GymScheduler saveSchedule(GymScheduler scheduler);

	public List<GymScheduler> getScheduleDetails();
	
	public ResponseEntity<SchedulerResponse> getScheduleDetailsByUserId(Long userId);

}
