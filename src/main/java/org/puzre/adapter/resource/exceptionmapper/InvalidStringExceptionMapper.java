package org.puzre.adapter.resource.exceptionmapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.puzre.core.exception.InvalidStringException;

@Provider
public class InvalidStringExceptionMapper implements ExceptionMapper<InvalidStringException> {
    @Override
    public Response toResponse(InvalidStringException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getExceptionInformation()).build();
    }
}
