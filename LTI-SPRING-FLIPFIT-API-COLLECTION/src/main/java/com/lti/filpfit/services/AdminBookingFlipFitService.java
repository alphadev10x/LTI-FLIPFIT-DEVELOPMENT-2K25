/**
 * 
 */
package com.lti.filpfit.services;



import com.lti.filpfit.beans.GymCenter;
import com.lti.filpfit.beans.GymOwner;
import com.lti.filpfit.beans.User;

/**
 * 
 */
public interface AdminBookingFlipFitService {
	public String loginUser(User user);
	public String validateOwner( GymOwner gymOwner);
	public String validateCenter( GymCenter gymCenter);
	public GymOwner viewPendingOwnerRequest(String ownerId);
	public GymCenter viewPendingCenterRequest( String centerId);

}
