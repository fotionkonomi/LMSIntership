package org.lms.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.lms.dto.UserDTO;
import org.lms.model.User;
import org.springframework.dao.DataIntegrityViolationException;

public interface UserDAO {

	List<UserDTO> listUser();

	List<UserDTO> findUsersThatAreNotActivated();

	void activateUser(UserDTO userDTO);

	void deleteUser(UserDTO userDTO);

	void deActivateUser(UserDTO userDTO);
	
	Boolean isUserAdmin(UserDTO userDTO);
	
	void updateUser(UserDTO userDTO) throws DataIntegrityViolationException;
	
	void deleteAccount(UserDTO userDTO);
	
	void makeUserAdmin(UserDTO userDTO);
}
