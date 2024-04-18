package edu.cs489.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cs489.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findUserByUsername(String userName);
}
