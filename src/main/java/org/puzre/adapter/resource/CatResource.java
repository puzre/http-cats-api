package org.puzre.adapter.resource;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.puzre.adapter.resource.dto.request.CatIdRequestDto;
import org.puzre.adapter.resource.dto.response.CatResponseDto;
import org.puzre.adapter.resource.mapper.CatToResponseDtoMapper;
import org.puzre.application.port.usecase.cat.IFindCatByIdUseCase;
import org.puzre.core.domain.Cat;


@Path("http-cats/cat")
@RequiredArgsConstructor
public class CatResource {

    private final IFindCatByIdUseCase iFindCatByIdUseCase;

    private final CatToResponseDtoMapper catToResponseDtoMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{catId}")
    public Response getCatById(
            @Valid @BeanParam
            CatIdRequestDto catIdRequestDto
    ) {
        Cat cat = iFindCatByIdUseCase.execute(catIdRequestDto.getCatId());
        CatResponseDto catResponseDto = catToResponseDtoMapper.toResponseDto(cat);
        return Response.ok(catResponseDto).build();
    }

}
