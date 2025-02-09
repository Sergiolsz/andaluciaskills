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
public class Participante {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idParticipante;

  private String nombre;
  private String apellidos;
  private String centro;

  @ManyToOne
  @JoinColumn(name = "Especialidad_idEspecialidad")
  private Especialidad especialidad;
}