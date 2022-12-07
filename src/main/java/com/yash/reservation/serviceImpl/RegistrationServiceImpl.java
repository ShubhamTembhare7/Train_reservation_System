package com.yash.reservation.serviceImpl;

import java.util.Base64;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.reservation.dao.LoginDao;
import com.yash.reservation.dao.ReservationDao;
import com.yash.reservation.entity.User;
import com.yash.reservation.model.ResponseModel;
import com.yash.reservation.model.TicketReservationModel;
import com.yash.reservation.model.UserModel;
import com.yash.reservation.service.RegistrationService;
import com.yash.reservation.utility.StatusCodes;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private static final Logger log = LoggerFactory.getLogger(RegistrationServiceImpl.class);

	@Autowired
	ReservationDao reservationDao;

	@Autowired
	ResponseModel responseModel;

	@Autowired
	LoginDao loginDao;

	@Override
	public ResponseModel getUserDetails(String userName, String password) {
		try {
			User user = reservationDao.getUserDetails(userName, password);
			if (user != null) {
				/*
				 * // If user in Login Details Table then
				 * responseModel.setResponseCode(StatusCodes.ERROR);
				 * responseModel.setResponseMessage(StatusCodes.USER_ALREADY_LOGIN_ERROR);
				 * 
				 * // if User not in LoginDetails table then // --- Add entry in Login Details
				 * table to restrict login access -- loginDao.addLoginDetails(user,
				 * StatusCodes.ENTER);
				 */
				responseModel.setResponseCode(StatusCodes.SUCCESS);
				responseModel.setResponseMessage(StatusCodes.REGSUCCESS);
				responseModel.setResponseObj(user);
			} else {
				responseModel.setResponseCode(StatusCodes.ERROR);
				responseModel.setResponseMessage(StatusCodes.INVALID_USER_CREDS);
			}
		} catch (NoResultException e) {
			responseModel.setResponseCode(StatusCodes.ERROR);
			responseModel.setResponseMessage(StatusCodes.INVALID_USER_CREDS);
		} catch (Exception e) {
			responseModel.setResponseCode(StatusCodes.ERROR);
			responseModel.setResponseMessage(StatusCodes.EXCEPTION_LOGIN);
		}
		return responseModel;
	}

	@Override
	public ResponseModel userRegistration(UserModel user) {
		log.info("Inside Method: userRegistration in Class: RegistrationServiceImpl");
		try {
			User userEntity = getUserEntity(user);
			reservationDao.userRegistration(userEntity);
			responseModel.setResponseCode(StatusCodes.SUCCESS);
			responseModel.setResponseMessage(StatusCodes.REGSUCCESS);
		} catch (Exception e) {
			log.debug("Exception in method : userRegistration in Class:RegistrationServiceImpl");
			log.info(e.getMessage());
		}
		return responseModel;
	}

	private User getUserEntity(UserModel user) {
		User userEntity = new User();
		userEntity.setEmail(user.getEmail());
		userEntity.setDateOfBirth(user.getDateOfBirth());
		userEntity.setFirstName(user.getFirstName());
		userEntity.setGender(user.getGender());
		userEntity.setLastName(user.getLastName());
		userEntity.setMobileNumber(user.getMobileNumber());
		//To encrypt password    
		String encodedPwd = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
		userEntity.setPassword(encodedPwd);
		userEntity.setUserName(user.getUserName());
		return userEntity;
	}

	@Override
	public ResponseModel getTrainDetails(TicketReservationModel ticketReservationModel) {
	log.info("Inside Method: getTrainDetails in Class: RegistrationServiceImpl");
	    
		return null;
	}

}
