package org.lms.service;

import java.util.List;

import org.lms.model.User;

public interface UserService {

	void addUser(User user);
	List<User> listUser();
}
