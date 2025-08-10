package org.puzre.adapter.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.puzre.adapter.resource.dto.response.TypeResponseDto;
import org.puzre.core.domain.Type;
import org.puzre.core.port.mapper.adapter.IDomainToResponseMapper;
import org.puzre.core.port.service.ICatService;
import org.puzre.core.port.service.ITypeService;

import java.util.List;

@Path("http-cats/type")
public class TypeResource {

    private final ITypeService iTypeService;
    private final ICatService iCatService;

    private final IDomainToResponseMapper<Type, TypeResponseDto> iTypeToResponseDtoMapper;

    public TypeResource(
            ITypeService iTypeService,
            ICatService iCatService,
            IDomainToResponseMapper<Type, TypeResponseDto> iTypeToResponseDtoMapper) {
        this.iTypeService = iTypeService;
        this.iCatService = iCatService;
        this.iTypeToResponseDtoMapper = iTypeToResponseDtoMapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response listAllTypes() {

        List<TypeResponseDto> typeResponseDtoList = iTypeService.listAllTypes()
                .stream()
                .map(iTypeToResponseDtoMapper::toResponseDto)
                .toList();

        return Response.ok(typeResponseDtoList).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{typeId}/cat/legacy")
    public Response listCatsLegacyByType(@PathParam("typeId") int typeId) {
        return Response.ok(iCatService.listCatsLegacyByType(typeId)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{typeId}/cat")
    public Response listCatsByType(@PathParam("typeId") int typeId, @QueryParam("page") int page, @QueryParam("totalItems") int totalItems) {
        return Response.ok(iCatService.listCatsByType(typeId, page, totalItems)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{typeId}")
    public Response getTypeById(@PathParam("typeId") int typeId) {
        return Response.ok(iTypeService.findTypeById(typeId)).build();
    }

}
