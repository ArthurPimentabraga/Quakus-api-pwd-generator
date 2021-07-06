package src;

import com.google.gson.Gson;
import dto.PwdInfosDTO;
import dto.ResponseDTO;
import lombok.extern.java.Log;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import src.service.GeneratorService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/pwd")
@Log
public class GeneratorController {

    @Inject
    GeneratorService service;

    @GET
    @Path("generator")
    @Produces(MediaType.TEXT_PLAIN)
    public Response generator() {
        try {
            Gson gson = new Gson();
            String pwd = service.generator(new PwdInfosDTO(5, true, true, true, true));

            ResponseDTO responseDTO = ResponseDTO.builder().description("Funfou").pwd(pwd).build();
            return Response.status(200).entity(gson.toJson(responseDTO)).build();
        } catch (Exception ex) {
            return Response.status(500).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/generator/teste/{name}")
    public String greeting(@PathParam String name) {
        log.severe("asdasd");
        return name;
    }
}