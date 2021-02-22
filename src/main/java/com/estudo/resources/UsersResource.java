package com.estudo.resources;

import com.estudo.model.Users;
import com.estudo.services.UsersRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UsersResource {

    @Inject
    UsersRepository usersRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> listar(){
        return usersRepository.listAll();
    }

    @POST
    @Transactional
    public Users salvar(Users users){
        usersRepository.persist(users);
        return users;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Users atualizar(@PathParam("id") Long id, Users users){
        Users usersDB =  usersRepository.findById(id);
        usersDB.setName(users.getName());
        return usersDB;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void remover( @PathParam("id") Long id) {
        usersRepository.deleteById(id);
    }


}
