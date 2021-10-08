package fieg.modulos.cadastros.pessoaFisica.repository;

import fieg.modulos.cadastros.pessoaFisica.model.PessoaFisica;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;



@ApplicationScoped
public class PessoaFisicaRepository implements PanacheRepository<PessoaFisica> {

}