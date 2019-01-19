package org.lms.converter;

import org.lms.dto.UserDTO;
import org.lms.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserConverterImpl implements UserConverter {

	public User toModel(UserDTO userDTO) {
		User user = new User();
	//	user.setUserId(userDTO.getUserId());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setUsername(userDTO.getUsername());
		user.setAge(userDTO.getAge());
		user.setActivated(userDTO.getActivated());
		user.setEmail(userDTO.getEmail());
		user.setGender(userDTO.getGender());
		user.setPassword(userDTO.getPassword());
		return user;

	}
	
	public UserDTO toDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserId());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setUsername(user.getUsername());
		userDTO.setAge(user.getAge());
		userDTO.setActivated(user.getActivated());
		userDTO.setEmail(user.getEmail());
		userDTO.setGender(user.getGender());
		userDTO.setPassword(user.getPassword());
		return userDTO;

	}
}
