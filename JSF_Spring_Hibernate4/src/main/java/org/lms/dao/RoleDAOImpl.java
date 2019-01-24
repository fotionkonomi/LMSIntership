package org.lms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lms.converter.RoleConverter;
import org.lms.dto.RoleDTO;
import org.lms.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {

	private SessionFactory sessionFactory;

	private RoleConverter roleConverter;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public RoleConverter getRoleConverter() {
		return roleConverter;
	}

	public void setRoleConverter(RoleConverter roleConverter) {
		this.roleConverter = roleConverter;
	}

	@Override
	public Role getRoleById(RoleDTO roleDTO) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select r from Role r where r.roleId = :roleId");
		query.setParameter("roleId", roleDTO.getRoleId());
		return (Role)query.uniqueResult();
	}

	@Override
	public Role getAdminRole() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select r from Role r where r.roleId = 1");
		return (Role)query.uniqueResult();
	}

	@Override
	public Role getStudentRole() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select r from Role r where r.roleId = 2");
		return (Role)query.uniqueResult();
	}

	@Override
	public Role getSecretaryRole() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select r from Role r where r.roleId = 3");
		return (Role)query.uniqueResult();
	}
	
	


}
