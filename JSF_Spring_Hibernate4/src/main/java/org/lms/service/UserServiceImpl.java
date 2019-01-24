package org.lms.service;

import java.util.List;

import org.lms.dao.UserDAO;
import org.lms.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public List<UserDTO> listUser() {
		return userDAO.listUser();
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

	@Override
	@Transactional
	public Boolean isUserAdmin(UserDTO userDTO) {
		return userDAO.isUserAdmin(userDTO);
	}

	@Override
	@Transactional
	public void updateUser(UserDTO userDTO) throws DataIntegrityViolationException{
		this.userDAO.updateUser(userDTO);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void deleteAccount(UserDTO userDTO) {
		this.userDAO.deleteAccount(userDTO);
	}

	@Override
	@Transactional
	public void makeUserAdmin(UserDTO userDTO) {
		this.userDAO.makeUserAdmin(userDTO);
	}

}
