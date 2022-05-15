package fieg.core.tool.email;

import fieg.core.tool.email.exception.TemplateNaoEncontradoException;
import fieg.core.tool.email.template.TemplateEmailType;
import fieg.modulos.dto.Arquivo;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.qute.Template;
import io.quarkus.qute.api.ResourcePath;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;
import java.nio.charset.StandardCharsets;

@ApplicationScoped
public class EmailManagerServiceIpml implements EmailManagerService {

	@Inject
	Mailer mailer;

	@ResourcePath("templateEmail")
	@Inject
	Template criacaoUsuario;

	@Inject
	Logger logger;

	@Override
	public ResultadoEmail sendEmail(Email email) {
		try {
			mailer.send(email.getDadosEmail());
		} catch (Throwable e) {
			String msgErro = "Erro ao enviar email";
			logger.error(msgErro, e);
			return new ResultadoEmail(e, msgErro);
		}

		return new ResultadoEmail("Email enviado!");
	}

	@Override
	public ResultadoEmail sendEmailComAnexo(Email email) {
		try {
			mailer.send(email.getDadosEmail());
		} catch (Throwable e) {
			String msgErro = "Erro ao enviar email";
			logger.error(msgErro, e);
			return new ResultadoEmail(e, msgErro);
		}

		return new ResultadoEmail("Email enviado!");
	}

	@SuppressWarnings("SwitchStatementWithTooFewBranches")
	@Override
	public Email createEmailByTemplateComAnexo(String to, String subject, TemplateEmailType templateEmailType, Object dadosTemplate, String nomeArquivo, byte[] arquivo, String tipoArquivo) throws TemplateNaoEncontradoException {
		String htmlEmail;
		switch (templateEmailType) {
			case CRIACAO_USUARIO:
				htmlEmail = criacaoUsuario.data(dadosTemplate).render();
				return Email.crieEmailHTMLComAnexo(to, subject, htmlEmail,nomeArquivo,arquivo,tipoArquivo);
			default:
				throw new TemplateNaoEncontradoException(templateEmailType.getKey());
		}
	}

	@Override
	public Email createEmailByTemplate(String to, String subject, TemplateEmailType templateEmailType, Object dadosTemplate) throws TemplateNaoEncontradoException {
		String htmlEmail;
		switch (templateEmailType) {
			case CRIACAO_USUARIO:
				htmlEmail = criacaoUsuario.data(dadosTemplate).render();
				return Email.crieEmailHTML(to, subject, htmlEmail);
			default:
				throw new TemplateNaoEncontradoException(templateEmailType.getKey());
		}
	}
}
