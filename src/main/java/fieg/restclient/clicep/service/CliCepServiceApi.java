package fieg.restclient.clicep.service;

import fieg.restclient.clicep.model.CliCep;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/ws")
@Produces("application/json")
@ApplicationScoped
@RegisterRestClient(configKey="cep-api")
public interface CliCepServiceApi {

    @GET
    @Path("/{cep}/json")
    public CliCep buscarCep(@PathParam("cep") String cep);
}
