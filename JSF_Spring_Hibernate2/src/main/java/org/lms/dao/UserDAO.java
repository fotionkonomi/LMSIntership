package org.lms.dao;

import java.util.List;

import org.lms.model.User;

public interface UserDAO {

	void addUser(User user);
	
	List<User> listUser();
}

