package com.example.projetoac1;

import java.util.List;

import com.example.projetoac1.models.Categoria;
import com.example.projetoac1.models.Produto;
import com.example.projetoac1.repositories.CategoriaProdutoRepository;
import com.example.projetoac1.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjetoAc1Application {

	@Bean
	public CommandLineRunner init(
			@Autowired CategoriaProdutoRepository categoriaProdutoRepository,
			@Autowired ProdutoRepository produtoRepository) {
		return args -> {
			Categoria categoria1 = new Categoria(null, "informatica", "categoria para produtos informatica", null);
			Categoria categoria2 = new Categoria(null, "roupas", "categoria para produtos de roupas", null);
			categoriaProdutoRepository.salvar(categoria1);
			categoriaProdutoRepository.salvar(categoria2);

			produtoRepository.salvar(new Produto(null, "mouse", 10, categoria1));
			produtoRepository.salvar(new Produto(null, "meia", 10, categoria2));

			List<Categoria> listaCategorias = categoriaProdutoRepository.obterTodos();
			System.out.println("*** Categorias cadastradas:");
			listaCategorias.forEach(System.out::println);
			System.out.println("*** Produtos cadastrados:");
			List<Produto> listaProdutos = produtoRepository.obterTodos();
			listaProdutos.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoAc1Application.class, args);
	}

}
