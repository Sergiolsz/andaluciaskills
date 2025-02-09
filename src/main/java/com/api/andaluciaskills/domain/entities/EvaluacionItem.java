package com.api.andaluciaskills.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EvaluacionItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idEvaluacionItem;

  @ManyToOne
  @JoinColumn(name = "Evaluacion_idEvaluacion")
  private Evaluacion evaluacion;

  @ManyToOne
  @JoinColumn(name = "Item_idItem")
  private Item item;

  private Integer valoracion;
  private String explicacion;
}