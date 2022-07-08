package com.example.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.model.Admin;

public interface AdminRepository  extends JpaRepository<Admin, Integer>{
	
	List<Admin> findByNamaContainingIgnoreCase(String nama);

}
