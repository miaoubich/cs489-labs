package com.cs489.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs489.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
