package com.lti.filpfit.services;

import com.lti.filpfit.beans.GymCenter;


public interface GymCenterFlipFitService {
	public GymCenter getCentersByCity(String city);
	public String requestCenterApproval(String centerId);
}
