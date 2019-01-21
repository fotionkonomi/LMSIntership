package org.lms.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.lms.dto.UserDTO;
import org.lms.model.User;

public interface UserDAO {

	void addUser(UserDTO userDTO) throws ConstraintViolationException;

	List<UserDTO> listUser();

	UserDTO find(String username, String password);

	List<UserDTO> findUsersThatAreNotActivated();

	void activateUser(UserDTO userDTO);

	void deleteUser(UserDTO userDTO);

	void deActivateUser(UserDTO userDTO);
}