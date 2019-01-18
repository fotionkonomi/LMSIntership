package org.lms.dao;

import org.springframework.stereotype.Repository;

import com.mysql.cj.xdevapi.SessionFactory;

@Repository
public class BookDAOImpl implements BookDAO{

	private SessionFactory sessionFactory;
	
	private void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	
}
