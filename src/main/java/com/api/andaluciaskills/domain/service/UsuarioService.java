package com.api.andaluciaskills.domain.service;

import com.api.andaluciaskills.domain.entities.Especialidad;
import com.api.andaluciaskills.domain.entities.Participante;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

  Especialidad getEspecialidad(Long id);

  List<Especialidad> getAllEspecialidades();

  Optional<Participante> getParticipanteById(Long id);

  List<Participante> getAllParticipantes();

  Participante createParticipante(Participante participante);

  Optional<Participante> updateParticipante(Long id, Participante participante);

}
