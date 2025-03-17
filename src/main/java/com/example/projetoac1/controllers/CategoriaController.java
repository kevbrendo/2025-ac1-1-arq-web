package com.example.projetoac1.controllers;

import com.example.projetoac1.models.Categoria;
import com.example.projetoac1.repositories.CategoriaProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;

    @GetMapping
    public List<Categoria> getTodasCategorias() {
        return categoriaProdutoRepository.obterTodos();
    }

    @PostMapping()
    public Categoria postCategoria(@RequestBody Categoria categoria) {
        return categoriaProdutoRepository.salvar(categoria);
    }

}
