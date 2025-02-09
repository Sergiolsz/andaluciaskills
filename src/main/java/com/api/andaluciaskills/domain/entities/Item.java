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
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idItem;

  private String descripcion;
  private Integer peso;
  private Integer gradosConsecucion;

  @ManyToOne
  @JoinColumn(name = "Prueba_idPrueba")
  private Prueba prueba;
}