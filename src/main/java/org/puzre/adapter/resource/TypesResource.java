package org.puzre.adapter.resource;

import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.puzre.adapter.resource.dto.request.PageRequestDto;
import org.puzre.adapter.resource.dto.request.TypeIdRequestDto;
import org.puzre.adapter.resource.dto.response.CatResponseDto;
import org.puzre.adapter.resource.dto.response.PageResponseDto;
import org.puzre.adapter.resource.dto.response.TypeResponseDto;
import org.puzre.adapter.resource.mapper.spi.IDomainToResponseMapper;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;
import org.puzre.core.domain.Type;
import org.puzre.core.port.service.ICatService;
import org.puzre.core.port.service.ITypeService;

import java.util.List;

@Path("http-cats/types")
public class TypesResource {

    private final ITypeService iTypeService;

    private final IDomainToResponseMapper<Type, TypeResponseDto> iTypeToResponseDtoMapper;

    public TypesResource(
            ITypeService iTypeService,
            ICatService iCatService,
            IDomainToResponseMapper<Type, TypeResponseDto> iTypeToResponseDtoMapper) {
        this.iTypeService = iTypeService;
        this.iTypeToResponseDtoMapper = iTypeToResponseDtoMapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllTypes() {

        List<TypeResponseDto> typeResponseDtoList = iTypeService.listAllTypes()
                .stream()
                .map(iTypeToResponseDtoMapper::toResponseDto)
                .toList();

        return Response.ok(typeResponseDtoList).build();
    }

}
