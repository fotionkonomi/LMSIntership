package org.lms.dao;

import org.hibernate.exception.ConstraintViolationException;
import org.lms.dto.UserDTO;

public interface SignUpDAO {

	void addUser(UserDTO userDTO) throws ConstraintViolationException;

}
