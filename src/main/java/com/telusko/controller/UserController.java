package com.telusko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.User;
import com.telusko.service.UserService;

@RestController
public class UserController {
    
	@Autowired
	private UserService service;
	
	@PostMapping("register")
	public User register(@RequestBody User user) {
		
		service.saveUser(user);
		
		return user;
		
	}
	
}
