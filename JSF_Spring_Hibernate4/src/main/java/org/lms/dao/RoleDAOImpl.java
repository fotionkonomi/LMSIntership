package org.lms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lms.converter.RoleConverter;
import org.lms.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {

	private SessionFactory sessionFactory;

	private RoleConverter roleConverter;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addRole(Role role) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(role);
	}

	@Override
	public List<Role> listRole() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Role> listRole = session.createQuery("Select r from Role r").list();
		return listRole;
	}

	@Override
	public void updateRole(Role role) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(role);
	}

	public RoleConverter getRoleConverter() {
		return roleConverter;
	}

	public void setRoleConverter(RoleConverter roleConverter) {
		this.roleConverter = roleConverter;
	}


}
