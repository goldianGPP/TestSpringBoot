package com.example.test.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.DTO.UserDTO;
import com.example.test.model.User;
import com.example.test.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserService service;

	@PostMapping("/add")
	public ResponseEntity<UserDTO> addUser(@RequestBody User user) {
		logger.warn("Check warning");
		logger.warn(service.postUser(user));
		return new ResponseEntity<UserDTO>(mapper.map(user, UserDTO.class), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<UserDTO> updateUser(@RequestBody User user) {
		service.putUser(user);
		return new ResponseEntity<UserDTO>(mapper.map(user, UserDTO.class), HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable int id){
		service.deleteUser(id);
		return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<List<UserDTO>> fetchUsers(){
		return new ResponseEntity<List<UserDTO>>(service.getUsers().stream().map(user -> mapper.map(user, UserDTO.class))
				.collect(Collectors.toList()), HttpStatus.OK);
	}

	@GetMapping("/get/{nama}")
	public ResponseEntity<List<UserDTO>> fetchUsers(@PathVariable String nama){
		return new ResponseEntity<List<UserDTO>>(service.getUsers(nama).stream().map(user -> mapper.map(user, UserDTO.class))
				.collect(Collectors.toList()), HttpStatus.OK);
	}
}
