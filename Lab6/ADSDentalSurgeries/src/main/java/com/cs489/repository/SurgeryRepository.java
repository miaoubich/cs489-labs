package com.cs489.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs489.model.Surgery;

public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {

}
