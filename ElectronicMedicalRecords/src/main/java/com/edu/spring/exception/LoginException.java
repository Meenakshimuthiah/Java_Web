package com.edu.spring.exception;

public class LoginException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginException(String message) {
		super("LoginException-" + message);
	}

	public LoginException(String message, Throwable cause) {
		super("LoginException-" + message, cause);
	}

}
