package org.puzre.adapter.resource.exceptionmapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.puzre.core.exception.InvalidNumberException;

@Provider
public class InvalidNumberExceptionMapper implements ExceptionMapper<InvalidNumberException> {
    @Override
    public Response toResponse(InvalidNumberException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getExceptionInformation()).build();
    }
}
