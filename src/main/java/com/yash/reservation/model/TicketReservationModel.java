package com.yash.reservation.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class TicketReservationModel {

	private String journeyType;
	private String from;
	private String to;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate departDate;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate returnDate;
	private Integer adultPassenger;
	private Integer childrenPassenger;
	private String travelClass;

	public String getJourneyType() {
		return journeyType;
	}

	public void setJourneyType(String journeyType) {
		this.journeyType = journeyType;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Integer getAdultPassenger() {
		return adultPassenger;
	}

	public void setAdultPassenger(Integer adultPassenger) {
		this.adultPassenger = adultPassenger;
	}

	public Integer getChildrenPassenger() {
		return childrenPassenger;
	}

	public void setChildrenPassenger(Integer childrenPassenger) {
		this.childrenPassenger = childrenPassenger;
	}

	public String getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}

	public LocalDate getDepartDate() {
		return departDate;
	}

	public void setDepartDate(LocalDate departDate) {
		this.departDate = departDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "TicketReservationModel [journeyType=" + journeyType + ", from=" + from + ", to=" + to + ", departDate="
				+ departDate + ", returnDate=" + returnDate + ", adultPassenger=" + adultPassenger
				+ ", childrenPassenger=" + childrenPassenger + ", travelClass=" + travelClass + "]";
	}


}
