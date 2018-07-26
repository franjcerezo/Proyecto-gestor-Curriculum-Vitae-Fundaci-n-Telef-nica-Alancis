package com.selectcv.repository;

import org.springframework.data.repository.CrudRepository;

import com.selectcv.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);

	User findByEmail(String email);
}