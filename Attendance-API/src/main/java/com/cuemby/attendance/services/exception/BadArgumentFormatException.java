package com.cuemby.attendance.services.exception;

public class BadArgumentFormatException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BadArgumentFormatException() {
	}

	public BadArgumentFormatException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BadArgumentFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public BadArgumentFormatException(String message) {
		super(message);
	}

	public BadArgumentFormatException(Throwable cause) {
		super(cause);
	}
}
