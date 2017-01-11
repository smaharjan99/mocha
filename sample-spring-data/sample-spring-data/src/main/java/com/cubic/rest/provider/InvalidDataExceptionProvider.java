package com.cubic.rest.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cubic.rest.exception.InvalidDataException;
import com.cubic.rest.vo.ErrorType;

@Provider
public class InvalidDataExceptionProvider extends AbstractExceptionProvider
		implements ExceptionMapper<InvalidDataException> {

	public Response toResponse(InvalidDataException exception) {

		return this.createResponse(ErrorType.INVALID_DATA_ERROR, exception);
	}

}
