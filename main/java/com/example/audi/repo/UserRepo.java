package com.example.audi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.audi.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	User findByName(String username);

}
