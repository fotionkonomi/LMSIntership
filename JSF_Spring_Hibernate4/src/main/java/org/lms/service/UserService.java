package org.lms.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.lms.dto.UserDTO;

public interface UserService {

	void addUser(UserDTO user) throws ConstraintViolationException;
	List<UserDTO> listUser();
	UserDTO find(String username, String password);
    List<UserDTO> findUsersThatAreNotActivated();
    void activateUser(UserDTO userDTO);
    void deleteUser(UserDTO userDTO);
    void deActivateUser(UserDTO userDTO);
}
