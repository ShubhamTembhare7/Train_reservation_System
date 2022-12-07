package com.yash.reservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.reservation.model.ResponseModel;
import com.yash.reservation.model.TicketReservationModel;
import com.yash.reservation.model.TrainDetailsModel;
import com.yash.reservation.service.TrainDetailsService;

@RestController
@CrossOrigin("http://localhost:4200")
public class TrainDetailsController {
	
	
	private static final Logger log = LoggerFactory.getLogger(TrainDetailsController.class);

	@Autowired
	TrainDetailsService trainDetailsService;
	
	
	@PostMapping("/getTrainDetails")
	public ResponseModel getTrainDetails(@RequestBody TicketReservationModel ticketReservationModel)
	{
		log.info("Inside method : getTrainDetails class: RegistrationController");
		log.info("ticketReservationModel: To"+ticketReservationModel.getTo());
		return trainDetailsService.getTrainDetails(ticketReservationModel);
	}
	
	@PostMapping("/ticketBooking")
	public ResponseModel ticketBooking(@RequestBody TrainDetailsModel model) {
		log.info("Inside method : ticketBooking class: RegistrationController");
		return trainDetailsService.ticketBooking(model);
	}

}
