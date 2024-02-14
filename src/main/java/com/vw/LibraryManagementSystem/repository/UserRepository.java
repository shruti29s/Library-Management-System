package com.vw.LibraryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vw.LibraryManagementSystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
