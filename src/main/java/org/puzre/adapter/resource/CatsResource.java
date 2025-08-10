package org.puzre.adapter.resource;

import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.puzre.adapter.resource.dto.request.CatMessageRequestDto;
import org.puzre.adapter.resource.dto.request.PageRequestDto;
import org.puzre.adapter.resource.dto.response.CatResponseDto;
import org.puzre.adapter.resource.dto.response.PageResponseDto;
import org.puzre.adapter.resource.mapper.spi.IDomainToResponseMapper;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;
import org.puzre.core.port.service.ICatService;

import java.util.List;

@Path("http-cats/cats")
public class CatsResource {

    private final ICatService iCatService;

    private final IDomainToResponseMapper<Cat, CatResponseDto> iCatToResponseDtoMapper;
    private final IDomainToResponseMapper<Page<Cat>, PageResponseDto<CatResponseDto>> iCatPageToResponseDtoMapper;

    public CatsResource(
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
    @Path("/legacy")
    public Response listAllCatsLegacy() {

        List<CatResponseDto> catResponseDtoList = iCatService.listAllCatsLegacy()
                .stream()
                .map(iCatToResponseDtoMapper::toResponseDto)
                .toList();

        return Response.ok(catResponseDtoList).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllCats(
            @Valid @BeanParam
            PageRequestDto pageRequestDto) {
        Page<Cat> page = iCatService.listAllCats(
                pageRequestDto.getPage(),
                pageRequestDto.getSize());

        PageResponseDto<CatResponseDto> pageResponseDto = iCatPageToResponseDtoMapper.toResponseDto(page);

        return Response.ok(pageResponseDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/legacy/search")
    public Response searchCatsByMessageLegacy(
            @Valid @BeanParam
            CatMessageRequestDto catMessageRequestDto
    ) {
        List<CatResponseDto> catResponseDtoList = iCatService.searchCatsByMessageLegacy(catMessageRequestDto.getMessage())
                .stream()
                .map(iCatToResponseDtoMapper::toResponseDto)
                .toList();

        return Response.ok(catResponseDtoList).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    public Response searchCatsByMessage(
            @Valid @BeanParam
            CatMessageRequestDto catMessageRequestDto,
            @Valid @BeanParam
            PageRequestDto pageRequestDto
    ) {
        Page<Cat> page = iCatService.searchCatsByMessage(
                catMessageRequestDto.getMessage(),
                pageRequestDto.getPage(),
                pageRequestDto.getSize());

        PageResponseDto<CatResponseDto> pageResponseDto = iCatPageToResponseDtoMapper.toResponseDto(page);

        return Response.ok(pageResponseDto).build();
    }

}
