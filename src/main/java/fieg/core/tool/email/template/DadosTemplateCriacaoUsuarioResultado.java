package fieg.core.tool.email.template;

import fieg.modulos.usuario_resultado.service.notificador.command.NotificadorEmailCommand;

public class DadosTemplateCriacaoUsuarioResultado {
	public String nomeUsuario;
	public String cpfUsuario;
	public String senhaGerada;
	public String linkPortal;
	public String linkImagemTopo;
	public String linkImagemRodape;

	/**
	 * Cria os dados para uso em template de email.
	 */
	public static DadosTemplateCriacaoUsuarioResultado crieDe(NotificadorEmailCommand command, String linkParaPortal, String linkImagemTopo, String linkImagemRodape) {
		DadosTemplateCriacaoUsuarioResultado dados = new DadosTemplateCriacaoUsuarioResultado();
		dados.nomeUsuario = command.nomeUsuario;
		dados.senhaGerada = command.senhaGeradaUsuario;
		dados.cpfUsuario = command.cpfUsuario;
		dados.linkPortal = linkParaPortal;
		dados.linkImagemTopo = linkImagemTopo;
		dados.linkImagemRodape = linkImagemRodape;

		return dados;
	}
}
