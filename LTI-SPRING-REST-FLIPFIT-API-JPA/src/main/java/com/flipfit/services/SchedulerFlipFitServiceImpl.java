package com.flipfit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flipfit.entity.GymScheduler;


/*
 * Author: GroupAlpha
 * Version: v0.1
 * Description: Flip Fit Scheduler Service Implementation 
 */
@Service
public class SchedulerFlipFitServiceImpl implements SchedulerFlipFitService{
	
	private final AtomicLong counter = new AtomicLong();
	private final List<GymScheduler> scheduler = new ArrayList<>();
	private static final Logger logger = LoggerFactory.getLogger(SchedulerFlipFitServiceImpl.class);
	
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
		schedule.setScheduleId(counter.incrementAndGet());
		scheduler.add(schedule);
		logger.info("Successfully created Schedule for "+ schedule.getScheduleId());
		return schedule;
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
		GymScheduler schedule = getScheduleDetailsById(id).get();
		schedule.setSchedulerDate(scheduleDeatils.getSchedulerDate());
		logger.info("Successfully updated Schedule for "+ schedule.getScheduleId());
		return schedule;
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
		return scheduler;
	}
	
	/*
	 * @Method: Override checkAvailability
	 * 
	 * @Description: check the schedule availability
	 * 
	 * @Parameters: scheduleId of type Long, slotId of type Long
	 * 
	 * @Exception: None
	 */
	@Override
	public ResponseEntity<Long> checkAvailability(Long scheduleId, Long slotId) {
//		Scheduler schedule =  scheduler.stream().filter(s -> s.getScheduleId().equals(scheduleId)).findFirst().get();
//		return new ResponseEntity<Long>(schedule.getScheduleId(), HttpStatus.OK);
		return null;
		
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
		return scheduler.stream().filter(s -> s.getScheduleId().equals(schedulerId)).findFirst();
	}

}
