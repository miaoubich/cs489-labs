package edu.cs489.service;

import edu.cs489.model.Dentist;

public interface DentistService {

	Integer createNewDentist(Dentist dentist);
	
	Dentist findDentistById(Integer dentistId);
	
	Dentist updateExistingDentist(Dentist dentist);
	
	Integer deleteDentist(Integer dentistId);
}
