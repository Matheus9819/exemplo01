package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
