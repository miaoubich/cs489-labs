package com.cs489.service;

import java.util.List;

import com.cs489.model.Surgery;

public interface SurgeryService {

	Integer createNewSurgery(Surgery surgery);
	
	List<Surgery> findAppointment();
}
