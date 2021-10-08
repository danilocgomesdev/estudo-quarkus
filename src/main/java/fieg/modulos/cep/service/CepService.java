package fieg.modulos.cep.service;

import fieg.restclient.clicep.model.CliCep;

public interface CepService {

    CliCep getCep(String cep);
}
