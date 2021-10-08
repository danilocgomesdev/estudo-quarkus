package fieg.core.tool.email.template;


import fieg.modulos.Email.notificador.command.NotificadorEmailCommand;

public class DadosTemplateCriacaoUsuarioResultado {
	public String nomeUsuario;
	public String emailUsuario;
	public String linkPortal;
	public String linkImagemTopo;

	/**
	 * Cria os dados para uso em template de email.
	 */
	public static DadosTemplateCriacaoUsuarioResultado crieDe(NotificadorEmailCommand command, String linkParaPortal, String linkImagemTopo) {
		DadosTemplateCriacaoUsuarioResultado dados = new DadosTemplateCriacaoUsuarioResultado();
		dados.nomeUsuario = command.nomeUsuario;
		dados.emailUsuario = command.emailUsuario;
		dados.linkPortal = linkParaPortal+command.emailUsuario;
		dados.linkImagemTopo = linkImagemTopo;

		return dados;
	}
}
