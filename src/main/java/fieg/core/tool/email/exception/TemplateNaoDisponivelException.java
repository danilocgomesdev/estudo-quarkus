package fieg.core.tool.email.exception;

public class TemplateNaoDisponivelException extends TemplateNaoEncontradoException {
	private static final String MSG_PADRAO = "Template para email não esta disponível ou configurado: ";

	public TemplateNaoDisponivelException(String template, NoSuchFieldException e) {
		super(MSG_PADRAO + template, e);
	}
}
