package edu.cs489.service;

import java.util.List;

import edu.cs489.dto.patient.PatientRequest;
import edu.cs489.dto.patient.PatientResponse;
import edu.cs489.model.Patient;

public interface PatientService {

	String createNewPatient(PatientRequest patientRequest);
	
	PatientResponse findPatientById(Integer patientId);
	
	PatientResponse updateExistingPatient(Integer patientId, PatientRequest patientRequest);
	
	void deletePatient(Integer patientId);

	List<Patient> getAllPatients();

	PatientResponse searchPatientByFirstName(String searchString);

}
