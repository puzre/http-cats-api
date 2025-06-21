package org.puzre.adapter.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.puzre.core.port.service.ICatService;
import org.puzre.core.port.service.ITypeService;

@Path("/type")
public class TypeResource {

    private final ITypeService iTypeService;
    private final ICatService iCatService;

    public TypeResource(ITypeService iTypeService,
                        ICatService iCatService) {
        this.iTypeService = iTypeService;
        this.iCatService = iCatService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response listAllTypes() {
        return Response.ok(iTypeService.listAllTypes()).build();
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

}
