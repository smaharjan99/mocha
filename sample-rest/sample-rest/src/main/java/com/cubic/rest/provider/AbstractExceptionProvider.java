package com.cubic.rest.provider;

import javax.ws.rs.core.Response;

import com.cubic.rest.vo.ErrorInfo;
import com.cubic.rest.vo.ErrorType;

public abstract class AbstractExceptionProvider {

	public Response createResponse(final ErrorType errorType, final Exception exception) {
		ErrorInfo entity = new ErrorInfo();
		entity.setErrorCode(errorType.name());
		entity.setErrorDesc(exception.getMessage());
		return Response.status(errorType.getCode()).entity(entity).build();
	}
}
