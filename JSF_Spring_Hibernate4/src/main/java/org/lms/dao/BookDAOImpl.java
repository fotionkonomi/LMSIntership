package org.lms.dao;

import org.lms.converter.BookConverter;
import org.lms.dto.BookDTO;
import org.lms.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Repository
public class BookDAOImpl implements BookDAO {

	private SessionFactory sessionFactory;

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
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

	@Override
	public void addBook(BookDTO bookDTO) {
		Session session = this.sessionFactory.getCurrentSession();
		Book book = bookConverter.toModel(bookDTO);
		book.setCategoryOfThisBook(this.categoryDAO.getCategoryById(bookDTO.getCategoryOfThisBook()));
		session.persist(book);
	}
	
	private Book getBookById(BookDTO bookDTO) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select b from Book b where b.bookId=:bookId");
		query.setParameter("bookId", bookDTO.getBookId());
		return (Book)query.uniqueResult();
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	
}
