package org.puzre.adapter.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.puzre.adapter.resource.dto.response.TypeResponseDto;
import org.puzre.adapter.resource.mapper.TypeToResponseDtoMapper;
import org.puzre.application.port.usecase.types.IListAllTypesUseCase;

import java.util.List;

@Path("http-cats/types")
@RequiredArgsConstructor
public class TypesResource {

    private final IListAllTypesUseCase iListAllTypesUseCase;

    private final TypeToResponseDtoMapper typeToResponseDtoMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllTypes() {
        List<TypeResponseDto> typeResponseDtoList = iListAllTypesUseCase.execute()
                .stream()
                .map(typeToResponseDtoMapper::toResponseDto)
                .toList();
        return Response.ok(typeResponseDtoList).build();
    }

}
