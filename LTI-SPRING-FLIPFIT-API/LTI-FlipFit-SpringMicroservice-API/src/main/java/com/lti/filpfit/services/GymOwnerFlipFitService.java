package com.lti.filpfit.services;

import java.util.List;

import com.lti.filpfit.beans.GymCenter;
import com.lti.filpfit.beans.GymOwner;
import com.lti.filpfit.beans.Slot;
import com.lti.filpfit.beans.User;

public interface GymOwnerFlipFitService {

	public String loginUser(User user);

	public String registerUser(GymOwner gymOwner);

	public String addCenter(GymCenter gymCenter);

	public GymCenter getCenterByOwnerId(String OwnerId);

	public List<Slot> getSlotsByCenter(String CenterId);

	public String requestOwnerApproval(String Ownerid);

}
