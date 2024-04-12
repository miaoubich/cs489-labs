package com.cs489.service;

import org.springframework.stereotype.Service;

import com.cs489.model.Role;
import com.cs489.repository.RoleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService{

	private final RoleRepository roleRepository;
	
	//CRUD
	public Integer createNewRole(Role role) {
		log.info("A new ROle with id=" + role.getId() + " will be created!");
		
		roleRepository.save(role);
		
		log.info("ROle with id=" + role.getId() + " is created!");
		
		return role.getId();
	}
	
	public Role findRoleById(Integer roleId) {
		Role role = roleRepository.findById(roleId).
				orElseThrow(() -> new NullPointerException(
						"Role with id=" + roleId + " doesn't exist in the database!"));
		return role;
	}
	
	public Role updateExistingRole(Role role) {
		Role existRole = findRoleById(role.getId());
		
		if(existRole != null) {
			log.info("Role with id=" + existRole.getId() + "is exist in the DB!");
			
			existRole.setStartDate(role.getStartDate());
			existRole.setStopDate(role.getStopDate());
			existRole.setUser(role.getUser());
			
			roleRepository.save(existRole);
			
			log.info("Role with id=" + existRole.getId() + "successfully updated!");
		}
		return existRole;
	}
	
	public Integer deleteRole(Integer roleId) {
		Role role = findRoleById(roleId);
		
		if(role != null) {
			log.info("Role with id=" + role.getId() + "is exist in the DB!");
			roleRepository.delete(role);
			log.info("Role with id=" + role.getId() + "is exist in the DB!");
		}
		return role.getId();
	}
}
