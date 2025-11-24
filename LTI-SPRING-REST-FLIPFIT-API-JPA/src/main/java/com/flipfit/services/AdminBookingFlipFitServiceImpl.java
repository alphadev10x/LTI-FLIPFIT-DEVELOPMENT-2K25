/**
 * 
 */
package com.flipfit.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipfit.dao.AdminDto;
import com.flipfit.entity.GymAdmin;
import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymNotification;
import com.flipfit.entity.GymOwner;
import com.flipfit.entity.GymUser;
import com.flipfit.repository.GymAdminRepository;
import com.flipfit.repository.GymCenterRepository;
import com.flipfit.repository.GymNotificationRepository;
import com.flipfit.repository.GymOwnerRepository;
import com.flipfit.repository.GymUserRepository;

/*
* Admin Service for handling Admin responsibilities
*/
@Service
public class AdminBookingFlipFitServiceImpl implements AdminBookingFlipFitService {
	private static final Logger logger = LoggerFactory.getLogger(AdminBookingFlipFitServiceImpl.class);

	@Autowired
	private GymAdminRepository gymAdminRepository;

	@Autowired
	private GymOwnerRepository gymOwnerRepository;

	@Autowired
	private GymCenterRepository gymCenterRepository;

	@Autowired
	private GymNotificationRepository gymNotificationRepository;

	@Autowired
	private GymUserRepository gymUserRepository;

	/*
	 * @Method: validateOwner
	 * 
	 * @Description: Approve Owner details
	 * 
	 * @MethodParameters: GymOwner
	 * 
	 * @Exception: DetailsNotAvailableException
	 */

	@Override
	public Optional<GymOwner> validateOwner(Long ownerId) {
		logger.info("Validate owner");
		Optional<GymOwner> owner = gymOwnerRepository.findById(ownerId);
		return owner;

	}

	/*
	 * @Method: validateCenter
	 * 
	 * @Description: Approve GymCenter details
	 * 
	 * @MethodParameters: GymCenter
	 * 
	 * @Exception
	 */

	@Override
	public Optional<GymCenter> validateCenter(Long centerId) {
		logger.info("Validate Center");
		Optional<GymCenter> center = gymCenterRepository.findById(centerId);
		return center;
	}

	/*
	 * @Method: viewPendingOwnerRequest
	 * 
	 * @Description: View Pending Owner request
	 * 
	 * @MethodParameters: No Args
	 * 
	 * @Exception :NoPendingOwnerException
	 */

	@Override
	public List<GymOwner> viewPendingOwnerRequest() {
		logger.info("View pending owner request");

		List<GymOwner> gymOwners = gymOwnerRepository.findUnapprovedOwners();

		return gymOwners;
	}

	/*
	 * @Method: viewPendingCenterRequest
	 * 
	 * @Description: View Pending Center request
	 * 
	 * @MethodParameters: No Args
	 * 
	 * @Exception :NoPendingCenterException
	 */
	@Override
	public List<GymCenter> viewPendingCenterRequest() {
		logger.info("View pending Center request");
		List<GymCenter> gymCenters = gymCenterRepository.findUnapprovedCenter();

		return gymCenters;
	}

	/*
	 * @Method: registerAdmin
	 * 
	 * @Description: Register a new Admin and send notification
	 * 
	 * @Parameters: AdminDto
	 * 
	 * @Exception:
	 */
	@Override
	public GymAdmin registerAdmin(AdminDto adminDto) {
		logger.info("Register Admin");
		GymUser user = new GymUser();
		user.setCreationDate(LocalDateTime.now());
		user.setEmail(adminDto.getEmail());
		user.setPassword(adminDto.getPassword());
		user.setRoleId(adminDto.getRoleId());
		GymUser user1 = gymUserRepository.save(user);
		GymAdmin admin = new GymAdmin();
		admin.setFirstName(adminDto.getFirstName());
		admin.setLastName(adminDto.getLastName());
		admin.setPhoneNumber(adminDto.getPhoneNumber());
		admin.setUserId(user1.getUserId());
		GymAdmin registeredAdmin = gymAdminRepository.save(admin);
		if (Objects.nonNull(registeredAdmin)) {
			GymNotification gymNotification = new GymNotification();
			gymNotification.setMessage("GymAdmin Registration" + admin.getFirstName());
			gymNotification.setNotificationStatus("Successfully Registered");
			gymNotificationRepository.save(gymNotification);
		}
		return registeredAdmin;
	}

}
