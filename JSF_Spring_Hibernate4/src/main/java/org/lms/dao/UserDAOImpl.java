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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserConverter userConverter;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
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
	
	@Override
	public Boolean isUserAdmin(UserDTO userDTO) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select r from Role r where r.roleId=1");
		Role role = (Role)query.uniqueResult();
		User user = getUserById(userDTO);
		if(user.getRolesOfThisUser().contains(role)) {
			return true;
		} else {
			return false;
		} 
	}
	
	public User getUserById(UserDTO userDTO) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select u from User u where u.userId=:userId");
		query.setParameter("userId", userDTO.getUserId());
		return (User)query.uniqueResult();
	}

	@Override
	public void updateUser(UserDTO userDTO) throws DataIntegrityViolationException {
		Session session = this.sessionFactory.getCurrentSession();
		User user = getUserById(userDTO);
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setAge(userDTO.getAge());
		session.merge(user);
	}
	

}
