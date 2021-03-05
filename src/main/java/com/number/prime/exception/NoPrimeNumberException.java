package com.number.prime.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoPrimeNumberException extends RuntimeException {

	public NoPrimeNumberException(String message) {
		super(message);
	}

}