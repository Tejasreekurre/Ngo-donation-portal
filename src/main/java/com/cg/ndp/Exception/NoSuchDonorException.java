package com.cg.ndp.Exception;

public class NoSuchDonorException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSuchDonorException(String errorMessage) {
		super(errorMessage);

	}
}