package com.edu.spring.exception;

public class AdminException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminException(String message) {
		super("AdminException-" + message);
	}

	public AdminException(String message, Throwable cause) {
		super("AdminException-" + message, cause);
	}
}
