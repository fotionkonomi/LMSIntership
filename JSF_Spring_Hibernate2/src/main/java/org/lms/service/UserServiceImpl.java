package org.lms.service;

import java.util.List;

import org.lms.dao.UserDAO;
import org.lms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
    @Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
    @Transactional
	public List<User> listUser() {
		return userDAO.listUser();
	}


}
