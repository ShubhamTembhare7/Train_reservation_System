package com.yash.reservation.service;

import org.springframework.stereotype.Service;

import com.yash.reservation.model.ResponseModel;
import com.yash.reservation.model.TicketReservationModel;
import com.yash.reservation.model.UserModel;

@Service
public interface RegistrationService {
	
	
	public ResponseModel getUserDetails(String username, String password);

	public ResponseModel userRegistration(UserModel user);

	public ResponseModel getTrainDetails(TicketReservationModel ticketReservationModel);

}
