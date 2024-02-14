package com.vw.LibraryManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vw.LibraryManagementSystem.entity.User;
import com.vw.LibraryManagementSystem.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

}
