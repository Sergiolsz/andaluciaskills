package com.api.andaluciaskills.domain.port.participante;

import com.api.andaluciaskills.domain.entities.Especialidad;
import java.util.Optional;

public interface ParticipanteFindEspecialidadByDniPort {

	Optional<Especialidad> findEspecialidadByDni(String dni);
}
