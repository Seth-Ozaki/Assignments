package com.seth.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.seth.booksapi.models.Book;
import com.seth.booksapi.repositories.BookRepository;

@Service
public class BookService {
	// Member variable that contains all our CRUD tools
		private final BookRepository bookRepo;
		
		public BookService(BookRepository bR) {
			this.bookRepo = bR;
		}
		
		// CRUD----------
		
		// Create
		public Book createBook(Book b) {
			return bookRepo.save(b);
		}
		
		// Read All
		public List<Book> getAllBooks() {
			return bookRepo.findAll();
		}
		
		// Read One
		public Book getOneBook(Long id) {
			Optional<Book> optBook = bookRepo.findById(id);
			if (optBook.isPresent()) {
				return optBook.get();
			} else {
				return null;
			}
		}
		
		// Update
		public Book updateBook(Book b) {
			return bookRepo.save(b);
		}
		
		// Delete
		public void deleteBook(Long id) {
			bookRepo.deleteById(id);
		}
}
