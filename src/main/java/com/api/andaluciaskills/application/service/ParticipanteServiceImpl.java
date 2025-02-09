package com.api.andaluciaskills.application.service;

import com.api.andaluciaskills.domain.entities.Participante;
import com.api.andaluciaskills.domain.entities.Prueba;
import com.api.andaluciaskills.domain.exception.EspecialidadNotFoundException;
import com.api.andaluciaskills.domain.exception.ParticipanteNotFoundException;
import com.api.andaluciaskills.domain.port.EspecialidadParticipantePort;
import com.api.andaluciaskills.domain.service.ParticipanteService;
import com.api.andaluciaskills.infraestructure.repository.ParticipanteRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

  private final ParticipanteRepository participanteRepository;

  private final EspecialidadParticipantePort especialidadParticipantePort;

  public ParticipanteServiceImpl(ParticipanteRepository participanteRepository,
      EspecialidadParticipantePort especialidadParticipantePort) {
    this.participanteRepository = participanteRepository;
    this.especialidadParticipantePort = especialidadParticipantePort;
  }

  @Override
  @Transactional
  public Participante createParticipante(Participante participante) {
    var especialidad = especialidadParticipantePort.findEspecialidadById(
            participante.getEspecialidad().getIdEspecialidad())
        .orElseThrow(EspecialidadNotFoundException::new);

    participante.setEspecialidad(especialidad);
    return participanteRepository.save(participante);
  }

  @Override
  public Participante getParticipanteById(Long participanteId) {
    return participanteRepository.findById(participanteId)
        .orElseThrow(ParticipanteNotFoundException::new);
  }

  @Override
  public List<Prueba> getPruebasDeParticipante(Long participanteId) {
    var participante = getParticipanteById(participanteId);
    return participante.getEspecialidad().getPruebas();
  }

}
