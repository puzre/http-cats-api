package org.puzre.adapter.resource;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.puzre.adapter.resource.dto.request.PaginationQueryParamsRequestDto;
import org.puzre.adapter.resource.dto.response.CatResponseDto;
import org.puzre.adapter.resource.dto.response.PageResponseDto;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;
import org.puzre.core.port.mapper.adapter.IDomainToResponseMapper;
import org.puzre.core.port.service.ICatService;

import java.util.List;

@Path("http-cats/cat")
public class CatResource {

    private final ICatService iCatService;

    private final IDomainToResponseMapper<Cat, CatResponseDto> iCatToResponseDtoMapper;
    private final IDomainToResponseMapper<Page<Cat>, PageResponseDto<CatResponseDto>> iCatPageToResponseDtoMapper;

    public CatResource(
            ICatService iCatService,
            IDomainToResponseMapper<Cat, CatResponseDto> iCatToResponseDtoMapper,
            IDomainToResponseMapper<Page<Cat>, PageResponseDto<CatResponseDto>> iCatPageToResponseDtoMapper
    ) {
        this.iCatService = iCatService;
        this.iCatToResponseDtoMapper = iCatToResponseDtoMapper;
        this.iCatPageToResponseDtoMapper = iCatPageToResponseDtoMapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all/legacy")
    public Response listAllCatsLegacy() {

        List<CatResponseDto> catResponseDtoList = iCatService.listAllCatsLegacy()
                .stream()
                .map(iCatToResponseDtoMapper::toResponseDto)
                .toList();

        return Response.ok(catResponseDtoList).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response listAllCats(
            @Valid @BeanParam
            PaginationQueryParamsRequestDto paginationQueryParamsRequestDto)
    {
        Page<Cat> page = iCatService.listAllCats(
                paginationQueryParamsRequestDto.getPage(),
                paginationQueryParamsRequestDto.getTotalItems());

        PageResponseDto<CatResponseDto> pageResponseDto = iCatPageToResponseDtoMapper.toResponseDto(page);

        return Response.ok(pageResponseDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{catId}")
    public Response getCatById(@PathParam("catId") int catId) {
        return Response.ok(iCatService.findCatById(catId)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/legacy/search")
    public Response searchCatsByMessageLegacy(@QueryParam("message") String message) {
        return Response.ok(iCatService.searchCatsByMessageLegacy(message)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    public Response searchCatsByMessage(@QueryParam("message") String message,
                                        @QueryParam("page") int page,
                                        @QueryParam("totalItems") int totalItems) {
        return Response.ok(iCatService.searchCatsByMessage(message, page, totalItems)).build();
    }

}
