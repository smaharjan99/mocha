package com.cubic.rest.exception;

public class InvalidDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2782620698459995202L;

	public InvalidDataException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidDataException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidDataException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidDataException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
