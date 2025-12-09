package com.flipfit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import com.flipfit.repository.GymSlotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flipfit.dao.SchedulerResponse;
import com.flipfit.entity.GymScheduler;
import com.flipfit.exception.ScheduleNotFoundException;
import com.flipfit.repository.GymSchedulerRepository;


/*
 * Author: GroupAlpha
 * Version: v0.1
 * Description: Flip Fit Scheduler Service Implementation 
 */
@Service
public class SchedulerFlipFitServiceImpl implements SchedulerFlipFitService{

    private final GymSlotRepository gymSlotRepository;
	
	
	@Autowired
	private final GymSchedulerRepository gymSchedulerRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(SchedulerFlipFitServiceImpl.class);

    SchedulerFlipFitServiceImpl(GymSchedulerRepository gymSchedulerRepository, GymSlotRepository gymSlotRepository) {
    	this.gymSchedulerRepository = gymSchedulerRepository;
        this.gymSlotRepository = gymSlotRepository;
    }
	
	/*
	 * @Method: Override saveSchedule
	 * 
	 * @Description: save a schedule
	 * 
	 * @Parameters: scheduler of type Scheduler
	 * 
	 * @Exception: None
	 */
	@Override
	public GymScheduler saveSchedule(GymScheduler schedule) {
		GymScheduler scheduler = gymSchedulerRepository.save(schedule);
		logger.info("Successfully created Schedule for "+ scheduler.getScheduleId());
		return scheduler;
	}
	
	/*
	 * @Method: Override updateSchedule by Id
	 * 
	 * @Description: update the schedule
	 * 
	 * @Parameters: schedulerDetails of type Scheduler, id of type Long
	 * 
	 * @Exception: None
	 */
	@Override
	public GymScheduler updateSchedule(Long id, GymScheduler scheduleDeatils) {
		
		int updated = gymSchedulerRepository.updateScheduler(id, scheduleDeatils.getSchedulerDate(), scheduleDeatils.getSlotId(), scheduleDeatils.getBookingId());
		
		if (updated == 0) {
			throw new ScheduleNotFoundException("Schedule not found");
		}		
		
		logger.info("Successfully updated Schedule for " + id);
		return scheduleDeatils;
	}
	
	/*
	 * @Method: Override getScheduleDetails
	 * 
	 * @Description: get schedule Details
	 * 
	 * @Parameters: None
	 * 
	 * @Exception: None
	 */
	@Override

	public List<GymScheduler> getScheduleDetails() {
		logger.info("All schedule details");
		if (gymSchedulerRepository.findAll().isEmpty()) {
			logger.warn("Scheduler is empty");
			throw new ScheduleNotFoundException("Scheduler not found");
		}
		return gymSchedulerRepository.findAll();
	}
	
	
	
	
	/*
	 * @Method: Override getScheduleDetailsById
	 * 
	 * @Description: get schedule details by id
	 * 
	 * @Parameters: schedulerId of type Long
	 * 
	 * @Exception: None
	 */
	@Override
	public Optional<GymScheduler> getScheduleDetailsById(Long schedulerId) {
		logger.info("All schedule details by ID: " + schedulerId);
		if (!gymSchedulerRepository.findById(schedulerId).isPresent()) {
			logger.warn("Scheduler not found");
			throw new ScheduleNotFoundException("Scheduler not found");
		}
		return gymSchedulerRepository.findAll().stream().filter(s -> s.getScheduleId().equals(schedulerId)).findFirst();
	}
	
	@Override
	public ResponseEntity<SchedulerResponse> getScheduleDetailsByUserId(Long userId) {
		logger.info("All schedule details by ID: " + userId);
		GymScheduler userScheduleDetails = gymSchedulerRepository.findByUserId(userId).get();
		if (userScheduleDetails == null) {
			logger.warn("Scheduler not found");
			throw new ScheduleNotFoundException("Scheduler not found");
		}
		
		SchedulerResponse response = new SchedulerResponse(
				gymSchedulerRepository.getFirstName(userId)+" "+gymSchedulerRepository.getLastName(userId),
				userScheduleDetails.getBookingId(),
				gymSchedulerRepository.getSlotName(userScheduleDetails.getBookingId()),
				gymSchedulerRepository.getCenterName(userScheduleDetails.getBookingId()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
