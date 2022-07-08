package com.example.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	List<User> findByNamaContainingIgnoreCase(String nama);

}
