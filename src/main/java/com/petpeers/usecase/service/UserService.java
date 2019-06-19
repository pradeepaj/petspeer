package com.petpeers.usecase.service;


import java.util.List;

import com.petpeers.usecase.dto.UserDto;
import com.petpeers.usecase.entity.Pet;
import com.petpeers.usecase.exception.DataNotFoundException;

public interface UserService {

	String addUser(UserDto userDto);

	List<Pet> getMyPets(Long userId) throws DataNotFoundException;

	String buyPet(long petId, long userId);


}
