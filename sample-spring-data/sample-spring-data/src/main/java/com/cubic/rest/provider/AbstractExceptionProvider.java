package com.cubic.rest.provider;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cubic.rest.vo.ErrorInfo;
import com.cubic.rest.vo.ErrorType;

public abstract class AbstractExceptionProvider {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	public Response createResponse(final ErrorType errorType, final Exception exception) {
		logger.error("Exception occurred={}", exception);
		ErrorInfo entity = new ErrorInfo();
		entity.setErrorCode(errorType.name());
		entity.setErrorDesc(exception.getMessage());
		logger.error("Error Codes={}, Error Description={}", entity.getErrorCode(), entity.getErrorDesc());
		return Response.status(errorType.getCode()).entity(entity).build();
	}
}
