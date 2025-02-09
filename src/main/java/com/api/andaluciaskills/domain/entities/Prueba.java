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
public class Prueba {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idPrueba;

  private String enunciado;
  private Integer puntuacionMaxima;

  @ManyToOne
  @JoinColumn(name = "Especialidad_idEspecialidad")
  private Especialidad especialidad;
}