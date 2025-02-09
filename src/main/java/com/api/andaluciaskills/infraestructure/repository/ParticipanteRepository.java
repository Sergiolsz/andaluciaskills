package com.api.andaluciaskills.infraestructure.repository;

import com.api.andaluciaskills.domain.entities.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

}
