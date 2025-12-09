package com.flipfit.services;

import java.util.List;



import com.flipfit.entity.GymRole;
import com.flipfit.entity.GymUser;

public interface UserFlipFitService {
	public GymUser addUserdetails(GymUser user);

	public String loginUser(String email, String password);
	public GymUser getUserdetails( Long userid);
	public GymRole getRoledetails( Long roleid);
	public List<GymUser> getAllUsers();
	public  List<GymRole> getAllRoles();
	public GymUser getUserDetailsByEmail(String email);

}
