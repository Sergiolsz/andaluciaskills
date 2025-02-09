package com.api.andaluciaskills.infraestructure.repository;

import com.api.andaluciaskills.domain.entities.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Long> {

}
