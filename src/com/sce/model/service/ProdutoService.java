package com.sce.model.service;

import com.sce.model.domain.Produto;

import java.util.List;

/**
 * Created by Andre on 22/05/2016.
 */
public interface ProdutoService {

    List<Produto> getProdutos();

    Produto inserir(Produto produto);

    void alterar(Produto produto);

    void excluir(Produto produto);
}
