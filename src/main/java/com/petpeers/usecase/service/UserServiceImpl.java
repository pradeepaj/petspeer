package com.petpeers.usecase.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petpeers.usecase.dto.UserDto;
import com.petpeers.usecase.entity.Pet;
import com.petpeers.usecase.entity.User;
import com.petpeers.usecase.exception.DataNotFoundException;
import com.petpeers.usecase.repository.PetRepository;
import com.petpeers.usecase.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PetRepository petRepository;

	@Override
	public User addUser(UserDto userDto) {

		User user = new User();
		BeanUtils.copyProperties(userDto, user, "confirmPassword");
		return userRepository.save(user);

	}

	@Override
	public List<Pet> getMyPets(Long userId) throws DataNotFoundException {
		if (petRepository.findByUserid(userId).size() == 0) {
			throw new DataNotFoundException("Data not found " + userId + " Please enter vaild userId");
		}
		return petRepository.findByUserid(userId);
	}

	@Override
	public String buyPet(long petId, long userId) {

		Pet pet = petRepository.findByPetId(petId);

		User user = userRepository.findByUserId(userId);
		pet.setAction("Sold");
		pet.setUser(user);

		petRepository.save(pet);
		return "Order placed successfully";

	}

}
