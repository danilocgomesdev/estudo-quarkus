package fieg.modulos.cep.rest;

import fieg.restclient.clicep.model.CliCep;

import javax.ws.rs.core.Response;

public interface CepApi {

    Response getCep(String cep);
}
