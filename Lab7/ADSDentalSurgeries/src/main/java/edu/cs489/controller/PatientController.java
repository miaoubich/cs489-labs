package edu.cs489.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cs489.dto.patient.PatientRequest;
import edu.cs489.dto.patient.PatientResponse;
import edu.cs489.model.Patient;
import edu.cs489.service.PatientService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adsweb/api/v1/patient")
public class PatientController {

	private final PatientService patientService; 
	
	@GetMapping("/list")
	public ResponseEntity<?> displayListOfAllPatients(){
		List<Patient> patients = patientService.getAllPatients();
		return new ResponseEntity<>(patients, HttpStatus.FOUND);
	}
	
	@GetMapping("/get/{patientId}")
	public ResponseEntity<PatientResponse> displayPatientData(@PathVariable("patientId") Integer patientId){
		PatientResponse patientResponse = patientService.findPatientById(patientId);
		
		return new ResponseEntity<>(patientResponse, HttpStatus.FOUND);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerNewPatient(@RequestBody PatientRequest patientRequest){
		String responseMessage = patientService.createNewPatient(patientRequest);
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	}
	
	@PutMapping("/update/{patientId}")
	public ResponseEntity<?> updatePatientById(@PathVariable("patientId") Integer patientId, @RequestBody  PatientRequest patientRequest){
		return new ResponseEntity<>(patientService.updateExistingPatient(patientId, patientRequest), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{patientId}")
	public void deletePatientById(@PathVariable Integer patientId) {
		patientService.deletePatient(patientId);
	}
	
	@GetMapping("/search/{searchString}")
	public ResponseEntity<?> searchPatientByFirstName(@PathVariable String searchString) {
		PatientResponse patientResponse = patientService.searchPatientByFirstName(searchString);
		
		return new ResponseEntity<>(patientResponse, HttpStatus.FOUND);
	}
}

