package com.petpeers.usecase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petpeers.usecase.dto.PetDto;
import com.petpeers.usecase.entity.Pet;
import com.petpeers.usecase.service.PetService;
import com.petpeers.usecase.service.UserService;

@RestController
@RequestMapping("pets")
public class PetController {
	
	@Autowired
	private PetService petService;
	
	@Autowired
	private UserService userService; 
	
	@PostMapping("/pets/add")
	public String addPet(@RequestBody PetDto petsDto) {
		return petService.addPet(petsDto);
	}
	
	@GetMapping("/pets")
	public List<Pet> petHome(){
		return petService.getAllPets() ;
	}
	
	@GetMapping("/pet")
	public Pet petDetail(@RequestParam("petId") long petId) {
		return petService.getPet(petId);
	}
	
	@GetMapping("/pet/user/{userId}")
	public List<Pet> myPets(@PathVariable ("userId") Long userId){
		return userService.getMyPets(userId);
	}
	
	@PostMapping("/pet/user{userId}/buy/{petId}")
	public String buyPet(@PathVariable ("petId") long petId , @PathVariable ("userId")long userId) {
		return userService.buyPet(petId, userId);
	}
	@GetMapping("/pet/search")
	public List<Pet>  searchByLocation(@RequestParam String location){
		return petService.searchByLocation(location);
	}

	
	
}
