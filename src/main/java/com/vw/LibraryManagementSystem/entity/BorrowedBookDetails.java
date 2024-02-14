package com.vw.LibraryManagementSystem.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="borrowed_book_details")
public class BorrowedBookDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private Book borrowedBook;
	
	@ManyToOne
	private User borrower;
	
	@Column(name="issuedDate")
	private LocalDate issueDate;
	
	@Column(name="returnDate")
	private LocalDate returnDate;
	
	public BorrowedBookDetails() {}

	public BorrowedBookDetails(int id, Book borrowedBook, User borrower, LocalDate issueDate, LocalDate returnDate) {
		super();
		this.id = id;
		this.borrowedBook = borrowedBook;
		this.borrower = borrower;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBorrowedBook() {
		return borrowedBook;
	}

	public void setBorrowedBook(Book borrowedBook) {
		this.borrowedBook = borrowedBook;
	}

	public User getBorrower() {
		return borrower;
	}

	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "BorrowedBookDetails [id=" + id + ", borrowedBook=" + borrowedBook + ", borrower=" + borrower
				+ ", issueDate=" + issueDate + ", returnDate=" + returnDate + "]";
	}

}
