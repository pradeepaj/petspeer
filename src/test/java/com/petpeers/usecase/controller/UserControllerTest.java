package com.petpeers.usecase.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.petpeers.usecase.dto.UserDto;
import com.petpeers.usecase.service.UserService;

import junit.framework.TestCase;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest extends TestCase{
	
	

@MockBean
	UserController userController;
@Autowired
	UserService userService;
	//@MockBean
	//UserDto dto;

	
	@Test
	public void addUserTest() {
		UserDto dto=new UserDto(1, "sysname", "sysPassword", "sysPassword");
		
		String addUser = userController.addUser(dto);
		System.out.println("UserControllerTest.addUserTest()"+addUser);
		assertEquals("Pet added successfully",addUser);
	}
	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
