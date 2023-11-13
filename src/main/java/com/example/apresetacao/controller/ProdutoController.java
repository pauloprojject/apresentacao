package com.example.apresetacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apresetacao.dtos.ProdutoDTO;
import com.example.apresetacao.model.Produto;
import com.example.apresetacao.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll(){
        List<ProdutoDTO> list = service.findAll();
        return !list.isEmpty() ?  new ResponseEntity<>(list, HttpStatus.OK) 
                               : new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id){
        ProdutoDTO prod = service.findById(id);
        return prod != null ?  new ResponseEntity<>(prod, HttpStatus.OK) 
							    : new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Produto produto){
        Produto prod = service.save(produto);
        return prod !=  null ? new ResponseEntity<>("Produto criado com sucesso", HttpStatus.CREATED) 
				: new ResponseEntity<>("Erro ao criar produto", HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody ProdutoDTO produto){
        ProdutoDTO prod = service.update(produto);
        return prod !=  null ? new ResponseEntity<>("Produto atualizado com sucesso", HttpStatus.OK) 
							 : new ResponseEntity<>("Erro ao atualizar produto", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
		ProdutoDTO prod = service.findById(id);
		return prod == null ? new ResponseEntity<>("Produto deletado com sucesso", HttpStatus.OK) 
							 : new ResponseEntity<>("Erro ao deletar produto", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteUpdate(@PathVariable Long id){
        boolean bool = service.deleteUpdate(id);
        return bool ? new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK)
                    : new ResponseEntity<>("ID não encontrado.", HttpStatus.NOT_FOUND);
    }
}
