package com.js.springemployee.exception;

public class NoIdFoundException extends RuntimeException {
	private String message = "No Id Found";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NoIdFoundException() {

	}

	public NoIdFoundException(String message) {
		this.message = message;
	}

}
