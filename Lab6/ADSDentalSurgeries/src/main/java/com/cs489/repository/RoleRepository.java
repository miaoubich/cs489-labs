package com.cs489.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs489.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
