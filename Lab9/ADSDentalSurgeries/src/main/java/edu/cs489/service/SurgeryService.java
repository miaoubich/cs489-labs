package edu.cs489.service;

import java.util.List;

import edu.cs489.model.Surgery;

public interface SurgeryService {

	Integer createNewSurgery(Surgery surgery);
	
	List<Surgery> findAppointment();
}
