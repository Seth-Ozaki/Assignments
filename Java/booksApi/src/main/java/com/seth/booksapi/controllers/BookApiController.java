
package com.seth.booksapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.seth.booksapi.models.Book;
import com.seth.booksapi.services.BookService;


 
@RestController
@RequestMapping("/api")
public class BookApiController {
		private final BookService bServ;
		
		public BookApiController(BookService service) {
			this.bServ = service;
		}
		
		
		//CRUD------------
		
		// Create
		// return: Object
		// route: /api/objects
		@PostMapping("/books")
		public Book createBook(
				@RequestParam("title") String title,
				@RequestParam("description") String description,
				@RequestParam("language") String language,
				@RequestParam("pageCount") Integer pageCount
				) {
			Book newBook = new Book(title, description, language, pageCount);
			
			Book newDbBook = bServ.createBook(newBook);
			
			return newDbBook;
		}
		
		// Read One
		// return: Object
		// route: /api/object/id
		@GetMapping("/books/{id}")
		public Book getOneBook(@PathVariable("id") Long id) {
			return bServ.getOneBook(id);
		}
		
		// Read All
		// return: Object
		// route: /api/objects
		@GetMapping("/books")
		public List<Book> getAllBooks(){
			return bServ.getAllBooks();
		}
		
		// Update
		// return: Object
		// route: /api/objects/id
		@PutMapping("books/{id}")
		public Book updateBook(
				@PathVariable("id")Long id,
				@RequestParam("title") String title,
				@RequestParam("description") String description,
				@RequestParam("language") String language,
				@RequestParam("pageCount") Integer pageCount
				){
			// Get existing Object from database
			Book updateThisBook = bServ.getOneBook(id);
			if (updateThisBook == null) return null; // Can do other things than return null
			
			// Update the Objects fields
			updateThisBook.setTitle(title);
			updateThisBook.setDescription(description);
			updateThisBook.setLanguage(language);
			updateThisBook.setPageCount(pageCount);
			
			// Save updated Object in database
			return bServ.updateBook(updateThisBook);
			
		}
		
		// Delete
		// return: void
		// route: /api/objects/id
		@DeleteMapping("/books/{id}")
		public void deleteBook(@PathVariable("id") Long id) {
			bServ.deleteBook(id);
		}		
		
}
