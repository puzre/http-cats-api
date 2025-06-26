package org.puzre.adapter.resource.exceptionmapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.puzre.core.exception.TypeNotFoundException;

@Provider
public class TypeNotFoundExceptionMapper implements ExceptionMapper<TypeNotFoundException> {
    @Override
    public Response toResponse(TypeNotFoundException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getExceptionInformation()).build();
    }
}
