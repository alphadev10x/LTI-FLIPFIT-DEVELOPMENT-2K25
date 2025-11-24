package com.lti.filpfit.services;

import com.lti.filpfit.beans.Scheduler;

public interface SchedulerFlipFitService {

	public String createSchedule(Scheduler scheduler);

	public Scheduler updateSchedule(Scheduler scheduler);

	public Scheduler getScheduleDetails(String schedulerId);

	public void checkAvailability(String scheduleId);

}
