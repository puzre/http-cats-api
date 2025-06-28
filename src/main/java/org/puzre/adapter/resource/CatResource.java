package org.puzre.adapter.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.puzre.core.port.service.ICatService;

@Path("http-cats/cat")
public class CatResource {

    private final ICatService iCatService;

    public CatResource(ICatService iCatService) {
        this.iCatService = iCatService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all/legacy")
    public Response listAllCatsLegacy() {
        return Response.ok(iCatService.listAllCatsLegacy()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response listAllCatsLegacy(@QueryParam("page") int page,
                                      @QueryParam("totalItems") int totalItems) {
        return Response.ok(iCatService.listAllCats(page, totalItems)).build();
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
    public Response searchCatsByMessage(@QueryParam("message") String message) {
        return Response.ok(iCatService.searchCatsByMessageLegacy(message)).build();
    }

}
