package com.insurance.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

	// User findByName(String name);

	

}
