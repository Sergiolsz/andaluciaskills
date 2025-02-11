package com.api.andaluciaskills.application.service;

import com.api.andaluciaskills.application.dto.especialidad.EspecialidadDTO;
import com.api.andaluciaskills.application.mapper.EspecialidadMapper;
import com.api.andaluciaskills.domain.exception.EspecialidadNotFoundException;
import com.api.andaluciaskills.domain.service.EspecialidadService;
import com.api.andaluciaskills.infraestructure.repository.EspecialidadRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

	private final EspecialidadRepository especialidadRepository;
	private final EspecialidadMapper especialidadMapper;

	public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository) {

		this.especialidadRepository = especialidadRepository;
		this.especialidadMapper = EspecialidadMapper.INSTANCE;
	}

	@Override
	public List<EspecialidadDTO> getAllEspecialidades() {

		return especialidadRepository.findAll()
			.stream()
			.map(especialidadMapper::toDto)
			.toList();
	}

	@Override
	public EspecialidadDTO getEspecialidadById(Long id) {

		var especialidad = especialidadRepository.findById(id)
			.orElseThrow(EspecialidadNotFoundException::new);
		return especialidadMapper.toDto(especialidad);
	}
}