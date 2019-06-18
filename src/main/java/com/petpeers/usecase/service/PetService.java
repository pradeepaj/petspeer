package com.petpeers.usecase.service;

import java.util.List;

import com.petpeers.usecase.dto.PetDto;
import com.petpeers.usecase.entity.Pet;

public interface PetService {

	String addPet(PetDto petsDto);

	List<Pet> getAllPets();

	Pet getPet(long petId);

	List<Pet> searchByLocation(String location);

}
