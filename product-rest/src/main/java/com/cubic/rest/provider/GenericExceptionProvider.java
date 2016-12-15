package com.cubic.rest.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cubic.rest.vo.ErrorType;

@Provider
public class GenericExceptionProvider extends AbstractExceptionProvider implements ExceptionMapper<Exception> {

	public Response toResponse(Exception exception) {

		return this.createResponse(ErrorType.GENERIC_ERROR, exception);
	}

}
