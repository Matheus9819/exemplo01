package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.demo.entity.Produto;
import com.example.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public ProdutoService() {}
	
	public List<Produto> retornarTodos(){
		
	return (List<Produto>) produtoRepository.findAll();
			
}
	public Optional<Produto> retornarProduto(int idProduto) {
		return produtoRepository.findById(idProduto);
	}
	
	public void salvarProduto (Produto prod) {
		produtoRepository.save(prod);
	}
	
	
	@DeleteMapping(path="/{idProduto}")
	public void removerProduto(int idProduto) {
		produtoRepository.deleteById(idProduto);
	}
}
