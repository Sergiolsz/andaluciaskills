package com.api.andaluciaskills.domain.exception;

public class EspecialidadNotFoundException extends GenericException {

  public EspecialidadNotFoundException() {
    super("La especialidad no existe");
  }
}