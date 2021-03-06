package org.lms.dao;

import java.util.ArrayList;
import java.util.List;

import org.lms.dto.RoleDTO;
import org.lms.model.Role;

public interface RoleDAO {

	Role getRoleById(RoleDTO roleDTO);
	
	Role getAdminRole();
	Role getStudentRole();
	Role getSecretaryRole();
    List<Role> toModelListFromString(List<String> rolesString);
}
