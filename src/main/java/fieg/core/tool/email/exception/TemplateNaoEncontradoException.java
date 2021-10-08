package fieg.core.tool.email.exception;

import fieg.core.exceptions.ApplicationExceptionBase;

public class TemplateNaoEncontradoException extends ApplicationExceptionBase {

	private static final String MSG_PADRAO = "Template para email não encontrado: ";

	public TemplateNaoEncontradoException(String template) {
		super(MSG_PADRAO + template);
	}

	public TemplateNaoEncontradoException(String template, NoSuchFieldException e) {
		super(MSG_PADRAO + template, e);
	}
}
