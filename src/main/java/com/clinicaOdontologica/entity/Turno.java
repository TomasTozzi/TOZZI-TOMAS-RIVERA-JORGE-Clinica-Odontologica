package com.clinicaOdontologica.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TURNOS")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaYHora;


    @JoinColumn(name = "odontologo_id")
    //private Odontologo odontologo;
    private Long Odontologo;


    @JoinColumn(name = "paciente_id")
    private Long Paciente;

    public Turno() {
    }

    public Turno(Long id, LocalDateTime fechaYHora, Long idOdontologo, Long idPaciente) {
        this.id = id;
        this.fechaYHora = fechaYHora;
        this.Odontologo = idOdontologo;
        this.Paciente = idPaciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Long getOdontologo() {
        return Odontologo;
    }

    public void setOdontologo(Long idOdontologo) {
        this.Odontologo = idOdontologo;
    }

    public Long getPaciente() {
        return Paciente;
    }

    public void setPaciente(Long idPaciente) {
        this.Paciente = idPaciente;
    }
}
