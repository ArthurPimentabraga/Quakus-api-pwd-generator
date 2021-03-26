package src;

import com.google.gson.Gson;
import dto.ResponseDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pwd")
public class Generator {

    private static final String uAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lAlphabet = "abcdefghijklmnopqrstuvwxyz";
    private static final String sNumbers = "1234567890";
    private static final String sSymbols = "!@#$%&*+_-<>";

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
            return Response.status(500).entity("Create ENUM for exceptions :)").build();
        }
    }
}