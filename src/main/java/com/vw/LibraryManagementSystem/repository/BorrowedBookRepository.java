package com.vw.LibraryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vw.LibraryManagementSystem.entity.BorrowedBookDetails;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBookDetails, Integer> {

}
