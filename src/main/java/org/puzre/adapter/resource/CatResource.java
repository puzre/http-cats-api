package org.puzre.adapter.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.puzre.core.port.service.ICatService;

@Path("/cat")
public class CatResource {

    private final ICatService iCatService;

    public CatResource(ICatService iCatService) {
        this.iCatService = iCatService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response listAllCats() {
        return Response.ok(iCatService.listAllCatsLegacy()).build();
    }

}
