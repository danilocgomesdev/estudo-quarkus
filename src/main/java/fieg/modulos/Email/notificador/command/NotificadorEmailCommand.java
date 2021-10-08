package fieg.modulos.email.notificador.command;

import fieg.modulos.model.Users;


public class NotificadorEmailCommand {


	public String nomeUsuario;
	public String emailUsuario;

	public NotificadorEmailCommand() {
	}

	public static NotificadorEmailCommand crieEnviarEmail(Users users) {
		NotificadorEmailCommand command = new NotificadorEmailCommand();
		command.emailUsuario = users.getEmail();
		command.nomeUsuario = users.getName();

		return command;
	}



}
