/**
 * 
 */
package com.lti.filpfit.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.filpfit.beans.GymCenter;
import com.lti.filpfit.beans.GymOwner;
import com.lti.filpfit.beans.Slot;
import com.lti.filpfit.beans.User;

/**
 * 
 */
@Service
public class GymOwnerFlipFitServiceImpl implements GymOwnerFlipFitService {

	@Override
	public String loginUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerUser(GymOwner gymOwner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addCenter(GymCenter gymCenter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GymCenter getCenterByOwnerId(String OwnerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Slot> getSlotsByCenter(String CenterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String requestOwnerApproval(String Ownerid) {
		// TODO Auto-generated method stub
		return null;
	}

}
