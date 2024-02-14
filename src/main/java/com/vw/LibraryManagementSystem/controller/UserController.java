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

import com.vw.LibraryManagementSystem.entity.User;
import com.vw.LibraryManagementSystem.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/getall")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
	
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

}
