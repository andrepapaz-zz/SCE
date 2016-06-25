package com.sce.model.facade.rs;

import com.sce.model.domain.NotaFiscal;
import com.sce.model.service.NotaFiscalService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Andre on 29/05/2016.
 */
@Path("/notaFiscal")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON})
public class NotaFiscalFacade {

    @Inject
    private NotaFiscalService notaFiscalService;

    @GET
    public List<NotaFiscal> getNotaFiscals() {
        return notaFiscalService.getNotaFiscais();
    }

    @POST
    public NotaFiscal inserir(NotaFiscal notaFiscal) {
        return notaFiscalService.inserir(notaFiscal);
    }

    @PUT
    public void alterar(NotaFiscal notaFiscal) {
        notaFiscalService.alterar(notaFiscal);
    }

    @DELETE
    @Path("/{codigoNotaFiscal}")
    public void excluir(@PathParam("codigoNotaFiscal") Integer codigoNotaFiscal) {
        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setCodigo(codigoNotaFiscal);
        notaFiscalService.excluir(notaFiscal);
    }

}
