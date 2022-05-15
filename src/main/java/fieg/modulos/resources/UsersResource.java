package fieg.modulos.resources;

import fieg.modulos.Email.notificador.NotificadorEmail;
import fieg.modulos.Email.notificador.command.NotificadorEmailCommand;
import fieg.modulos.dto.Arquivo;
import fieg.modulos.model.Users;
import fieg.modulos.repository.UsersRepository;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    UsersRepository usersRepository;

    @Inject
    NotificadorEmail notificadorEmail;

    @GET
    public List<Users> listar(){
        return usersRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Users buscar(@PathParam("id") Long id){
        return usersRepository.findById(id);
    }

    @POST
    public Response salvar(@Valid Users users){
        Users usersEntty = usersRepository.salvar(users);
        NotificadorEmailCommand notificadorEmailCommand = NotificadorEmailCommand.crieEnviarEmail(users);
       notificadorEmail.notificaCriacaoUsuario(notificadorEmailCommand);
        return Response.ok(usersEntty).status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/anexo")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response teste(@MultipartForm Arquivo arquivo){
        NotificadorEmailCommand notificadorEmailCommand = NotificadorEmailCommand.crieEnviarEmailComAnexo(arquivo);
        notificadorEmail.notificaCriacaoUsuarioComAnexo(notificadorEmailCommand);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Users users) {
       Users usersUpdated = usersRepository.update(id, users);
        return Response.ok(usersUpdated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response remover( @PathParam("id") Long id) {
        usersRepository.remover(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}
