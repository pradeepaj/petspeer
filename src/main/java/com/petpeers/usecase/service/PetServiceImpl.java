package com.petpeers.usecase.service;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petpeers.usecase.dto.PetDto;
import com.petpeers.usecase.entity.Pet;
import com.petpeers.usecase.exception.DataNotFoundException;
import com.petpeers.usecase.repository.PetRepository;
@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepository;

	
	@Override
	public String addPet(PetDto petsDto) {
		if(petsDto!=null) {
			Pet pet= new Pet();
			BeanUtils.copyProperties(petsDto, pet);
			petRepository.save(pet);
			return "Pet added successfully";
			
		}
		return "please add all fields";
	}
	@Override
	public List<Pet> getAllPets() {
		return  petRepository.findAll();
		
		
			
	}
	@Override
	public Pet getPet(long petId) throws DataNotFoundException {
	 Pet pet=petRepository.findByPetId(petId);
				if(pet==null) {
					throw new DataNotFoundException(" Pet not Found " +petId);
				}
		return pet;
	}
	@Override
	public List<Pet> searchByLocation(String location) {
		// TODO Auto-generated method stub
		return petRepository.searchbyPlace(location);
	}

}
