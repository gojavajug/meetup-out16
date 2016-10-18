package api;

import javax.json.JsonArray;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/exemplo")
public class ClientEndpoint {
	
	@GET()
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") String id){
		Client cliente = ClientBuilder.newClient();
		JsonArray response = cliente.target("http://localhost:8080/cliente/exemplo").request().get(JsonArray.class);
		response.forEach(palavra -> System.out.println(palavra.toString().toUpperCase()));
		return Response.ok().build();
	}
}
