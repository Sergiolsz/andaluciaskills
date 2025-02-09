package com.api.andaluciaskills.infraestructure.repository;

import com.api.andaluciaskills.domain.entities.EvaluacionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionItemRepository extends JpaRepository<EvaluacionItem, Long> {

}
