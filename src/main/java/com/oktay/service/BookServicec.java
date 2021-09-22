package com.oktay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oktay.model.Book;
import com.oktay.repositary.Bookrepositary;

/**
 * @author oktay
 *
 */
@Service
public class BookServicec implements Bookservice{
	
	@Autowired
	private Bookrepositary bookRepository;
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}
	public Book getBook(Integer bookId) {
		return bookRepository.findById(bookId).get();
	}
	public Book updateBook(Integer BookId, Book book) {
		return bookRepository.save(book);
	}
	public void deleteBook(Integer bookId) {
		bookRepository.delete(getBook(bookId));
	}
	public List<Book> getAllBooks() {
		List<Book> books=new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}
}
