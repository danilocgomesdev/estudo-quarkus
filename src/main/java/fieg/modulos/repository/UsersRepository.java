package fieg.modulos.repository;

import fieg.modulos.model.Users;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;


@ApplicationScoped
public class UsersRepository implements PanacheRepository<Users> {

    @Transactional
    public Users salvar( Users users){
        persist(users);
        return users;
    }

    @Transactional
    public Users update(Long id, Users users){
        Users usersEntity = findById(id);
        usersEntity.setName(users.getName());
        usersEntity.setEmail(users.getEmail());
        usersEntity.setPassword(users.getPassword());
        usersEntity.setPhone(users.getPhone());
        return usersEntity;
    }

    @Transactional
    public void remover(Long id){
        Users usersEntity = findById(id);
        delete(usersEntity);
    }

}
