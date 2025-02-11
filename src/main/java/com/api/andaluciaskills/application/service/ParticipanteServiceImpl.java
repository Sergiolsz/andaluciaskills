package com.api.andaluciaskills.application.service;

import com.api.andaluciaskills.application.dto.especialidad.EspecialidadDTO;
import com.api.andaluciaskills.application.dto.participante.CreateParticipanteDTO;
import com.api.andaluciaskills.application.dto.participante.ParticipanteDTO;
import com.api.andaluciaskills.application.dto.participante.ParticipanteDatosPruebasDTO;
import com.api.andaluciaskills.application.dto.participante.UpdateParticipanteDTO;
import com.api.andaluciaskills.application.dto.prueba.PruebaDTO;
import com.api.andaluciaskills.application.mapper.EspecialidadMapper;
import com.api.andaluciaskills.application.mapper.ParticipanteMapper;
import com.api.andaluciaskills.domain.entities.Participante;
import com.api.andaluciaskills.domain.entities.Prueba;
import com.api.andaluciaskills.domain.exception.DniAlreadyExistsException;
import com.api.andaluciaskills.domain.exception.EspecialidadNotFoundException;
import com.api.andaluciaskills.domain.exception.ParticipanteNotFoundException;
import com.api.andaluciaskills.domain.port.especialidad.EspecialidadParticipantePort;
import com.api.andaluciaskills.domain.port.especialidad.EspecialidadPruebaPort;
import com.api.andaluciaskills.domain.port.participante.ParticipanteExistsByDniPort;
import com.api.andaluciaskills.domain.port.participante.ParticipanteFindAllPort;
import com.api.andaluciaskills.domain.port.participante.ParticipanteFindByDniPort;
import com.api.andaluciaskills.domain.port.participante.ParticipanteFindByIdEspecialidadPort;
import com.api.andaluciaskills.domain.port.participante.ParticipanteFindEspecialidadByDniPort;
import com.api.andaluciaskills.domain.port.participante.ParticipanteFindTopPuntuacionPort;
import com.api.andaluciaskills.domain.port.participante.ParticipanteSavePort;
import com.api.andaluciaskills.domain.service.ParticipanteService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

	private final ParticipanteExistsByDniPort participanteExistsByDniPort;
	private final ParticipanteFindAllPort participanteFindAllPort;
	private final ParticipanteFindByDniPort participanteFindByDniPort;
	private final ParticipanteFindByIdEspecialidadPort participanteFindByIdEspecialidadPort;
	private final ParticipanteFindEspecialidadByDniPort participanteFindEspecialidadByDniPort;
	private final ParticipanteFindTopPuntuacionPort
		participanteFindTopPuntuacionPort;
	private final ParticipanteSavePort participanteSavePort;
	private final EspecialidadParticipantePort especialidadParticipantePort;
	private final EspecialidadPruebaPort especialidadPruebaPort;
	private final ParticipanteMapper participanteMapper;
	private final EspecialidadMapper especialidadMapper;

	public ParticipanteServiceImpl(
		ParticipanteExistsByDniPort participanteExistsByDniPort, ParticipanteFindAllPort participanteFindAllPort,
		ParticipanteFindByDniPort participanteFindByDniPort,
		ParticipanteFindByIdEspecialidadPort participanteFindByIdEspecialidadPort,
		ParticipanteFindEspecialidadByDniPort participanteFindEspecialidadByDniPort,
		ParticipanteFindTopPuntuacionPort participanteFindTopPuntuacionPort,
		ParticipanteSavePort participanteSavePort,
		EspecialidadParticipantePort especialidadParticipantePort,
		EspecialidadPruebaPort especialidadPruebaPort,
		ParticipanteMapper participanteMapper, EspecialidadMapper especialidadMapper) {

		this.participanteExistsByDniPort = participanteExistsByDniPort;
		this.participanteFindAllPort = participanteFindAllPort;
		this.participanteFindByDniPort = participanteFindByDniPort;
		this.participanteFindByIdEspecialidadPort = participanteFindByIdEspecialidadPort;
		this.participanteFindEspecialidadByDniPort = participanteFindEspecialidadByDniPort;
		this.participanteFindTopPuntuacionPort =
			participanteFindTopPuntuacionPort;
		this.participanteSavePort = participanteSavePort;

		this.especialidadParticipantePort = especialidadParticipantePort;
		this.especialidadPruebaPort = especialidadPruebaPort;
		this.participanteMapper = participanteMapper;
		this.especialidadMapper = especialidadMapper;
	}

	@Override
	@Transactional
	public ParticipanteDTO createParticipante(CreateParticipanteDTO createParticipanteDTO) {

		if (participanteExistsByDniPort.existsByDni(createParticipanteDTO.getDni())) {
			throw new DniAlreadyExistsException(createParticipanteDTO.getDni());
		}

		var especialidad = especialidadParticipantePort.findEspecialidadById(createParticipanteDTO.getEspecialidadId())
			.orElseThrow(EspecialidadNotFoundException::new);

		Participante participante = participanteMapper.toEntity(createParticipanteDTO);
		participante.setEspecialidad(especialidad);

		Participante savedParticipante = participanteSavePort.save(participante);

		return participanteMapper.toDto(savedParticipante);
	}

	@Override
	public List<ParticipanteDTO> getAllParticipantes() {

		var participantes = participanteFindAllPort.findAll();
		return participantes.stream()
			.map(participanteMapper::toDto)
			.toList();
	}

	@Override
	public ParticipanteDTO getParticipanteById(String dni) {

		var participante = participanteFindByDniPort.findByDni(dni)
			.orElseThrow(ParticipanteNotFoundException::new);

		return participanteMapper.toDto(participante);
	}

	@Override
	@Transactional
	public ParticipanteDTO editParticipanteById(String dni, UpdateParticipanteDTO updateDto) {

		var participante = participanteFindByDniPort.findByDni(dni)
			.orElseThrow(() -> new ParticipanteNotFoundException(dni));

		if (updateDto.getNombre() != null) {
			participante.setNombre(updateDto.getNombre());
		}
		if (updateDto.getApellidos() != null) {
			participante.setApellidos(updateDto.getApellidos());
		}
		if (updateDto.getEmail() != null) {
			participante.setEmail(updateDto.getEmail());
		}

		var updatedParticipante = participanteSavePort.save(participante);
		return participanteMapper.toDto(updatedParticipante);
	}

	@Override
	public List<Prueba> getPruebasDeParticipante(String dni) {

		return especialidadPruebaPort.findPruebasByParticipanteDni(dni);
	}

	@Override
	public EspecialidadDTO getEspecialidadDeParticipante(String dni) {

		var especialidad = participanteFindEspecialidadByDniPort.findEspecialidadByDni(dni)
			.orElseThrow(() -> new ParticipanteNotFoundException(dni));

		return especialidadMapper.toDto(especialidad);
	}

	@Override
	public List<ParticipanteDatosPruebasDTO> getParticipantesByEspecialidad(Long especialidadId) {

		var participantes = participanteFindByIdEspecialidadPort.findByEspecialidadId(especialidadId);

		return participantes.stream()
			.map(this::convertirParticipanteADto)
			.toList();
	}

	@Override
	public ParticipanteDTO getTopParticipanteByEspecialidad(Long especialidadId) {

		var topParticipante =
			participanteFindTopPuntuacionPort
				.findTopPuntuacion(especialidadId)
				.orElseThrow(EspecialidadNotFoundException::new);

		return participanteMapper.toDto(topParticipante);

	}

	private ParticipanteDatosPruebasDTO convertirParticipanteADto(Participante participante) {

		ParticipanteDatosPruebasDTO dto = new ParticipanteDatosPruebasDTO();
		dto.setDni(participante.getDni());
		dto.setNombre(participante.getNombre());
		dto.setApellidos(participante.getApellidos());
		dto.setEmail(participante.getEmail());
		dto.setEspecialidad(participante.getEspecialidad().getNombre());

		// Obtener las pruebas
		List<PruebaDTO> pruebasDto = participante.getEspecialidad().getPruebas().stream()
			.map(prueba -> new PruebaDTO(prueba.getEnunciado(), prueba.getPuntuacionMaxima()))
			.toList();
		dto.setPruebas(pruebasDto);

		// Calcular puntuación total
		int puntuacionTotal = pruebasDto.stream()
			.mapToInt(PruebaDTO::getPuntuacion)
			.sum();
		dto.setPuntuacionTotal(puntuacionTotal);

		return dto;
	}
}
