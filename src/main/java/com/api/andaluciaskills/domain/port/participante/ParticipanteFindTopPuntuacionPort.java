package com.api.andaluciaskills.domain.port.participante;

import com.api.andaluciaskills.domain.entities.Participante;
import java.util.Optional;

public interface ParticipanteFindTopPuntuacionPort {

	Optional<Participante> findTopPuntuacion(Long especialidadId);
}