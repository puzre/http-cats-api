package org.puzre.adapter.resource;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.puzre.adapter.resource.dto.request.CatIdRequestDto;
import org.puzre.adapter.resource.dto.response.CatResponseDto;
import org.puzre.core.domain.Cat;
import org.puzre.adapter.resource.mapper.spi.IDomainToResponseMapper;
import org.puzre.core.port.service.ICatService;


@Path("http-cats/cat")
public class CatResource {

    private final ICatService iCatService;

    private final IDomainToResponseMapper<Cat, CatResponseDto> iCatToResponseDtoMapper;

    public CatResource(
            ICatService iCatService,
            IDomainToResponseMapper<Cat, CatResponseDto> iCatToResponseDtoMapper
    ) {
        this.iCatService = iCatService;
        this.iCatToResponseDtoMapper = iCatToResponseDtoMapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{catId}")
    public Response getCatById(
            @Valid @BeanParam
            CatIdRequestDto catIdRequestDto
    ) {
        Cat cat = iCatService.findCatById(catIdRequestDto.getCatId());

        CatResponseDto catResponseDto = iCatToResponseDtoMapper.toResponseDto(cat);

        return Response.ok(catResponseDto).build();
    }

}
