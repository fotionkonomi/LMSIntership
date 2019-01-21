package org.lms.dao;

import org.lms.converter.BookConverter;
import org.springframework.stereotype.Repository;

import org.hibernate.SessionFactory;

@Repository
public class BookDAOImpl implements BookDAO {

	private SessionFactory sessionFactory;

	private BookConverter bookConverter;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public BookConverter getBookConverter() {
		return bookConverter;
	}

	public void setBookConverter(BookConverter bookConverter) {
		this.bookConverter = bookConverter;
	}

}
