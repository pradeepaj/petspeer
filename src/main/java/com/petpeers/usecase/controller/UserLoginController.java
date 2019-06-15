package com.petpeers.usecase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petpeers.usecase.service.SecurityService;

@RestController
@RequestMapping("/")
public class UserLoginController {
	
	@Autowired 
	private SecurityService securityService;
	
	@PostMapping("/user/authenticate/{name}/{password}")
	public String authenticateUser(@PathVariable String name, String password) {
		return securityService.authenticateUser(name,password);
	}

}
