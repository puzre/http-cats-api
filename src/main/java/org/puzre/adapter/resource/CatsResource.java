package org.puzre.adapter.resource;

import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.puzre.adapter.resource.dto.request.CatMessageRequestDto;
import org.puzre.adapter.resource.dto.request.PageRequestDto;
import org.puzre.adapter.resource.dto.response.CatResponseDto;
import org.puzre.adapter.resource.dto.response.PageResponseDto;
import org.puzre.adapter.resource.mapper.CatPageToResponseDtoMapper;
import org.puzre.adapter.resource.mapper.CatToResponseDtoMapper;
import org.puzre.application.port.usecase.cats.IListAllCatsLegacyUseCase;
import org.puzre.application.port.usecase.cats.IListAllCatsUseCase;
import org.puzre.application.port.usecase.cats.ISearchCatsByMessageLegacyUseCase;
import org.puzre.application.port.usecase.cats.ISearchCatsByMessageUseCase;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;

import java.util.List;

@Path("http-cats/cats")
@RequiredArgsConstructor
public class CatsResource {

    private final IListAllCatsLegacyUseCase iListAllCatsLegacyUseCase;
    private final IListAllCatsUseCase iListAllCatsUseCase;
    private final ISearchCatsByMessageLegacyUseCase iSearchCatsByMessageLegacyUseCase;
    private final ISearchCatsByMessageUseCase iSearchCatsByMessageUseCase;

    private final CatPageToResponseDtoMapper catPageToResponseDtoMapper;
    private final CatToResponseDtoMapper catToResponseDtoMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/legacy")
    public Response listAllCatsLegacy() {
        List<CatResponseDto> catResponseDtoList = iListAllCatsLegacyUseCase.execute()
                .stream()
                .map(catToResponseDtoMapper::toResponseDto)
                .toList();
        return Response.ok(catResponseDtoList).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllCats(
            @Valid @BeanParam
            PageRequestDto pageRequestDto) {
        Page<Cat> page = iListAllCatsUseCase.execute(pageRequestDto.getPage(), pageRequestDto.getSize());
        PageResponseDto<CatResponseDto> pageResponseDto = catPageToResponseDtoMapper.toResponseDto(page);
        return Response.ok(pageResponseDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/legacy/search")
    public Response searchCatsByMessageLegacy(
            @Valid @BeanParam
            CatMessageRequestDto catMessageRequestDto
    ) {
        List<CatResponseDto> catResponseDtoList = iSearchCatsByMessageLegacyUseCase.execute(catMessageRequestDto.getMessage())
                .stream()
                .map(catToResponseDtoMapper::toResponseDto)
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
        Page<Cat> page = iSearchCatsByMessageUseCase.execute(
                catMessageRequestDto.getMessage(),
                pageRequestDto.getPage(),
                pageRequestDto.getSize());
        PageResponseDto<CatResponseDto> pageResponseDto = catPageToResponseDtoMapper.toResponseDto(page);
        return Response.ok(pageResponseDto).build();
    }

}
