package com.api.andaluciaskills.domain.exception;

import lombok.Getter;

@Getter
public class ParticipanteNotFoundException extends GenericException {

  private final String dni;

  public ParticipanteNotFoundException() {
    super("Participante no encontrado");
    this.dni = null;
  }

  public ParticipanteNotFoundException(String dni) {
    super("Participante no encontrado con el DNI: " + dni);
    this.dni = dni;
  }

}