package org.lms.service;

import java.util.List;

import org.lms.dto.UserDTO;

public interface UserService {

	List<UserDTO> listUser();
    List<UserDTO> findUsersThatAreNotActivated();
    void activateUser(UserDTO userDTO);
    void deleteUser(UserDTO userDTO);
    void deActivateUser(UserDTO userDTO);
    Boolean isUserAdmin(UserDTO userDTO);
}
