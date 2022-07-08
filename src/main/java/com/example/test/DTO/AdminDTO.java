package com.example.test.DTO;

import java.util.List;

import lombok.Data;

@Data
public class AdminDTO {

	private int id_admin;
	private String nama;
	private String no_hp;
	private String email;
	private String alamat;
    private List<UserDTO> users;
}
