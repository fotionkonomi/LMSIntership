package org.lms.dao;

import org.lms.model.Role;
import org.lms.model.User;

public class Main {

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.listUser().get(0);
		Role role = new RoleDAOImpl().listRole().get(0);
		user.getRolesOfThisUser().add(role);
		
	}
}
