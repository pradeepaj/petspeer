package com.petpeers.usecase.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petpeers.usecase.dto.UserDto;
import com.petpeers.usecase.entity.User;
import com.petpeers.usecase.service.UserService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest extends TestCase {

	private MockMvc mockMvc;
	@MockBean
	private UserService userService;
	@Autowired
	WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void addUserTest() throws Exception {
		UserDto userdto = new UserDto(1, "abc", "password", "password");
		User user = new User();
		BeanUtils.copyProperties(userdto, user);
		ObjectMapper om = new ObjectMapper();

		String jsonObj = om.writeValueAsString(userdto);

		when(userService.addUser(userdto)).thenReturn(user);

		mockMvc.perform(MockMvcRequestBuilders.post("/register/user/add").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObj)).andExpect(status().isCreated());

	}

}
