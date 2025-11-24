package com.flipfit.services;

import com.flipfit.entity.GymUser;

public interface UserFlipFitService {
	public GymUser addUserdetails(GymUser user);

	public String verifyUserdetails(GymUser user);

}
