package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioService() {}
	
	public List<Usuario> retornarTodos(){
		
	return (List<Usuario>) usuarioRepository.findAll();
			
}
	public Optional<Usuario> retornarUsuario(int idUsuario) {
		return usuarioRepository.findById(idUsuario);
	}
	
	public void salvarUsuario (Usuario user) {
		usuarioRepository.save(user);
	}
	
	
	@DeleteMapping(path="/{idUsuario}")
	public void removerUsuario(int idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	}
}