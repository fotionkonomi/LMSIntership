package org.lms.converter;

import org.lms.dto.BookDTO;
import org.lms.dto.UserDTO;
import org.lms.model.Book;
import org.lms.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class BookConverterImpl implements BookConverter{

	private CategoryConverter categoryConverter;
	private UserConverter userConverter;
	
	
	public Book toModel(BookDTO bookDTO) {
		Book book = new Book();
	//	book.setBookId(bookDTO.getBookId());
		book.setBookTitle(bookDTO.getBookTitle());
		book.setBookAuthor(bookDTO.getBookAuthor());
		book.setCategoryOfThisBook(categoryConverter.toModel(bookDTO.getCategoryOfThisBook()));	
		UserDTO userDTO = bookDTO.getBooker();
		if(userDTO != null) {
			book.setBooker(userConverter.toModel(userDTO));
		}
		book.setStatus(bookDTO.getStatus());
		return book;
	}
	
	public BookDTO toDTO(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setBookId(book.getBookId());
		bookDTO.setBookTitle(book.getBookTitle());
		bookDTO.setCategoryOfThisBook(categoryConverter.toDTO(book.getCategoryOfThisBook()));
		User user = book.getBooker();
		if(user != null) {
			bookDTO.setBooker(userConverter.toDTO(user));
		}
		bookDTO.setStatus(book.getStatus());
		return bookDTO;
	}
	
	
}
