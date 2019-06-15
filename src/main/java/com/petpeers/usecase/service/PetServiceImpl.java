package com.petpeers.usecase.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petpeers.usecase.dto.PetDto;
import com.petpeers.usecase.entity.Pet;
import com.petpeers.usecase.repository.PetRepository;
@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepository;
	@Override
	public String addPet(PetDto petsDto) {
		if(petsDto!=null) {
			
			Pet pet=new Pet();
			pet.setPetName(petsDto.getPetName());
			pet.setPlace(petsDto.getPlace());
			pet.setAge(petsDto.getAge());
			pet.setAction(petsDto.getAction());
			pet.setUser(petsDto.getUser());
			petRepository.save(pet);
			return "Pet added successfully";
			
		}
		return "please add all fields";
	}
	@Override
	public List<Pet> getAllPets() {
		List<Pet> pet  = petRepository.findAll();
		return pet;
			
	}
	@Override
	public Pet getPet(long petId) {
		
		return petRepository.findByPetId(petId);
	}

}
