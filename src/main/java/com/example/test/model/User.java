package com.example.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue
	private int id_user;
	private String nama;
	private String no_hp;
	private String email;
	private String alamat;
	
	@ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
}
