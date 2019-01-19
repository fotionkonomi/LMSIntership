package org.lms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lms.converter.UserConverter;
import org.lms.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	private UserConverter userConverter;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
	}

	public List<User> listUser() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("Select u From User u").list();
		return userList;
	}

	public UserConverter getUserConverter() {
		return userConverter;
	}

	public void setUserConverter(UserConverter userConverter) {
		this.userConverter = userConverter;
	}


}
