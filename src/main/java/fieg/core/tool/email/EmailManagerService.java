package fieg.core.tool.email;

import fieg.core.tool.email.exception.TemplateNaoEncontradoException;
import fieg.core.tool.email.template.TemplateEmailType;

public interface EmailManagerService {
	ResultadoEmail sendEmail(Email email);

	Email createEmailByTemplate(String to, String subject, TemplateEmailType templateEmailType, Object dadosTemplate);
}
