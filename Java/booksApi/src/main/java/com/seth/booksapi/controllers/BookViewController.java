package com.seth.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seth.booksapi.models.Book;
import com.seth.booksapi.services.BookService;

@Controller
@RequestMapping("/books")
public class BookViewController {

	@Autowired
	BookService bookService;

	// CRUD--------------

	// Read One
	// return: Object
	// route: /api/object/id
	@GetMapping("/{id}")
	public String readOne(Model model, @PathVariable("id") Long id) {

		Book book = bookService.getOneBook(id);
		model.addAttribute(book);

		return "index.jsp";
	}

	// Read All
	// return: Object
	// route: /api/objects
	@GetMapping("")
	public String getAllBooks(Model model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books",books);
		return "allBooks.jsp";
	}

}
