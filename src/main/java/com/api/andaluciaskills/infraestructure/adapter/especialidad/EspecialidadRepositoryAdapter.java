package com.api.andaluciaskills.infraestructure.adapter.especialidad;

import com.api.andaluciaskills.domain.entities.Especialidad;
import com.api.andaluciaskills.domain.port.EspecialidadParticipantePort;
import com.api.andaluciaskills.infraestructure.repository.EspecialidadRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class EspecialidadRepositoryAdapter implements EspecialidadParticipantePort {

  private final EspecialidadRepository especialidadRepository;

  public EspecialidadRepositoryAdapter(EspecialidadRepository especialidadRepository) {
    this.especialidadRepository = especialidadRepository;
  }

  @Override
  public Optional<Especialidad> findEspecialidadById(Long id) {
    return especialidadRepository.findById(id);
  }
}