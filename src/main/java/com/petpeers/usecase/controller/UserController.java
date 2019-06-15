package com.petpeers.usecase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petpeers.usecase.dto.UserDto;
import com.petpeers.usecase.service.UserService;

@RestController
@RequestMapping("/registration")
public class UserController {
	
	@Autowired
	private UserService userSerivce;
	
	@PostMapping("/user/add")
	public String addUser(@RequestBody UserDto userDto) {
		return userSerivce.addUser(userDto);
	}
	


}
