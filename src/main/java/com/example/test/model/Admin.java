package com.example.test.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue
	private int id_admin;
	private String nama;
	private String no_hp;
	private String email;
	private String alamat;
	
	@OneToMany(mappedBy = "admin")
    private List<User> users;
}
