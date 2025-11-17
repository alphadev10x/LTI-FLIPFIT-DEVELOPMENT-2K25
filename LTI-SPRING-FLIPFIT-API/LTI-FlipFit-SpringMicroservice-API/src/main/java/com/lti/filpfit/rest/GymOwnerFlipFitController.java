package com.lti.filpfit.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.filpfit.beans.GymCenter;
import com.lti.filpfit.beans.GymOwner;
import com.lti.filpfit.beans.Slot;
import com.lti.filpfit.beans.User;

@RestController
@RequestMapping("/owner")
public class GymOwnerFlipFitController {

	@PostMapping("/login")
	public String login(@RequestBody User user) {
		return null;

	}
	@PostMapping("/register")
	public String register(@RequestBody GymOwner gymOwner) {
		return null;
	}
	@PostMapping("/addCenter")
	public String addCenter(@RequestBody GymCenter gymCenter) {
		return null;

	}
	@GetMapping("getCenterByOwnerId/{ownerId}")
	public GymCenter getCenterByOwnerId(@PathVariable("ownerId") String OwnerId) {
		return null;

	}
	@GetMapping("getSlotsByCenter/{centerId}")
	public List<Slot> getSlotsByCenter(@PathVariable("centerId") String CenterId) {
		return null;

	}
	@PutMapping("requestOwnerApproval/{ownerId}")
	public String requestOwnerApproval(@PathVariable("ownerId") String Ownerid) {
		return null;
	}

}
