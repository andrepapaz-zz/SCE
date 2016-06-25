package com.sce.model.dao;

import com.sce.model.domain.Produto;
import com.sce.model.exceptions.SCEApplicationException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Andre on 22/05/2016.
 */
public class ProdutoDaoImpl implements ProdutoDao {

    @PersistenceContext(unitName = "SCEPU")
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<Produto> getProdutos() {
        Query query = entityManager.createQuery("from Produto");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Produto inserir(Produto produto) {
        entityManager.persist(produto);
        return produto;
    }

    @Override
    @Transactional
    public void alterar(Produto produto) {
        Produto produtoMerge = entityManager.merge(produto);
        entityManager.persist(produtoMerge);
    }

    @Override
    @Transactional
    public void excluir(Produto produto) {
        Produto produtoMerge = entityManager.merge(produto);
        entityManager.remove(produtoMerge);
    }
}
