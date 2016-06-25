package com.sce.model.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Andre on 01/06/2016.
 */
public class SCEApplicationException extends WebApplicationException {
    public SCEApplicationException(String message) {
        super(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(message).type(MediaType.TEXT_HTML).build());
    }
}
