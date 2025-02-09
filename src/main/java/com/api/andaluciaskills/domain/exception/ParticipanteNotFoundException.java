package com.api.andaluciaskills.domain.exception;

public class ParticipanteNotFoundException extends GenericException {

  public ParticipanteNotFoundException() {
    super("Participante no encontrado");
  }
}