package com.estudo.cadastros.pessoaFisica.repository;

import com.estudo.cadastros.pessoaFisica.model.PessoaFisica;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;



@ApplicationScoped
public class PessoaFisicaRepository implements PanacheRepository<PessoaFisica> {

}