package org.puzre.adapter.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.puzre.core.port.service.ITypeService;

@Path("/type")
public class TypeResource {

    private final ITypeService iTypeService;

    public TypeResource(ITypeService iTypeService) {
        this.iTypeService = iTypeService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response listAllTypes() {
        return Response.ok(iTypeService.listAllTypes()).build();
    }

}
