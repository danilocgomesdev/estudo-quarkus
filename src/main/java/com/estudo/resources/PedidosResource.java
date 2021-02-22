package com.estudo.resources;

import com.estudo.model.Pedido;
import com.estudo.model.Users;
import com.estudo.repository.PedidosRepository;
import com.estudo.repository.UsersRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidosResource {

    @Inject
    PedidosRepository pedidosRepository;

    @Inject
    UsersRepository usersRepository;

    @GET
    public List<Pedido> listar(){
        return pedidosRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Pedido buscar(@PathParam("id") Long id){
        return pedidosRepository.findById(id);
    }

    @POST
    @Transactional
    public Pedido salvar(Pedido pedido, Users users){
        pedido.setCliente(users);
        pedidosRepository.persist(pedido);
        return pedido;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Pedido atualizar(@PathParam("id") Long id, Pedido pedido){
        Pedido pedidosDB =  pedidosRepository.findById(id);
        pedidosDB.setMomento(pedido.getMomento());
        return pedidosDB;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void remover( @PathParam("id") Long id) {
        pedidosRepository.deleteById(id);
    }


}
