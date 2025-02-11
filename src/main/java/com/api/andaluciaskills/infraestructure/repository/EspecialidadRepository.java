package com.api.andaluciaskills.infraestructure.repository;

import com.api.andaluciaskills.domain.entities.Especialidad;
import com.api.andaluciaskills.domain.entities.Prueba;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {

	@Query("SELECT p FROM Prueba p WHERE p.especialidad = (SELECT pa.especialidad FROM Participante pa WHERE pa.dni = :dni)")
	List<Prueba> findPruebasByParticipanteDni(@Param("dni") String dni);

}
