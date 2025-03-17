package com.example.projetoac1.repositories;

import com.example.projetoac1.models.Produto;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto salvar(Produto produto) {
        return entityManager.merge(produto);
    }

    @Transactional
    public Produto editar(Produto produto) {
        return entityManager.merge(produto);
    }

    @Transactional
    public void excluir(Long id) {
        Produto produto = entityManager.find(Produto.class, id);
        if (produto != null) {
            entityManager.remove(produto);
        }
    }

    public List<Produto> obterTodos() {
        return entityManager.createQuery("from tbl_produtos", Produto.class)
                .getResultList();
    }

    public Optional<Produto> selecionarPorId(Long id) {
        Produto produto = entityManager.find(Produto.class, id);
        return Optional.ofNullable(produto);
    }
}
