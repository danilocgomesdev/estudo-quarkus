package fieg.core.tool.email;

import io.quarkus.mailer.Mail;

/**
 * Classe utilizada para fazer wrap de tecnologia de email, caso trocar um dia,
 * Somente troca internamente os dados, e não em interfaces e outros.
 */
public class Email {
	private Mail dadosEmail;

	public Email() {
	}

	/**
	 * Cria objeto de email com params para lib Email do quarkus.
	 *
	 * @param to      email para quem receberá.
	 * @param subject email de quem está enviando.
	 * @param html    conteúdo do email.
	 * @return objeto criado.
	 */
	public static Email crieEmailHTML(String to, String subject, String html) {
		Email email = new Email();
		email.setDadosEmail(Mail.withHtml(to, subject, html));
		return email;
	}

	public static Email crieEmailHTMLComAnexo(String to, String subject, String html,
											  String nomeArquivo, byte[] arquivo, String tipoArquivo) {
		Email email = new Email();
		email.setDadosEmail(Mail.withHtml(to, subject, html).addAttachment(nomeArquivo,arquivo,tipoArquivo));
		return email;
	}

	public Mail getDadosEmail() {
		return dadosEmail;
	}

	public void setDadosEmail(Mail dadosEmail) {
		this.dadosEmail = dadosEmail;
	}
}
