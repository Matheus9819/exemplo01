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

import com.example.demo.entity.Produto;
import com.example.demo.service.ProdutoService;

@RestController
@RequestMapping(path="/produto")
//@RequestMapping(path="/usuario")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(path="/todos")
    public List<Produto> retornarTodos(){
		
		return produtoService.retornarTodos();
	}
	
	
	@GetMapping(path="/{idProduto}")
	public Optional<Produto> retornarTodos(@PathVariable("idProduto") int idProduto){
		
		return produtoService.retornarProduto(idProduto);
	}
	
	@PostMapping()
	public void incluirProduto (@RequestBody Produto prod) {
	  Produto p = new Produto();
	  p.setNome(prod.getNome());
	  p.setValor(prod.getValor());
	  produtoService.salvarProduto(p);
	}
	
	@PutMapping()
	public void alterarProduto (@RequestBody Produto prod) {
	  Produto p = new Produto();
	  p.setId(prod.getId());
	  p.setNome(prod.getNome());
	  p.setValor(prod.getValor());
	  produtoService.salvarProduto(p);
	}
	
	@DeleteMapping(path="/{idProduto}")
	public void removerProduto(@PathVariable("idProduto") int idProduto) {
		produtoService.removerProduto(idProduto);
	}
	
}
