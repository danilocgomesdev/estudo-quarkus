package fieg.modulos.Email.notificador;

import fieg.core.tool.email.Email;
import fieg.core.tool.email.EmailManagerService;
import fieg.core.tool.email.ResultadoEmail;
import fieg.core.tool.email.exception.TemplateNaoEncontradoException;
import fieg.core.tool.email.template.DadosTemplateCriacaoUsuarioResultado;
import fieg.core.tool.email.template.TemplateEmailType;
import fieg.modulos.Email.notificador.command.NotificadorEmailCommand;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class NotificadorEmail implements NotificadorService {

	@Inject
	EmailManagerService emailManagerService;
	@ConfigProperty(name = "estudo.link.portal.resultados")
	String linkParaPortal;
	@ConfigProperty(name = "estudo.email.imagem.topo")
	String linkImagemTopo;

	@Inject
	Logger logger;

	@Override
	public void notificaCriacaoUsuario(NotificadorEmailCommand notificadorEmailCommand) {
		try {
			String subject = "Portal de Privacidade - FIEG";
			DadosTemplateCriacaoUsuarioResultado dadosTemplate = DadosTemplateCriacaoUsuarioResultado.crieDe(notificadorEmailCommand, linkParaPortal, linkImagemTopo);
			Email emailTecnico = emailManagerService.createEmailByTemplate(notificadorEmailCommand.emailUsuario, subject, TemplateEmailType.CRIACAO_USUARIO, dadosTemplate);
			ResultadoEmail resultadoEmail = emailManagerService.sendEmail(emailTecnico);
			if (resultadoEmail.isEnviado()) {
				logger.info("Email de acesso enviado: " + resultadoEmail.getMensagem());
			} else {
				logger.warn("Email de acesso não foi enviado: {}", resultadoEmail.getMensagem(), resultadoEmail.getThrowable());
			}
		} catch (TemplateNaoEncontradoException e) {
			logger.warn("Email não pode ser enviado devido não encontrar o template", e);
		} catch (Throwable e) {
			logger.warn("Email não pode ser enviado", e);
		}
	}

	@Override
	public void notificaCriacaoUsuarioComAnexo(NotificadorEmailCommand notificadorEmailCommand) {
		try {
			String subject = "Portal de Privacidade - FIEG";
			DadosTemplateCriacaoUsuarioResultado dadosTemplate = DadosTemplateCriacaoUsuarioResultado.crieComAnexo(notificadorEmailCommand, linkParaPortal, linkImagemTopo);
			Email emailTecnico = emailManagerService.createEmailByTemplateComAnexo(notificadorEmailCommand.emailUsuario, subject, TemplateEmailType.CRIACAO_USUARIO, dadosTemplate, "boleto.pdf", notificadorEmailCommand.arquivo, "application/pdf");
			ResultadoEmail resultadoEmail = emailManagerService.sendEmailComAnexo(emailTecnico);
			if (resultadoEmail.isEnviado()) {
				logger.info("Email de acesso enviado: " + resultadoEmail.getMensagem());
			} else {
				logger.warn("Email de acesso não foi enviado: {}", resultadoEmail.getMensagem(), resultadoEmail.getThrowable());
			}
		} catch (TemplateNaoEncontradoException e) {
			logger.warn("Email não pode ser enviado devido não encontrar o template", e);
		} catch (Throwable e) {
			logger.warn("Email não pode ser enviado", e);
		}
	}
}
