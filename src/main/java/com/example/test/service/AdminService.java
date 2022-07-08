package com.example.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.model.Admin;
import com.example.test.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;
	
	public AdminService(AdminRepository repository) {
		this.repository = repository;
	}
	
	public Admin postAdmin(Admin admin) {
		return repository.save(admin);
	}
	
	public Admin putAdmin(Admin admin) {
		return repository.save(admin);
	}
	
	public void deleteAdmin(int id) {
		repository.deleteById(id);
	}
	
	public List<Admin> getAdmin(){
		return repository.findAll();
	}
	
	public List<Admin> getAdmins(String nama){
		return repository.findByNamaContainingIgnoreCase(nama);
	}
}
