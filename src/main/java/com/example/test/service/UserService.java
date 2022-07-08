package com.example.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.model.User;
import com.example.test.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public User postUser(User user) {
		return repository.save(user);
	}
	
	public User putUser(User user) {
		return repository.save(user);
	}
	
	public void deleteUser(int id) {
		repository.deleteById(id);
	}
	
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	public List<User> getUsers(String nama){
		return repository.findByNamaContainingIgnoreCase(nama);
	}
}
