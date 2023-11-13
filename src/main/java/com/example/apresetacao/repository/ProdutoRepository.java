package com.example.apresetacao.repository;

import org.springframework.stereotype.Repository;

import com.example.apresetacao.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
