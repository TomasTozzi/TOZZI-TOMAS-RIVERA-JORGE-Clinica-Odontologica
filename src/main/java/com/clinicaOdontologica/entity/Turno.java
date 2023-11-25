package com.clinicaOdontologica.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TURNOS")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate fechaYHora;


    @JoinColumn(name = "odontologo_id")
    //private Odontologo odontologo;
    private Long idOdontologo;


    @JoinColumn(name = "paciente_id")
    private Long idPaciente;

    public Turno() {
    }

    public Turno(Long id, LocalDate fechaYHora, Long idOdontologo, Long idPaciente) {
        this.id = id;
        this.fechaYHora = fechaYHora;
        this.idOdontologo = idOdontologo;
        this.idPaciente = idPaciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDate fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Long getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(Long idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }
}
