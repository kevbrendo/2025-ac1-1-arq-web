package com.example.projetoac1.repositories;

import com.example.projetoac1.models.Categoria;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaProdutoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Categoria salvar(Categoria categoria) {
        return entityManager.merge(categoria);
    }

    public Categoria editar(Categoria produto) {
        return entityManager.merge(produto);
    }

    @Transactional
    public void excluir(Long id) {
        Categoria produto = entityManager.find(Categoria.class, id);
        if (produto != null) {
            entityManager.remove(produto);
        }
    }

    public Optional<Categoria> selecionarPorId(Long id) {
        Categoria produto = entityManager.find(Categoria.class, id);
        return Optional.ofNullable(produto);
    }

    public List<Categoria> obterTodos() {
        return entityManager.createQuery("from tbl_categorias", Categoria.class)
                .getResultList();
    }
}
