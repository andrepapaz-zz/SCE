package com.sce.model.service;

import com.sce.model.domain.Produto;
import com.sce.model.dao.ProdutoDao;
import com.sce.model.exceptions.SCEApplicationException;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import java.util.List;

/**
 * Created by Andre on 22/05/2016.
 */
public class ProdutoServiceImpl implements ProdutoService {

    @Inject
    private ProdutoDao produtoDao;

    @Override
    public List<Produto> getProdutos() {
        return produtoDao.getProdutos();
    }

    @Override
    public Produto inserir(Produto produto) {
        try {
            return produtoDao.inserir(produto);
        } catch (PersistenceException e) {
            throw new SCEApplicationException("Produto já existe. Favor digite outra Descrição");
        }
    }

    @Override
    public void alterar(Produto produto) {
        try {
            produtoDao.alterar(produto);
        } catch (Exception e) {
            throw new SCEApplicationException("Produto já existe. Favor digite outra Descrição");
        }
    }

    @Override
    public void excluir(Produto produto) {
        try {
            produtoDao.excluir(produto);
        } catch (Exception e) {
            throw new SCEApplicationException("Produto possúi relacionamento, não é possível excluí-lo");
        }
    }
}
