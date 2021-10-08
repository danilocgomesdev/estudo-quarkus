package com.estudo.cadastros.pessoaFisica.rest;

import com.estudo.cadastros.pessoaFisica.model.PessoaFisica;
import com.estudo.cadastros.pessoaFisica.repository.PessoaFisicaRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pessoas-fisicas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaFisicaRest {

        @Inject
        PessoaFisicaRepository pessoaFisicaRepository;

        @GET
        public List<PessoaFisica> listar(){
            return pessoaFisicaRepository.listAll();
        }

        @GET
        @Path("/{id}")
        public PessoaFisica buscar(@PathParam("id") Long id){
            return pessoaFisicaRepository.findById(id);
        }

        @POST
        @Transactional
        public PessoaFisica salvar(PessoaFisica pessoaFisica){
            pessoaFisicaRepository.persist(pessoaFisica);
            return pessoaFisica;
        }

        @PUT
        @Path("/{id}")
        @Transactional
        public PessoaFisica atualizar(@PathParam("id") long id, PessoaFisica pessoaFisica){
            PessoaFisica PessoaFisicaDB =  pessoaFisicaRepository.findById(id);
            PessoaFisicaDB.setNome(pessoaFisica.getNome());
            return PessoaFisicaDB;
        }

        @DELETE
        @Path("/{id}")
        @Transactional
        public void remover( @PathParam("id") Long id) {
            pessoaFisicaRepository.deleteById(id);
        }


    }


