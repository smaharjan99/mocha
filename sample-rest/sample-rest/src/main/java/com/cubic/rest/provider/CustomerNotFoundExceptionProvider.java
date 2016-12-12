package com.cubic.rest.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cubic.rest.exception.CustomerNotFoundException;
import com.cubic.rest.vo.ErrorType;

@Provider
public class CustomerNotFoundExceptionProvider extends AbstractExceptionProvider
		implements ExceptionMapper<CustomerNotFoundException> {

	@Override
	public Response toResponse(CustomerNotFoundException exception) {

		return this.createResponse(ErrorType.RECORD_NOT_FOUND, exception);
	}

}
