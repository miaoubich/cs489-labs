package edu.cs489.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cs489.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
