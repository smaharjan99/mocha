package com.cubic.rest.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cubic.rest.exception.UPCException;
import com.cubic.rest.vo.ErrorType;

@Provider
public class UPCExceptionProvider extends AbstractExceptionProvider implements ExceptionMapper<UPCException> {

	public Response toResponse(UPCException exception) {

		return this.createResponse(ErrorType.UPC_NOT_CORRECT, exception);
	}

}
