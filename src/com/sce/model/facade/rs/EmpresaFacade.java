package com.sce.model.facade.rs;

import com.sce.model.domain.Empresa;
import com.sce.model.domain.Produto;
import com.sce.model.service.EmpresaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Andre on 27/05/2016.
 */
@Path("/empresa")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON})
public class EmpresaFacade {

    @Inject
    private EmpresaService empresaService;

    @GET
    public List<Empresa> getEmpresas() {
        return empresaService.getEmpresas();
    }

    @POST
    public Empresa inserir(Empresa empresa) {
        return empresaService.inserir(empresa);
    }

    @PUT
    public void alterar(Empresa empresa) {
        empresaService.alterar(empresa);
    }

    @DELETE
    @Path("/{codigoEmpresa}")
    public void excluir(@PathParam("codigoEmpresa") Integer codigoEmpresa) {
        Empresa empresa = new Empresa();
        empresa.setCodigo(codigoEmpresa);
        empresaService.excluir(empresa);
    }
}
