package com.api.andaluciaskills.infraestructure.adapter;

import com.api.andaluciaskills.domain.entities.Especialidad;
import com.api.andaluciaskills.domain.entities.Prueba;
import com.api.andaluciaskills.domain.port.especialidad.EspecialidadParticipantePort;
import com.api.andaluciaskills.domain.port.especialidad.EspecialidadPruebaPort;
import com.api.andaluciaskills.infraestructure.repository.EspecialidadRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class EspecialidadAdapter implements EspecialidadParticipantePort, EspecialidadPruebaPort {

	private final EspecialidadRepository especialidadRepository;

	public EspecialidadAdapter(EspecialidadRepository especialidadRepository) {

		this.especialidadRepository = especialidadRepository;
	}

	@Override
	public Optional<Especialidad> findEspecialidadById(Long id) {

		return especialidadRepository.findById(id);
	}

	@Override
	public List<Prueba> findPruebasByParticipanteDni(String dni) {

		return especialidadRepository.findPruebasByParticipanteDni(dni);
	}
}