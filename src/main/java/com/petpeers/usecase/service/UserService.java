package com.petpeers.usecase.service;


import java.util.List;

import com.petpeers.usecase.dto.UserDto;
import com.petpeers.usecase.entity.Pet;

public interface UserService {

	String addUser(UserDto userDto);

	List<Pet> getMyPets(Long userId);

	String buyPet(long petId, long userId);


}
