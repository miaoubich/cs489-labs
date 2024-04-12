package com.cs489.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs489.model.Dentist;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {

}
