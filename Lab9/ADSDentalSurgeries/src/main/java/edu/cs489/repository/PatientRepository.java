package edu.cs489.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cs489.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	Patient findPatientByFirstName(String searchString);
}
