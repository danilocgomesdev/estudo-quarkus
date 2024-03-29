package fieg.core.util;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.smallrye.openapi.runtime.io.JsonUtil;

public class RestUtils {

	/**
	 * Cria texto de erro com campos status e mensagem.
	 */
	public static String createErrorJson(int codeStatus, String msg) {
		ObjectNode jsonNodes = JsonUtil.objectNode();
		jsonNodes.put("status", codeStatus);
		jsonNodes.put("mensagem", msg);

		return jsonNodes.toString();
	}

	/**
	 * Cria texto de erro com campos status e mensagem.
	 */
	public static String createErrorJson(int codeStatus, String msg, Throwable cause, StackTraceElement[] stackTraceElements) {
		ObjectNode jsonNodes = JsonUtil.objectNode();
		jsonNodes.put("status", codeStatus);
		jsonNodes.put("mensagem", msg);

		String causaErro = crieCausa(cause);
		jsonNodes.put("details", causaErro);
		ArrayNode stackTrace = jsonNodes.putArray("stackTrace");
		for (StackTraceElement stackTraceElement : stackTraceElements) {
			stackTrace.add(String.format("%s:%d", stackTraceElement.getClassName(), stackTraceElement.getLineNumber()));
		}

		return jsonNodes.toString();
	}

	/**
	 * Cria texto de causa usando texto padrão: motivo interno do servidor ou messaage da cause.
	 *
	 * @param cause causa do erro.
	 */
	private static String crieCausa(Throwable cause) {
		String motivoPadrao = "motivo interno do servidor";
		if (cause == null) return motivoPadrao;
		if (cause.getMessage() == null) return motivoPadrao;

		return cause.getMessage();
	}
}
