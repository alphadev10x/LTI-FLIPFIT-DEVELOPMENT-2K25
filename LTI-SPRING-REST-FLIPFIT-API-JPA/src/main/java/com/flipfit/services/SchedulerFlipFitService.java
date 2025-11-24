package com.flipfit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.flipfit.entity.GymScheduler;



public interface SchedulerFlipFitService {

	public GymScheduler updateSchedule(Long id, GymScheduler scheduleDeatils);

	public Optional<GymScheduler> getScheduleDetailsById(Long schedulerId);

	public ResponseEntity<Long> checkAvailability(Long scheduleId, Long slotId);

	public GymScheduler saveSchedule(GymScheduler scheduler);

	public List<GymScheduler> getScheduleDetails();

}
