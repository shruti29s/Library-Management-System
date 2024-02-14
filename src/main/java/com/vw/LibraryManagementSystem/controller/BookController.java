package com.vw.LibraryManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vw.LibraryManagementSystem.entity.Book;
import com.vw.LibraryManagementSystem.entity.BorrowedBookDetails;
import com.vw.LibraryManagementSystem.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/add")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@GetMapping("/getall")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/get/{id}")
	public Book getBookById(@PathVariable int id) {
		return bookService.getBookById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
	}
	
	@PutMapping("/update")
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	@PostMapping("/borrow")
	public BorrowedBookDetails borrowBook(@RequestBody BorrowedBookDetails borrowedBookDetails) {
		return bookService.borrowBook(borrowedBookDetails);
	}
	
	@PostMapping("/return/{borrowedBookId}")
	public BorrowedBookDetails returnBook(@PathVariable int borrowedBookId)
	{
		return bookService.returnBook(borrowedBookId);
	}

}
