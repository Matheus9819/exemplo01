package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping(path="/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService UsuarioService;
	
	@GetMapping(path="/todos")
    public List<Usuario> retornarTodos(){
		
		return UsuarioService.retornarTodos();
	}
	
	
	@GetMapping(path="/{idusuario}")
	public Optional<Usuario> retornarTodos(@PathVariable("idUsuario") int idUsuario){
		
		return UsuarioService.retornarUsuario(idUsuario);
	}
	
	@PostMapping()
	public void incluirUsuario (@RequestBody Usuario user) {
	  Usuario p = new Usuario();
	  p.setNome(user.getNome());
	  UsuarioService.salvarUsuario(p);
	}
	
	@PutMapping()
	public void alterarUsuario (@RequestBody Usuario user) {
	  Usuario p = new Usuario();
	  p.setId(user.getId());
	  p.setNome(user.getNome());
	  UsuarioService.salvarUsuario(p);
	}
	
	@DeleteMapping(path="/{idUsuario}")
	public void removerUsuario(@PathVariable("idUsuario") int idUsuario) {
		UsuarioService.removerUsuario(idUsuario);
	}
	
}
