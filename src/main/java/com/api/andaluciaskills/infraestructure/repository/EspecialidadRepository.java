package com.api.andaluciaskills.infraestructure.repository;

import com.api.andaluciaskills.domain.entities.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {

}
