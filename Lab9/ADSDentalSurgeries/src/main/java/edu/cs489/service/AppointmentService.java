package edu.cs489.service;

import java.util.List;

import edu.cs489.model.Appointment;

public interface AppointmentService {

	Integer createNewAppointment(Appointment appointment);
	
	List<Appointment> findAppointment();
}
