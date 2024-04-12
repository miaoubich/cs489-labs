package com.cs489.service;

import org.springframework.stereotype.Service;

import com.cs489.model.Patient;
import com.cs489.repository.PatientRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService{

	private final PatientRepository patientRepository;
	
	//CRUD
	public Integer createNewPatient(Patient patient) {
		log.info("A new Patient with id=" + patient.getId() + " will be created!");
		
		patientRepository.save(patient);
		
		log.info("The Dentist with id=" + patient.getId() + " is created!");
		
		return patient.getId();
	}
	
	public Patient findPatientById(Integer patientId) {
		Patient patient = patientRepository.findById(patientId).
				orElseThrow(() -> new NullPointerException(
						"Patient with id=" + patientId + " doesn't exist in the database!"));
		return patient;
	}
	
	public Patient updateExistingPatient(Patient patient) {
		Patient exisPatient = findPatientById(patient.getId());
		
		if(exisPatient != null) {
			log.info("Dentists with id=" + exisPatient.getId() + "is exist in the DB!");
			
			exisPatient.setAppointments(patient.getAppointments());
			exisPatient.setEmail(patient.getEmail());
			exisPatient.setFirstName(patient.getFirstName());
			exisPatient.setLastName(patient.getLastName());
			exisPatient.setPhoneNumber(patient.getPhoneNumber());
			exisPatient.setDateOfBirth(patient.getDateOfBirth());
			exisPatient.setAddress(patient.getAddress());
			exisPatient.setOutstandingBill(patient.getOutstandingBill());
//			exisPatient.setRoles(patient.getRoles().);
			
			patientRepository.save(exisPatient);
			
			log.info("Dentist with id=" + exisPatient.getId() + "successfully updated!");
		}
		return exisPatient;
	}
	
	public Integer deletePatient(Integer patientId) {
		Patient patient = findPatientById(patientId);
		
		if(patient != null) {
			log.info("Role with id=" + patient.getId() + "is exist in the DB!");
			patientRepository.delete(patient);
			log.info("Patient with id=" + patient.getId() + "is exist in the DB!");
		}
		return patient.getId();
	}

}
