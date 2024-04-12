package com.cs489.service;

import java.util.List;

import com.cs489.model.Appointment;

public interface AppointmentService {

	Integer createNewAppointment(Appointment appointment);
	
	List<Appointment> findAppointment();
}
