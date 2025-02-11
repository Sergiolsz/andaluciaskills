package com.api.andaluciaskills.domain.service;

import com.api.andaluciaskills.application.dto.especialidad.EspecialidadDTO;
import com.api.andaluciaskills.application.dto.participante.CreateParticipanteDTO;
import com.api.andaluciaskills.application.dto.participante.ParticipanteDTO;
import com.api.andaluciaskills.application.dto.participante.ParticipanteDatosPruebasDTO;
import com.api.andaluciaskills.application.dto.participante.UpdateParticipanteDTO;
import com.api.andaluciaskills.domain.entities.Prueba;
import java.util.List;

public interface ParticipanteService {

	ParticipanteDTO createParticipante(CreateParticipanteDTO createParticipanteDTO);

	List<ParticipanteDTO> getAllParticipantes();

	ParticipanteDTO getParticipanteById(String dni);

	ParticipanteDTO editParticipanteById(String dni, UpdateParticipanteDTO updateDto);

	List<Prueba> getPruebasDeParticipante(String dni);

	EspecialidadDTO getEspecialidadDeParticipante(String dni);

	List<ParticipanteDatosPruebasDTO> getParticipantesByEspecialidad(Long especialidadId);

	ParticipanteDTO getTopParticipanteByEspecialidad(Long especialidadId);
}
