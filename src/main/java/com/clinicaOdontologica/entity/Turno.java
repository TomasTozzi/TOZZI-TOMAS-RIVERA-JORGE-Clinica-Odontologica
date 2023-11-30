package com.clinicaOdontologica.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TURNOS")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaYHora;


    @JoinColumn(name = "odontologo_id")
    //private Odontologo odontologo;
    private Long Odontologo;


    @JoinColumn(name = "paciente_id")
    private Long Paciente;

    public Turno() {
    }

    public Turno(Long id, LocalDate fechaYHora, Long idOdontologo, Long idPaciente) {
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

    public LocalDate getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDate fechaYHora) {
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
