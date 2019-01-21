package org.lms.dao;

import java.util.List;

import org.lms.model.Role;

public interface RoleDAO {

	void addRole(Role role);

	List<Role> listRole();
		
	void updateRole(Role role);
}
