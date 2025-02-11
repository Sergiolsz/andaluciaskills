package com.api.andaluciaskills.domain.port.participante;

import com.api.andaluciaskills.domain.entities.Participante;
import java.util.List;

public interface ParticipanteFindAllPort {

	List<Participante> findAll();
}
