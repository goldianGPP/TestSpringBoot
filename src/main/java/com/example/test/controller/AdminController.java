package com.example.test.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.example.test.DTO.AdminDTO;
import com.example.test.model.Admin;
import com.example.test.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AdminService service;
	
	@PostMapping("/add")
	public ResponseEntity<AdminDTO> addAdmin(@RequestBody Admin admin) {
		service.postAdmin(admin);
		return new ResponseEntity<AdminDTO>(mapper.map(admin, AdminDTO.class), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<AdminDTO> updateAdmin(@RequestBody Admin admin){
		service.putAdmin(admin);
		return new ResponseEntity<AdminDTO>(mapper.map(admin, AdminDTO.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AdminDTO> deleteAdmin(@PathVariable int id){
		service.deleteAdmin(id);
		return new ResponseEntity<AdminDTO>(new AdminDTO(), HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public List<AdminDTO> fetchAdmins(){
		return service.getAdmin().stream().map(admin -> mapper.map(admin, AdminDTO.class))
				.collect(Collectors.toList());
	}
}
