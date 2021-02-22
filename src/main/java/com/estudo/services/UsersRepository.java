package com.estudo.services;

import com.estudo.model.Users;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class UsersRepository implements PanacheRepository<Users> {

}
