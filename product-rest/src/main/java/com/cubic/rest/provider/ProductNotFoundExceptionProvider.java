package com.cubic.rest.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cubic.rest.exception.ProductNotFoundException;
import com.cubic.rest.vo.ErrorType;

@Provider
public class ProductNotFoundExceptionProvider extends AbstractExceptionProvider
		implements ExceptionMapper<ProductNotFoundException> {

	public Response toResponse(ProductNotFoundException exception) {

		return this.createResponse(ErrorType.RECORD_NOT_FOUND, exception);
	}

}
