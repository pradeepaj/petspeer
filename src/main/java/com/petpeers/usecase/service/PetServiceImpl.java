package com.petpeers.usecase.service;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petpeers.usecase.dto.PetDto;
import com.petpeers.usecase.entity.Pet;
import com.petpeers.usecase.repository.PetRepository;
@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepository;

	/*
	 * @Autowired private ModelMapper modelMapper;
	 */
	@Override
	public String addPet(PetDto petsDto) {
		if(petsDto!=null) {
			Pet pet=new Pet();
			BeanUtils.copyProperties(petsDto, pet);
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
	@Override
	public List<Pet> searchByLocation(String location) {
		// TODO Auto-generated method stub
		return petRepository.searchbyPlace(location);
	}

}
