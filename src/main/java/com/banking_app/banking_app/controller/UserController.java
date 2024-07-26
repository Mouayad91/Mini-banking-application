package com.banking_app.banking_app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking_app.banking_app.entity.User;
import com.banking_app.banking_app.service.UserService;



@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/api/accounts/register")
	public User register(@RequestBody User user) {
	  return service.saveUser(user);
	}
}
