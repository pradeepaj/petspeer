package com.petpeers.usecase.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.petpeers.usecase.dto.PetDto;
import com.petpeers.usecase.entity.Pet;
import com.petpeers.usecase.exception.DataNotFoundException;
import com.petpeers.usecase.repository.PetRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PetServiceTests {

	@InjectMocks
	PetServiceImpl petService;
	@Mock
	PetRepository petRepository;

	@Test
	public void addPetTest() {
		PetDto pet = new PetDto();
		Pet p = new Pet();

		pet.setPetId(1);
		pet.setPetName("dog");
		pet.setAction("Buy");
		pet.setPlace("Bengaluru");
		pet.setAge(1);

		BeanUtils.copyProperties(pet, p);

		Mockito.when(petRepository.save(p)).thenReturn(p);

		String msg = petService.addPet(pet);
		assertEquals("Pet added successfully", msg);

		// assertEquals("Pet added successfully", petService.addPet(pet));

	}
	@Test
	public void getAllPetTest() {
		
		List<Pet> expResult = new ArrayList<>();
		Pet pet1=new Pet(1,"dog","buy",1,"bengaluru");
		Pet pet2=new Pet(2,"dog","buy",2,"bengaluru");
		expResult.add(pet1);
		expResult.add(pet2);
		when(petRepository.findAll()).thenReturn(expResult);
		List<Pet> pett=petService.getAllPets();
		assertEquals(expResult, pett);
		
		
	}

	@Test(expected = DataNotFoundException.class)
	public void getPetTest() throws DataNotFoundException {
		when(petRepository.findByPetId(34)).thenReturn(null);
		petService.getPet(34);
	}
	
	

}
