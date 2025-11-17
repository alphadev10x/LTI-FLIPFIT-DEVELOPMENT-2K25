package com.lti.filpfit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.filpfit.beans.Scheduler;

@RestController
public class SchedulerFlipFitController {
	
	@PostMapping("createSchedule")
	public String createSchedule(@RequestBody Scheduler scheduler){
		return null;
		
	}
	
	@PutMapping("updateSchedule")
	public Scheduler updateSchedule(@RequestBody Scheduler scheduler) {
		return scheduler;
		
	}
	@GetMapping("getScheduleDetails/{scheduleId}")
	public Scheduler getScheduleDetails(@PathVariable("scheduleId") String schedulerId) {
		return null;
		
	}
	
	@GetMapping("checkAvailability/{scheduleId}")
	public void checkAvailability(@PathVariable("scheduleId") String scheduleId){
		
	}

}
