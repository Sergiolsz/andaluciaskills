package com.api.andaluciaskills.domain.port.participante;

import com.api.andaluciaskills.domain.entities.Participante;
import java.util.List;

public interface ParticipanteFindByIdEspecialidadPort {

	List<Participante> findByEspecialidadId(Long especialidadId);
}
