package com.flipfit.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flipfit.entity.GymScheduler;
import com.flipfit.entity.GymSlot;
import com.flipfit.exception.ScheduleNotFoundException;
import com.flipfit.repository.GymSchedulerRepository;
import com.flipfit.repository.GymSlotRepository;
import com.flipfit.services.SchedulerFlipFitServiceImpl;

import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Author: GroupAlpha
 * Version: v0.1
 * Description: Flip Fit Scheduler Controller 
 */
@RestController
public class SchedulerFlipFitController {

	@Autowired
	private GymSchedulerRepository gymSchedulerRepository;

	@Autowired
	private GymSlotRepository gymSlotRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(SchedulerFlipFitServiceImpl.class);
	

	public SchedulerFlipFitController(GymSchedulerRepository gymSchedulerRepository) {
		this.gymSchedulerRepository = gymSchedulerRepository;
	}

	/*
	 * @Method: createSchedule
	 * 
	 * @Description: creating a schedule
	 * 
	 * @Parameters: scheduler of type Scheduler
	 * 
	 * @Exception: None
	 */
	@RequestMapping(value = "createSchedule", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public GymScheduler createSchedule(@RequestBody GymScheduler scheduler) {
		GymScheduler newSchedule = gymSchedulerRepository.save(scheduler);
		logger.info("Successfully created Schedule for "+ scheduler.getScheduleId());
		return newSchedule;
	}

	/*
	 * @Method: updateSchedule
	 * 
	 * @Description: updating schedule
	 * 
	 * @Parameters: GymScheduler
	 * 
	 * @Exception: ScheduleNotfoundException
	 */
	@RequestMapping(value = "updateSchedule/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public GymScheduler updateSchedule(@PathVariable Long id, @RequestBody GymScheduler scheduleDeails) {
		if (!gymSchedulerRepository.existsById(id)) {
			throw new ScheduleNotFoundException("Schedule not found");
		}
		GymScheduler existing = gymSchedulerRepository.findById(id).get();
		existing.setSchedulerDate(scheduleDeails.getSchedulerDate());
		gymSchedulerRepository.save(existing);
		logger.info("Successfully updated Schedule for "+ existing.getScheduleId());
		return existing;
	}

	/*
	 * @Method: getScheduleDetails
	 * 
	 * @Description: Fetch Schedule Details
	 * 
	 * @Parameters: schedulerId
	 * 
	 * @Exception: ScheduleNotFoundException
	 */
	@RequestMapping(value = "getScheduleDetails", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<GymScheduler> getScheduleDetails() {
		if (gymSchedulerRepository.findAll().isEmpty()) {
			logger.warn("Scheduler is empty");
			throw new ScheduleNotFoundException("Scheduler not found");
		}
		logger.info("All schedule details");
		return gymSchedulerRepository.findAll();
	}

	/*
	 * @Method: addSlot
	 *
	 * @Description: adding a slot
	 *
	 * @Parameters: slot of type GymSlot
	 *
	 * @Exception: None
	 */
	@RequestMapping(value = "addSlot", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public GymSlot addSlot(@RequestBody GymSlot gymSlot) {
		GymSlot slot = gymSlotRepository.save(gymSlot);
		logger.info("New Slot is created, details:\n"+slot);
		return slot;
	}

	/*
	 * @Method: getSlot
	 *
	 * @Description: get a slot by ID
	 *
	 * @Parameters: slot of type GymSlot
	 *
	 * @Exception: None
	 */
	@RequestMapping(value = "getSlots/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public GymSlot getSlotsById(@PathVariable Long id) {
		logger.info("Get the slot for the slot id: "+ id);
		return gymSlotRepository.findById(id).get();
	}

	/*
	 * @Method: getSlots
	 *
	 * @Description: get a slot by ID
	 *
	 * @Parameters: None
	 *
	 * @Exception: None
	 */
	@RequestMapping(value = "/getSlots", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<GymSlot> getSlots() {
		logger.info("Get all the available slots");
		return gymSlotRepository.findAll();
	}
}