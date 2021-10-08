package com.estudo.core.exceptions;

/**
 * Todas exceptions que irão ser externilizadas para consumidor da API
 * devem extender esta exception, pois existe um {@link javax.ws.rs.ext.ExceptionMapper Mapper} para ela que irá criar
 * um json com descrição legível do erro, similar a:
 * <pre>
 * {@code
 *    {
 * 		"erro": "Erro de solicitação",
 * 		"mensagem": "\<message da Exception\>",
 * 		"stackTrace": []
 *    }
 *    }
 *  </pre>.
 */
public class SttnetExceptionBase extends Exception {
	private static final int HTTP_CODE_DEFAULT = 422;

	private final int httpCode;

	public SttnetExceptionBase(String message) {
		super(message);
		this.httpCode = HTTP_CODE_DEFAULT;
	}

	public SttnetExceptionBase(String message, Throwable cause) {
		super(message, cause);
		this.httpCode = HTTP_CODE_DEFAULT;
	}

	public SttnetExceptionBase(int code, String message, Throwable cause) {
		super(message, cause);
		this.httpCode = code;
	}

	public SttnetExceptionBase(Throwable cause) {
		super(cause);
		this.httpCode = HTTP_CODE_DEFAULT;
	}

	@Override
	public String getLocalizedMessage() {
		if (getCause() != null) {
			return getCause().getLocalizedMessage();
		}

		return super.getLocalizedMessage();
	}

	public int getHttpCode() {
		return httpCode;
	}
}
