package com.petpeers.usecase.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petpeers.usecase.dto.UserDto;
import com.petpeers.usecase.entity.User;
import com.petpeers.usecase.service.UserService;
@RestController
@RequestMapping("/register")
public class UserController {
	
	private static final Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userSerivce;
	
	
	@PostMapping("/user/add")
	public ResponseEntity<User> addUser(@RequestBody UserDto userDto) {
		log.info("callind add user service");
		User user=userSerivce.addUser(userDto);
		
		return new ResponseEntity<>(user,HttpStatus.CREATED);
		
	}
	


}
