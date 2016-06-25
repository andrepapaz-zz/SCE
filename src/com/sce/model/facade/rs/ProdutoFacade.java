package com.sce.model.facade.rs;

import com.sce.model.domain.Produto;
import com.sce.model.exceptions.SCEApplicationException;
import com.sce.model.service.ProdutoService;
import org.hibernate.exception.ConstraintViolationException;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Andre on 22/05/2016.
 */
@Path("/produto")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON})
public class ProdutoFacade {

    @Inject
    private ProdutoService produtoService;

    @GET
    public List<Produto> getProdutos() {
        return produtoService.getProdutos();
    }

    @POST
    public Produto inserir(Produto produto) {
        return produtoService.inserir(produto);
    }

    @PUT
    public void alterar(Produto produto) {
        produtoService.alterar(produto);
    }

    @DELETE
    @Path("/{codigoProduto}")
    public void excluir(@PathParam("codigoProduto") Integer codigoProduto) {
        Produto produto = new Produto();
        produto.setCodigo(codigoProduto);
        produtoService.excluir(produto);
    }

}
