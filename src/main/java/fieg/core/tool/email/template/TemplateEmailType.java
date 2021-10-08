package fieg.core.tool.email.template;

/**
 * Tipos de templates para emails de notificação.
 */
public enum TemplateEmailType {

	CRIACAO_USUARIO("criacaoAtendimento");

	private final String key;

	TemplateEmailType(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
