package fieg.modulos.Email.notificador;

import fieg.modulos.Email.notificador.command.NotificadorEmailCommand;

public interface NotificadorService {

	void notificaCriacaoUsuario(NotificadorEmailCommand notificadorEmailCommand);

	void notificaCriacaoUsuarioComAnexo(NotificadorEmailCommand notificadorEmailCommand);
}
