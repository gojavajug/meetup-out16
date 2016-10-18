package api;

import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/exemplo")
public class ClienteEndpoint {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{integer}")
	public Response get(@PathParam("integer") String integer){
		try{
			int value = Integer.valueOf(integer);
			return Response.ok(Json.createObjectBuilder().add("resultado", value).build()).build();
		}catch(Exception e){
			return Response.status(Status.BAD_REQUEST).entity("A requisição esperava um inteiro").build();			
		}
	}	
}
