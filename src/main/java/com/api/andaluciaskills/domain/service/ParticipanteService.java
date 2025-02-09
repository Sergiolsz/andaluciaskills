package com.api.andaluciaskills.domain.service;

import com.api.andaluciaskills.domain.entities.Participante;
import com.api.andaluciaskills.domain.entities.Prueba;
import java.util.List;

public interface ParticipanteService {

  Participante createParticipante(Participante participante);

  Participante getParticipanteById(Long participanteId);

  List<Prueba> getPruebasDeParticipante(Long participanteId);

}
