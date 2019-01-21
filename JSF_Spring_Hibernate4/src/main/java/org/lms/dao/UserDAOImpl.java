package org.lms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.lms.converter.UserConverter;
import org.lms.converter.UserConverterImpl;
import org.lms.dto.UserDTO;
import org.lms.model.Role;
import org.lms.model.User;
import org.lms.service.RoleServiceImpl;
import org.lms.utils.Encryptor;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	private UserConverter userConverter;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addUser(UserDTO userDTO) throws ConstraintViolationException {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(userConverter.toModel(userDTO));
	}

	public List<UserDTO> listUser() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("Select u From User u").list();
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		for (User user : userList) {
			userDTOList.add(userConverter.toDTO(user));
		}
		return userDTOList;
	}

	@Override
	public UserDTO find(String username, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("Select u from User u where u.username = :username AND u.password = :password");
		query.setParameter("username", username);
		query.setParameter("password", Encryptor.encrypt(password, 12));
		User user = (User) query.uniqueResult();
		if (user != null) {
			return userConverter.toDTO(user);
		}
		return null;
	}
	
	@Override
	public List<UserDTO> findUsersThatAreNotActivated() {	
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select u from User u where u.activated=0");
		List<User> users = query.list();
		List<UserDTO> usersDTO = new ArrayList<>();
		for(User user : users) {
			usersDTO.add(userConverter.toDTO(user));
		}
		return usersDTO;
	}
	
	@Override
	public void activateUser(UserDTO userDTO) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = userConverter.toModel(userDTO);
		user.setActivated(1);
		session.merge(user);
	}
	
	
	public UserConverter getUserConverter() { 
		return userConverter;
	}

	public void setUserConverter(UserConverter userConverter) {
		this.userConverter = userConverter;
	}

	@Override
	public void deleteUser(UserDTO userDTO) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = userConverter.toModel(userDTO);
		session.delete(user);
	}

	@Override
	public void deActivateUser(UserDTO userDTO) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = userConverter.toModel(userDTO);
		user.setActivated(-1);
		session.merge(user);
	}
	

}
