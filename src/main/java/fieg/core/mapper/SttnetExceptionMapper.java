package fieg.core.mapper;

import fieg.core.exceptions.SttnetExceptionBase;
import fieg.core.util.RestUtils;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SttnetExceptionMapper implements ExceptionMapper<SttnetExceptionBase> {

	@Inject
	Logger logger;

	@Override
	public Response toResponse(SttnetExceptionBase sttnetExceptionBase) {
		logger.info("Gerando resposta para exception base");
		if (sttnetExceptionBase == null) {
			return createDefaultErrorResponse();
		} else if (sttnetExceptionBase.getMessage() == null) {
			if (sttnetExceptionBase.getCause() == null) return createDefaultErrorResponse();
			else if (sttnetExceptionBase.getCause().getMessage() == null) {
				return createDefaultErrorResponse();
			}
		}

		String message = sttnetExceptionBase.getMessage();
		int httpCode = sttnetExceptionBase.getHttpCode();
		logger.info("Gerando resposta {} para exception: {}", httpCode, message);

		String errorJson = RestUtils.createErrorJson(httpCode, message, sttnetExceptionBase.getCause(), sttnetExceptionBase.getStackTrace());
		return Response.status(httpCode).entity(errorJson).build();
	}

	private Response createDefaultErrorResponse() {
		logger.info("Gerado erro padrão 500 de servidor");
		return Response.serverError().build();
	}
}
