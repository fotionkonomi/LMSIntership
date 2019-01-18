package org.lms.service;

import java.util.List;

import org.lms.dao.RoleDAO;
import org.lms.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Override
	@Transactional
	public void addRole(Role role) {
		roleDAO.addRole(role);
	}

	@Override
	@Transactional
	public List<Role> listRole() {
		return roleDAO.listRole();
	}

	@Override
	@Transactional
	public void updateRole(Role role) {
		roleDAO.updateRole(role);
	}

	
	

		
}
