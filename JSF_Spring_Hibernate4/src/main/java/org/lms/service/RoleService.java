package org.lms.service;

import java.util.List;

import org.lms.model.Role;

public interface RoleService {

	void addRole(Role role);
	List<Role> listRole();
	void updateRole(Role role);
}
