package com.example.apresetacao.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apresetacao.dtos.ProdutoDTO;
import com.example.apresetacao.model.Produto;
import com.example.apresetacao.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoDTO> findAll() {
        List<Produto> list = repository.findAll();
        return list.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
    }

    public ProdutoDTO findById(Long id){
        Optional<Produto> prod = repository.findById(id);
        if(!prod.isPresent()){
            return null;
        }
        return new ProdutoDTO(prod.get());
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public ProdutoDTO update(ProdutoDTO produto){
        Produto prod = new Produto(produto);
        return new ProdutoDTO(repository.save(prod));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public boolean deleteUpdate(Long id){
        Optional<Produto> produto = repository.findById(id);
        if (!produto.isPresent()){
            return false;
        }
        produto.get().delete();
        repository.save(produto.get());
        return true;
    }
}
