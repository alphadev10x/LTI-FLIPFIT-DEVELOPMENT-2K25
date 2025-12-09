/**
 * 
 */
package com.flipfit.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flipfit.dao.AdminDto;
import com.flipfit.entity.GymAdmin;
import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymNotification;
import com.flipfit.entity.GymOwner;
import com.flipfit.entity.GymPayment;
import com.flipfit.entity.GymUser;
import com.flipfit.feignclient.NotificationClient;
import com.flipfit.feignclient.UserClient;
import com.flipfit.repository.GymAdminRepository;
import com.flipfit.repository.GymCenterRepository;
import com.flipfit.repository.GymNotificationRepository;
import com.flipfit.repository.GymOwnerRepository;
import com.flipfit.repository.GymUserRepository;
import com.flipfit.repository.PaymentRepository;

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
	private PaymentRepository paymentRepository;
	
	@Autowired
	 private  NotificationClient notificationClient;
	
	@Autowired 
	private GymNotificationRepository notificationRepository;
	
	@Autowired
	private UserClient userClient;
	
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
	@Transactional
	public int validateOwner(Long ownerId) {
		logger.info("Validate owner" + ownerId);

		int affectedRows = gymOwnerRepository.approveGymOwner(ownerId);
		return affectedRows;

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
	@Transactional
	public int validateCenter(Long centerId) {
		logger.info("Validate Center");
		int affectedRows = gymCenterRepository.approveGymCenter(centerId);
		return affectedRows;
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
		GymUser user = saveUser(adminDto);
		logger.info("Save User");
		GymAdmin registeredAdmin = saveAdmin(adminDto, user);
		logger.info("Save Admin");
		if (Objects.nonNull(registeredAdmin)) {
			saveNotification(adminDto);
			logger.info("Save Notification");
		}
		return registeredAdmin;
	}
	
	/*
	 * @Method: registerAdmin
	 * 
	 * @Description: Register a new Admin
	 * 
	 * @Parameters: AdminDto
	 * 
	 * @Exception:
	 */
	@Override
	public List<GymAdmin> getAllAdmin() {
		
		return gymAdminRepository.findAll();
	}
	
	/*
	 * @Method: getAllPayments
	 * 
	 * @Description: Get all Payments
	 * 
	 * @Parameters: No -Args
	 * 
	 * @Exception:
	 */
	@Override
	//@Cacheable(value = "myCache")
	public List<GymPayment> getAllPayments() {
		return paymentRepository.findAll();
	}
	
	public GymUser saveUser(AdminDto adminDto) {
		GymUser user = new GymUser();
		user.setCreationDate(LocalDateTime.now());
		user.setEmail(adminDto.getEmail());
		user.setPassword(adminDto.getPassword());
		user.setRoleId(1L);
		//GymUser user1 = userClient.addUserdetails(user);
		return gymUserRepository.save(user);
		
	}
	
	public void saveNotification(AdminDto adminDto) {
		GymNotification gymNotification = new GymNotification();
		gymNotification.setMessage("GymAdmin Registration" + adminDto.getFirstName());
		gymNotification.setNotificationStatus("Successfully Registered");
		notificationRepository.save(gymNotification);
		//notificationClient.sendNotification(gymNotification);
	}
	
	public GymAdmin saveAdmin(AdminDto adminDto,GymUser user1) {
		GymAdmin admin = new GymAdmin();
		admin.setFirstName(adminDto.getFirstName());
		admin.setLastName(adminDto.getLastName());
		admin.setPhoneNumber(adminDto.getPhoneNumber());
		admin.setUserId(user1.getUserId());
		GymAdmin registeredAdmin = gymAdminRepository.save(admin);
		return registeredAdmin;
		
	}

}
