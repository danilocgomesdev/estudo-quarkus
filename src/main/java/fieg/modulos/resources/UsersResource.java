package com.estudo.resources;

import com.estudo.model.Users;
import com.estudo.repository.UsersRepository;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    UsersRepository usersRepository;

    @GET
    public List<Users> listar(){
        return usersRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Users buscar(@PathParam("id") Long id){
        return usersRepository.findById(id);
    }

    @POST
    public Response salvar(@Valid Users users){
        Users usersEntty = usersRepository.salvar(users);
        return Response.ok(usersEntty).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Users users) {
       Users usersUpdated = usersRepository.update(id, users);
        return Response.ok(usersUpdated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response remover( @PathParam("id") Long id) {
        usersRepository.remover(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}
