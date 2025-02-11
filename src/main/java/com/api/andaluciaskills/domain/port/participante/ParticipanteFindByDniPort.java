package com.api.andaluciaskills.domain.port.participante;

import com.api.andaluciaskills.domain.entities.Participante;
import java.util.Optional;

public interface ParticipanteFindByDniPort {

	Optional<Participante> findByDni(String dni);
}
