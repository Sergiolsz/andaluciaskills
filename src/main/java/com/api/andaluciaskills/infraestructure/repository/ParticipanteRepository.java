package com.api.andaluciaskills.infraestructure.repository;

import com.api.andaluciaskills.domain.entities.Especialidad;
import com.api.andaluciaskills.domain.entities.Participante;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, String> {

	boolean existsByDni(String dni);

	Optional<Participante> findByDni(String dni);

	Optional<Especialidad> findEspecialidadByDni(String dni);

	Optional<Participante> findTopByEspecialidad_IdEspecialidadOrderByEspecialidad_Pruebas_PuntuacionMaximaDesc
		(Long especialidadId);

	List<Participante> findByEspecialidad_IdEspecialidad(Long especialidadId);

}
