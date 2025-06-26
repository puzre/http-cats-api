package org.puzre.adapter.resource.exceptionmapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.puzre.core.exception.CatNotFoundException;

@Provider
public class CatNotFoundExceptionMapper implements ExceptionMapper<CatNotFoundException> {
    @Override
    public Response toResponse(CatNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND).entity(e.getExceptionInformation()).build();
    }
}
