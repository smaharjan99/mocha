package com.cubic.rest.vo;

public enum ErrorType {

	GENERIC_ERROR(550), INVALID_DATA_ERROR(520), RECORD_NOT_FOUND(521);

	private int code;

	private ErrorType(final int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
