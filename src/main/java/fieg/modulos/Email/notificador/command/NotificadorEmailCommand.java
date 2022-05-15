package fieg.modulos.Email.notificador.command;

import fieg.modulos.dto.Arquivo;
import fieg.modulos.model.Users;


public class NotificadorEmailCommand {


	public String nomeUsuario;
	public String emailUsuario;
	public byte[] arquivo;

	public NotificadorEmailCommand() {
	}

	public static NotificadorEmailCommand crieEnviarEmail(Users users) {
		NotificadorEmailCommand command = new NotificadorEmailCommand();
		command.emailUsuario = users.getEmail();
		command.nomeUsuario = users.getName();
		return command;
	}

	public static NotificadorEmailCommand crieEnviarEmailComAnexo(Arquivo arquivo){
		NotificadorEmailCommand command = new NotificadorEmailCommand();
		command.arquivo = arquivo.getArquivo();
		command.emailUsuario = arquivo.getEmailUsuario();
		command.nomeUsuario = arquivo.getNomeUsuario();
		return command;
	}


}
