package org.lms.service;

import java.util.List;

import org.lms.dto.UserDTO;
import org.springframework.dao.DataIntegrityViolationException;

public interface UserService {

	List<UserDTO> listUser();
    List<UserDTO> findUsersThatAreNotActivated();
    void activateUser(UserDTO userDTO);
    void deleteUser(UserDTO userDTO);
    void deActivateUser(UserDTO userDTO);
    Boolean isUserAdmin(UserDTO userDTO);
    void updateUser(UserDTO userDTO) throws DataIntegrityViolationException;
    void deleteAccount(UserDTO userDTO);
    void makeUserAdmin(UserDTO userDTO);
    Boolean isAUserAdmin(UserDTO userDTO);
    Boolean isAUserSecretary(UserDTO userDTO);
}


