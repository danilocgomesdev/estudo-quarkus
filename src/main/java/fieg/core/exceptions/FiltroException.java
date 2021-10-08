package com.estudo.core.exceptions;

public class FiltroException extends SttnetExceptionBase {
	public FiltroException(String filtro, Throwable throwable) {
		super("Erro ao tentar converter filtro: " + filtro, throwable);
	}
}
