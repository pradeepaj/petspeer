package com.petpeers.usecase.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petpeers.usecase.entity.Pet;
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

	@Query(value="select *from petpeers.pets_details where user_user_id=?", nativeQuery = true)
	List<Pet> findByUserid(Long userId);

	Pet findByPetId(long petId);





}
