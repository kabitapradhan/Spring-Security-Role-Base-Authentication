package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entity.User;
import com.sts.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user2 = this.userService.createUser(user);
		return new ResponseEntity<>(user2,HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> list = this.userService.getAllUser();
		 
		return new ResponseEntity<>(list,HttpStatus.CREATED);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") String userid ) throws Exception {
		User list = this.userService.getUserById(userid);
		return new ResponseEntity<>(list,HttpStatus.CREATED);
	}

}
