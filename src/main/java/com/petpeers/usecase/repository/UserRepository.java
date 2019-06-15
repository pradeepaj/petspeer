package com.petpeers.usecase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petpeers.usecase.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByNameAndPassword(String name, String password);

	User findByUserId(long userId);

}
