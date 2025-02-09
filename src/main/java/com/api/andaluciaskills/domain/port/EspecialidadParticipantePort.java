package com.api.andaluciaskills.domain.port;

import com.api.andaluciaskills.domain.entities.Especialidad;
import java.util.Optional;

public interface EspecialidadParticipantePort {

  Optional<Especialidad> findEspecialidadById(Long especialidadId);
}
