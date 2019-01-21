package org.lms.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.lms.dao.UserDAO;
import org.lms.dto.UserDTO;
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
	public void addUser(UserDTO userDTO) throws ConstraintViolationException {
		userDAO.addUser(userDTO);
	}

	@Override
    @Transactional
	public List<UserDTO> listUser() {
		return userDAO.listUser();
	}

	@Override
	@Transactional
	public UserDTO find(String username, String password) {
		return userDAO.find(username, password);
	}

	@Override
	@Transactional
	public List<UserDTO> findUsersThatAreNotActivated() {
		return userDAO.findUsersThatAreNotActivated();
	}

	@Override
	@Transactional
	public void activateUser(UserDTO userDTO) {
		this.userDAO.activateUser(userDTO);
	}

	@Override
	@Transactional
	public void deleteUser(UserDTO userDTO) {
		this.userDAO.deleteUser(userDTO);
	}

	@Override
	@Transactional
	public void deActivateUser(UserDTO userDTO) {
		this.userDAO.deActivateUser(userDTO);
	}


}
