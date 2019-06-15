package com.petpeers.usecase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petpeers.usecase.service.SecurityService;

@RestController
@RequestMapping("/")
public class UserLoginController {
	
	@Autowired 
	private SecurityService securityService;
	
	@PostMapping("/user/authenticate")
	public String authenticateUser(@RequestParam ("name") String name,@RequestParam ("password") String password) {
		return securityService.authenticateUser(name,password);
	}

}
