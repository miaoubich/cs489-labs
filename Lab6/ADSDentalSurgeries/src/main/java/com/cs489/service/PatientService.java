package com.cs489.service;

import com.cs489.model.Patient;

public interface PatientService {

	Integer createNewPatient(Patient patient);
	
	Patient findPatientById(Integer patientId);
	
	Patient updateExistingPatient(Patient patient);
	
	Integer deletePatient(Integer patientId);
}
