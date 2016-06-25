package com.sce.model.facade.rs;

/**
 * Created by Andre on 28/05/2016.
 */

import com.sce.model.service.TipoNFService;
import com.sce.model.wrapper.TipoNFWrapper;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tipoNF")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON})
public class TipoNFFacade {

    @Inject
    private TipoNFService tipoNfService;

    @GET
    public List<TipoNFWrapper> getTipoNF() {
        return tipoNfService.getTipoNF();
    }
}
