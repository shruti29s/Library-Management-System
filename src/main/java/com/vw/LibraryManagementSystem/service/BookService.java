package com.vw.LibraryManagementSystem.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.vw.LibraryManagementSystem.entity.Book;
import com.vw.LibraryManagementSystem.entity.BorrowedBookDetails;
import com.vw.LibraryManagementSystem.entity.User;
import com.vw.LibraryManagementSystem.repository.BookRepository;
import com.vw.LibraryManagementSystem.repository.BorrowedBookRepository;
import com.vw.LibraryManagementSystem.repository.UserRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BorrowedBookRepository borrowedBookRepository;

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book getBookById(int id) {
		return bookRepository.findById(id).orElse(null);
	}

	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}

	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	public BorrowedBookDetails borrowBook(BorrowedBookDetails borrowedBookDetails) {
		Book book=getBookById(borrowedBookDetails.getBorrowedBook().getId());
		User user=userRepository.findById(borrowedBookDetails.getBorrower().getId()).orElse(null);
		
		if(user==null || book==null || book.isBorrowed()==true)
		{
			return null;
		}
		book.setBorrowed(true);
		updateBook(book);
		borrowedBookDetails.setBorrowedBook(book);
		borrowedBookDetails.setBorrower(user);
		LocalDate currentDate=LocalDate.now();
		borrowedBookDetails.setIssueDate(currentDate);
		System.out.println("BorrowedDetails: "+borrowedBookDetails);
		return borrowedBookRepository.save(borrowedBookDetails);
	}

	public BorrowedBookDetails returnBook(int borrowedBookId) {
		BorrowedBookDetails borrowedBookDetails = borrowedBookRepository.findById(borrowedBookId).orElse(null);
		Book book=getBookById(borrowedBookDetails.getBorrowedBook().getId());
		User user=userRepository.findById(borrowedBookDetails.getBorrower().getId()).orElse(null);
		
		if(borrowedBookDetails==null || book==null|| user==null || book.isBorrowed()==false)
		{
			return null;
		}
		
		LocalDate currentDate=LocalDate.now();
		Period period=Period.between(borrowedBookDetails.getIssueDate(), currentDate);
		long totalDays=(period.getYears()*365)+(period.getMonths()*30)+(period.getDays());
		if(totalDays>15)
		{
			System.out.println("Your expected return date is "+borrowedBookDetails.getIssueDate().plusDays(15));
			System.out.println("You have exceeded "+(totalDays-15)+" days.");
			System.out.println("You need to pay a fine of "+(totalDays-15)*5);
		}
		borrowedBookDetails.setReturnDate(currentDate);
		book.setBorrowed(false);
		updateBook(book);
		borrowedBookDetails.setBorrowedBook(book);
		return borrowedBookRepository.save(borrowedBookDetails);
	}
	
	

}
