package com.petpeers.usecase.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.petpeers.usecase.entity.Pet;
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

	@Query(value="select * from petpeers.pets p where ownerid=?1",nativeQuery = true)
	List<Pet> findByUserid(Long userId);

	Pet findByPetId(long petId);

	
	
	 @Transactional
	 @Modifying
	 @Query(
	 value="update Pet p set p.action='sold',p.user.userId=:userId where p.petId=:petId"
	 ) void buyPet(@Param(value = "petId") Long petId,@Param(value = "userId")
	  Long userId);

	//List<Pet> findAllPetPlaceContains(String location);
	
	@Query(value="select * from petpeers.pets p where p.place like %:location%",nativeQuery = true)
	List<Pet> searchbyPlace(@Param(value = "location") String location);


}
