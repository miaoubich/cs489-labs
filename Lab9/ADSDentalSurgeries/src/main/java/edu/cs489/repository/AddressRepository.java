package edu.cs489.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cs489.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
