package fieg.modulos.cep.rest;

import fieg.modulos.cep.service.CepService;
import fieg.restclient.clicep.model.CliCep;
import fieg.restclient.clicep.service.CliCepServiceApi;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/cep")
@Produces("application/json")
public class CepRest implements CepApi {

    @Inject
    CepService service;

    @GET
    @Path("/{cep}")
    public Response getCep(@PathParam("cep") String cep){
        return Response.ok(service.getCep(cep)).build();
    }
}
