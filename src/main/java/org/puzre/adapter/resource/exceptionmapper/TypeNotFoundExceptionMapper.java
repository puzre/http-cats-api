package org.puzre.adapter.resource.exceptionmapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.puzre.adapter.resource.dto.response.ErrorResponseDto;
import org.puzre.core.exception.TypeNotFoundException;

@Provider
public class TypeNotFoundExceptionMapper implements ExceptionMapper<TypeNotFoundException> {
    @Override
    public Response toResponse(TypeNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(ErrorResponseDto.builder()
                        .message(e.getMessage())
                        .build())
                .build();
    }
}
