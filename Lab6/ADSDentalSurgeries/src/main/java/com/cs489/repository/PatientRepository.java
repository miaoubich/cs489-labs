package com.cs489.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs489.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
