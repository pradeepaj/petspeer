package com.petpeers.usecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petpeers.usecase.entity.User;
import com.petpeers.usecase.repository.UserRepository;

@Service
public class SecurityServiceImpl implements SecurityService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public String authenticateUser(String name, String password) {
		if(name!=null && password!=null) {
			User user=userRepository.findByNameAndPassword(name,password);
			if(user!=null && user.getName().equals(name) && user.getPassword()!=null) {
				return "Valid User";
		}
			else {
				return "Invalid User";
			}
		}
		else {
			return "Invalid Credentials";
		}
		
	}

}
