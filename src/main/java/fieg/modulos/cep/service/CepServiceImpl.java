package fieg.modulos.cep.service;

import fieg.restclient.clicep.model.CliCep;
import fieg.restclient.clicep.service.CliCepServiceApi;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CepServiceImpl implements CepService{

    @Inject
    @RestClient
    CliCepServiceApi service;

    public CliCep getCep(String cep){
        return service.buscarCep(cep);
    }
}
