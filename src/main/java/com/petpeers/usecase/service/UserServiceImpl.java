package com.petpeers.usecase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petpeers.usecase.dto.UserDto;
import com.petpeers.usecase.entity.Pet;
import com.petpeers.usecase.entity.User;
import com.petpeers.usecase.repository.PetRepository;
import com.petpeers.usecase.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PetRepository petRepository;

	@Override
	public String addUser(UserDto userDto) {
		if (userDto != null) {

			if (userDto.getPassword().equals(userDto.getConfirmPassword())) {
				User user = new User();
				user.setName(userDto.getName());
				user.setPassword(userDto.getPassword());
				userRepository.save(user);
				return "Your successfully registered please sign in";
			} else {
				return "Password is incorrect";
			}

		} else {
			return "Wrong credentials";
		}

	}

	@Override
	public List<Pet> getMyPets(Long userId) {
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
