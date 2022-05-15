package fieg.core.tool.email;

import fieg.core.tool.email.template.TemplateEmailType;
import fieg.modulos.dto.Arquivo;

public interface EmailManagerService {
	ResultadoEmail sendEmail(Email email);

	ResultadoEmail sendEmailComAnexo(Email email);

	Email createEmailByTemplate(String to, String subject, TemplateEmailType templateEmailType, Object dadosTemplate);

	Email createEmailByTemplateComAnexo(String to, String subject, TemplateEmailType templateEmailType, Object dadosTemplate,
	String nomeArquivo, byte[] arquivo, String tipoArquivo);
}
