package edu.cs489.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import edu.cs489.dto.patient.PatientRequest;
import edu.cs489.dto.patient.PatientResponse;
import edu.cs489.exception.patient.PatientServiceCustomException;
import edu.cs489.model.Patient;
import edu.cs489.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {

	private final PatientRepository patientRepository;

	// CRUD
	@Override
	public String createNewPatient(PatientRequest patientRequest) {
		Patient patient = new Patient();
		BeanUtils.copyProperties(patientRequest, patient);

		log.info("A new Patient with id=" + patient.getId() + " will be created!");
		patientRepository.save(patient);
		log.info("The Dentist with id=" + patient.getId() + " is created!");

		String responseMessage = "Patient successfully registered in the database!";

		return responseMessage;
	}

	public PatientResponse findPatientById(Integer patientId) {
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientServiceCustomException(
						"Patient with id=" + patientId + " is not registered yet in the database!", "PATIENT_NOT_FOUND",
						HttpStatus.NOT_FOUND));

		PatientResponse patientResponse = new PatientResponse();
		BeanUtils.copyProperties(patient, patientResponse);

		return patientResponse;
	}

	@Override
	public PatientResponse updateExistingPatient(Integer patientId, PatientRequest patientRequest) {
		PatientResponse patient = findPatientById(patientId);
		Patient patientExist = new Patient();
		PatientResponse patientResponse = new PatientResponse();

		BeanUtils.copyProperties(patient, patientExist);

		if (patientRequest != null) {
			log.info("Dentists with id=" + patientExist.getId() + "is exist in the DB!");

			patientExist.setEmail(patientRequest.getEmail());
			patientExist.setFirstName(patientRequest.getFirstName());
			patientExist.setLastName(patientRequest.getLastName());
			patientExist.setPhoneNumber(patientRequest.getPhoneNumber());
			patientExist.setDateOfBirth(patientRequest.getDateOfBirth());
			patientExist.setAddress(patientRequest.getAddress());
			patientExist.setOutstandingBill(patientRequest.getOutstandingBill());

			patientRepository.save(patientExist);

			BeanUtils.copyProperties(patientExist, patientResponse);

			log.info("Dentist with id=" + patientExist.getId() + "successfully updated!");
		}
		return patientResponse;
	}

	public void deletePatient(Integer patientId) {
		PatientResponse patientResponse = findPatientById(patientId);
		Patient patient = new Patient();

		BeanUtils.copyProperties(patientResponse, patient);

		if (patient != null) {
			log.info("Patient with id=" + patient.getId() + " exist in the DB!");
			patientRepository.delete(patient);
			log.info("Patient with id=" + patient.getId() + " successfully erased from the DB!");
		}
	}

	@Override
	public List<Patient> getAllPatients() {
		List<Patient> patients = patientRepository.findAll();

		log.info("Patient List -->  " + patients);
		if (patients != null)
			return patients;
		else
			throw new PatientServiceCustomException("No patient yet registered in our Database",
					"PATIENTS_LIST_IS_EMPTY", HttpStatus.NO_CONTENT);
	}

	@Override
	public PatientResponse searchPatientByFirstName(String searchString) {
		Patient patient = patientRepository.findPatientByFirstName(searchString);
		PatientResponse patientResponse = new PatientResponse();

		if (patient != null) {
			BeanUtils.copyProperties(patient, patientResponse);
			return patientResponse;
		}
		else
			throw new PatientServiceCustomException("The Patient with the name '" + searchString + "' doesn't not register yet",
					"PATIENTS_LIST_IS_EMPTY", HttpStatus.NO_CONTENT);
	}

}
