package fieg.modulos.repository;

import fieg.modulos.model.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class PedidosRepository implements PanacheRepository<Pedido> {

}
