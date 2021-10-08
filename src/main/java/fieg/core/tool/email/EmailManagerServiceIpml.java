package fieg.core.tool.email;

import fieg.core.tool.email.exception.TemplateNaoEncontradoException;
import fieg.core.tool.email.template.TemplateEmailType;
import io.quarkus.mailer.Mailer;
import io.quarkus.qute.Template;
import io.quarkus.qute.api.ResourcePath;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class EmailManagerQuarkusService implements EmailManagerService {

	@Inject
	Mailer mailer;

	@ResourcePath("criacaoUsuario")
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

		return new ResultadoEmail("Email enviado");
	}

	@SuppressWarnings("SwitchStatementWithTooFewBranches")
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
