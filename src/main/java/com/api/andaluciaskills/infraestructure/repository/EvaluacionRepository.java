package com.api.andaluciaskills.infraestructure.repository;

import com.api.andaluciaskills.domain.entities.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {

}
