package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_usuario")
@Getter @Setter
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
    private String nome;
	
    public Usuario() {}
	
}