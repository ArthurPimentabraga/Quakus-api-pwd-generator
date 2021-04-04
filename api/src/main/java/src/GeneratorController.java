package src;

import com.google.gson.Gson;
import dto.PwdInfosDTO;
import dto.ResponseDTO;
import src.service.GeneratorService;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pwd")
public class GeneratorController {

    private GeneratorService service;

    @GET
    @Path("generator")
    @Produces(MediaType.TEXT_PLAIN)
    public Response generator() {
        ResponseDTO responseDTO = new ResponseDTO();
        Gson gson = new Gson();

        try {

            responseDTO.setStatus(200);
            responseDTO.setDescription("Funfou");
            return Response.status(200).entity(gson.toJson(responseDTO)).build();
        } catch (Exception ex) {
            return Response.status(500).entity(ex.getMessage()).build();
        }
    }

    @POST
    @Path("test")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(PwdInfosDTO dto) {
        return Response.ok().entity(dto).build();
    }
}