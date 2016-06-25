package com.sce.model.facade.rs;

import com.sce.model.domain.Produto;
import com.sce.model.domain.TipoEmpresaEnum;
import com.sce.model.service.ProdutoService;
import com.sce.model.service.TipoEmpesaService;
import com.sce.model.wrapper.TipoEmpresaWrapper;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Andre on 27/05/2016.
 */
@Path("/tipoEmpresa")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON})
public class TipoEmpresaFacade {

    @Inject
    private TipoEmpesaService tipoEmpesaService;

    @GET
    public List<TipoEmpresaWrapper> getTipoEmpresas() {
        return tipoEmpesaService.getTipoEmpresas();
    }
}
