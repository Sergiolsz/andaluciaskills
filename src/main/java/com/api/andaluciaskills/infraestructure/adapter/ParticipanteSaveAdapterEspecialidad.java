package com.api.andaluciaskills.infraestructure.adapter;

import com.api.andaluciaskills.domain.entities.Especialidad;
import com.api.andaluciaskills.domain.entities.Participante;
import com.api.andaluciaskills.domain.port.participante.ParticipanteExistsByDniPort;
import com.api.andaluciaskills.domain.port.participante.ParticipanteFindAllPort;
import com.api.andaluciaskills.domain.port.participante.ParticipanteFindByDniPort;
import com.api.andaluciaskills.domain.port.participante.ParticipanteFindByIdEspecialidadPort;
import com.api.andaluciaskills.domain.port.participante.ParticipanteFindEspecialidadByDniPort;
import com.api.andaluciaskills.domain.port.participante.ParticipanteFindTopPuntuacionPort;
import com.api.andaluciaskills.domain.port.participante.ParticipanteSavePort;
import com.api.andaluciaskills.infraestructure.repository.ParticipanteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ParticipanteSaveAdapterEspecialidad implements
	ParticipanteExistsByDniPort,
	ParticipanteFindByDniPort,
	ParticipanteFindAllPort,
	ParticipanteFindEspecialidadByDniPort,
	ParticipanteFindTopPuntuacionPort,
	ParticipanteFindByIdEspecialidadPort,
	ParticipanteSavePort {

	private final ParticipanteRepository participanteRepository;

	public ParticipanteSaveAdapterEspecialidad(ParticipanteRepository participanteRepository) {

		this.participanteRepository = participanteRepository;
	}

	@Override
	public boolean existsByDni(String dni) {

		return participanteRepository.existsByDni(dni);
	}

	@Override
	public Optional<Participante> findByDni(String dni) {

		return participanteRepository.findByDni(dni);
	}

	@Override
	public List<Participante> findAll() {

		return participanteRepository.findAll();
	}

	@Override
	public Optional<Especialidad> findEspecialidadByDni(String dni) {

		return participanteRepository.findEspecialidadByDni(dni);
	}

	@Override
	public Optional<Participante> findTopPuntuacion(Long especialidadId) {

		return participanteRepository.findTopByEspecialidad_IdEspecialidadOrderByEspecialidad_Pruebas_PuntuacionMaximaDesc
			(especialidadId);
	}

	@Override
	public List<Participante> findByEspecialidadId(Long especialidadId) {

		return participanteRepository.findByEspecialidad_IdEspecialidad(especialidadId);
	}

	@Override
	public Participante save(Participante participante) {

		return participanteRepository.save(participante);
	}

}