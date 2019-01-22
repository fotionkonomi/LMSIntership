package org.lms.service;

import org.hibernate.exception.ConstraintViolationException;
import org.lms.dto.UserDTO;

public interface SignUpService {

	public void addUser(UserDTO userDTO) throws ConstraintViolationException;
}
