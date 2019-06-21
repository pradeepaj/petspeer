package com.petpeers.usecase.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.petpeers.usecase.entity.Pet;
import com.petpeers.usecase.exception.DataNotFoundException;
import com.petpeers.usecase.service.PetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PetControllerTest {

	private MockMvc mockMvc;
	@MockBean
	private PetService petService;
	@Autowired
	WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getPetTest() throws DataNotFoundException {
		Pet pet=new Pet(1, "pet", "bgl", 1, "sold");
		when(petService.getPet(1)).thenReturn(pet);		
		
			try {
				mockMvc.perform(MockMvcRequestBuilders.get("/pets/pet?petId=1")
						.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}
