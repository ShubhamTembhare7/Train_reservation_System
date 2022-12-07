package com.yash.reservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.reservation.model.ResponseModel;
import com.yash.reservation.model.TicketReservationModel;
import com.yash.reservation.model.UserModel;
import com.yash.reservation.service.RegistrationService;
import com.yash.reservation.utility.StatusCodes;

@RestController
@CrossOrigin("http://localhost:4200")
public class RegistrationController {

	private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	RegistrationService regService;

	@Autowired
	ResponseModel response;

	@GetMapping("/getUserDetails/{userName}/{password}")
	public ResponseModel getUserDetails(@PathVariable("userName") String userName,
			@PathVariable("password") String password) {
		log.info("Inside method : getUserDetails class: RegistrationController");
		if (verifyUserDetails(userName, password)) {
			return regService.getUserDetails(userName, password);
		} else {
			response.setResponseCode(StatusCodes.ERROR);
			response.setResponseMessage(StatusCodes.REGERROR);

			return response;

		}
	}

	@PostMapping("/userRegistration")
	public ResponseModel userRegistration(@RequestBody UserModel user) {
		log.info("Inside method : userRegistration class: RegistrationController");
		return regService.userRegistration(user);
	}

	private boolean verifyUserDetails(String userName, String password) {
		log.info("Inside method : verifyUserDetails class: RegistrationController");
		if ((null != userName && !userName.isEmpty()) && (null != password && !password.isEmpty())) {
			return true;
		} else {
			return false;
		}

	}
	
	
}
