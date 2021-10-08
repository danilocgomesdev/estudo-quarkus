package com.estudo.core.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Liveness
@ApplicationScoped
@SuppressWarnings("all")
public class AliveHealthCheck implements HealthCheck {

  @PersistenceContext
  EntityManager em;

  @Override
  public HealthCheckResponse call() {
    try {
      em.createNativeQuery("select top 1 id_pessoas from compartilhado.dbo.CI_PESSOAS with (nolock)").getResultList();
      return HealthCheckResponse.up("EntityManager");
    } catch (Exception e) {
      return HealthCheckResponse.down("EntityManager");
    }
  }
}
