package edu.cs489.service;

import edu.cs489.model.Role;

public interface RoleService {

	Integer createNewRole(Role roel);
	
	Role findRoleById(Integer roleId);
	
	Role updateExistingRole(Role role);
	
	Integer deleteRole(Integer roleId);
}
