package com.api.andaluciaskills.domain.exception;

public class DniAlreadyExistsException extends RuntimeException {
	public DniAlreadyExistsException(String dni) {
		super("Ya existe un participante con el DNI: " + dni);
	}
}