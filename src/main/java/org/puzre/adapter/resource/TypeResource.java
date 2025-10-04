package org.puzre.adapter.resource;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.puzre.adapter.resource.dto.request.PageRequestDto;
import org.puzre.adapter.resource.dto.request.TypeIdRequestDto;
import org.puzre.adapter.resource.dto.response.CatResponseDto;
import org.puzre.adapter.resource.dto.response.PageResponseDto;
import org.puzre.adapter.resource.dto.response.TypeResponseDto;
import org.puzre.adapter.resource.mapper.CatPageToResponseDtoMapper;
import org.puzre.adapter.resource.mapper.CatToResponseDtoMapper;
import org.puzre.adapter.resource.mapper.TypeToResponseDtoMapper;
import org.puzre.application.port.usecase.cats.IListCatsByTypeIdLegacyUseCase;
import org.puzre.application.port.usecase.cats.IListCatsByTypeIdUseCase;
import org.puzre.application.port.usecase.type.IFindTypeByIdUseCase;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;
import org.puzre.core.domain.Type;

import java.util.List;

@Path("http-cats/type")
@RequiredArgsConstructor
public class TypeResource {

    private final IFindTypeByIdUseCase iFindTypeByIdUseCase;
    private final IListCatsByTypeIdLegacyUseCase iListCatsByTypeIdLegacyUseCase;
    private final IListCatsByTypeIdUseCase iListCatsByTypeIdUseCase;

    private final TypeToResponseDtoMapper typeToResponseDtoMapper;
    private final CatToResponseDtoMapper catToResponseDtoMapper;
    private final CatPageToResponseDtoMapper catPageToResponseDtoMapper;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{typeId}")
    public Response getTypeById(
            @Valid @BeanParam
            TypeIdRequestDto typeIdRequestDto
    ) {
        Type type = iFindTypeByIdUseCase.execute(typeIdRequestDto.getTypeId());
        TypeResponseDto typeResponseDto = typeToResponseDtoMapper.toResponseDto(type);
        return Response.ok(typeResponseDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{typeId}/cats/legacy")
    public Response listCatsLegacyByType(
            @Valid @BeanParam
            TypeIdRequestDto typeIdRequestDto
    ) {
        List<CatResponseDto> catResponseDtoList = iListCatsByTypeIdLegacyUseCase.execute(typeIdRequestDto.getTypeId())
                .stream()
                .map(catToResponseDtoMapper::toResponseDto)
                .toList();
        return Response.ok(catResponseDtoList).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{typeId}/cats")
    public Response listCatsByType(
            @Valid @BeanParam
            TypeIdRequestDto typeIdRequestDto,
            @Valid @BeanParam
            PageRequestDto pageRequestDto
    ) {
        Page<Cat> page = iListCatsByTypeIdUseCase.execute(
                typeIdRequestDto.getTypeId(),
                pageRequestDto.getPage(),
                pageRequestDto.getSize()
        );
        PageResponseDto<CatResponseDto> pageResponseDto = catPageToResponseDtoMapper.toResponseDto(page);
        return Response.ok(pageResponseDto).build();
    }

}
