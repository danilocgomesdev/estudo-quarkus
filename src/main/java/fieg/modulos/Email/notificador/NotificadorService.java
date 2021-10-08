package fieg.modulos.email.notificador;

import fieg.modulos.email.notificador.command.NotificadorEmailCommand;

public interface NotificadorService {

	void notificaCriacaoUsuario(NotificadorEmailCommand notificadorEmailCommand);
}
