package org.lms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.lms.converter.UserConverter;
import org.lms.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpDAOImpl implements SignUpDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserConverter userConverter;

	@Override
	public void addUser(UserDTO userDTO) throws ConstraintViolationException {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(userConverter.toModel(userDTO));
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserConverter getUserConverter() {
		return userConverter;
	}

	public void setUserConverter(UserConverter userConverter) {
		this.userConverter = userConverter;
	}

}
