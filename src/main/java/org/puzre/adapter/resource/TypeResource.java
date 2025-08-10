package org.puzre.adapter.resource;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.puzre.adapter.resource.dto.request.PageRequestDto;
import org.puzre.adapter.resource.dto.request.TypeIdRequestDto;
import org.puzre.adapter.resource.dto.response.CatResponseDto;
import org.puzre.adapter.resource.dto.response.PageResponseDto;
import org.puzre.adapter.resource.dto.response.TypeResponseDto;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;
import org.puzre.core.domain.Type;
import org.puzre.adapter.resource.mapper.spi.IDomainToResponseMapper;
import org.puzre.core.port.service.ICatService;
import org.puzre.core.port.service.ITypeService;

import java.util.List;

@Path("http-cats/type")
public class TypeResource {

    private final ITypeService iTypeService;
    private final ICatService iCatService;

    private final IDomainToResponseMapper<Type, TypeResponseDto> iTypeToResponseDtoMapper;
    private final IDomainToResponseMapper<Cat, CatResponseDto> iCatToResponseDtoMapper;
    private final IDomainToResponseMapper<Page<Cat>, PageResponseDto<CatResponseDto>> iCatPageToResponseDtoMapper;

    public TypeResource(
            ITypeService iTypeService,
            ICatService iCatService,
            IDomainToResponseMapper<Type, TypeResponseDto> iTypeToResponseDtoMapper,
            IDomainToResponseMapper<Cat, CatResponseDto> iCatToResponseDtoMapper,
            IDomainToResponseMapper<Page<Cat>, PageResponseDto<CatResponseDto>> iCatPageToResponseDtoMapper) {
        this.iTypeService = iTypeService;
        this.iCatService = iCatService;
        this.iTypeToResponseDtoMapper = iTypeToResponseDtoMapper;
        this.iCatToResponseDtoMapper = iCatToResponseDtoMapper;
        this.iCatPageToResponseDtoMapper = iCatPageToResponseDtoMapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{typeId}")
    public Response getTypeById(
            @Valid @BeanParam
            TypeIdRequestDto typeIdRequestDto
    ) {
        Type type = iTypeService.findTypeById(typeIdRequestDto.getTypeId());
        TypeResponseDto typeResponseDto = iTypeToResponseDtoMapper.toResponseDto(type);
        return Response.ok(typeResponseDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{typeId}/cats/legacy")
    public Response listCatsLegacyByType(
            @Valid @BeanParam
            TypeIdRequestDto typeIdRequestDto
    ) {
        List<CatResponseDto> catResponseDtoList = iCatService.listCatsLegacyByType(typeIdRequestDto.getTypeId())
                .stream()
                .map(iCatToResponseDtoMapper::toResponseDto)
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
        Page<Cat> page = iCatService.listCatsByType(
                typeIdRequestDto.getTypeId(),
                pageRequestDto.getPage(),
                pageRequestDto.getSize()
        );

        PageResponseDto<CatResponseDto> pageResponseDto = iCatPageToResponseDtoMapper.toResponseDto(page);

        return Response.ok(pageResponseDto).build();
    }

}
