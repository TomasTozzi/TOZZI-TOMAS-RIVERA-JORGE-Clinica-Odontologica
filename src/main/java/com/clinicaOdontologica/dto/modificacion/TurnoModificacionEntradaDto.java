package com.clinicaOdontologica.dto.modificacion;

import com.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TurnoModificacionEntradaDto {

    @NotNull(message = "Debe proveerse el id del turno que se desea modificar")
    private Long id;
    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @NotNull(message = "Debe especificarse la fecha de ingreso del paciente")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaYHora;

    @NotNull(message = "El odontologo no puede ser nulo")
    @Valid
    private Long Odontologo;

    @NotNull(message = "El paciente no puede ser nulo")
    @Valid
    private Long Paciente;


    public TurnoModificacionEntradaDto() {
    }

    public TurnoModificacionEntradaDto(Long id, LocalDate fechaYHora, Long Odontologo, Long Paciente) {
        this.id = id;
        this.fechaYHora = fechaYHora;
        this.Odontologo = Odontologo;
        this.Paciente = Paciente;
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

    public void setOdontologo(Long Odontologo) {
        this.Odontologo = Odontologo;
    }

    public Long getPaciente() {
        return Paciente;
    }

    public void setPaciente(Long Paciente) {
        this.Paciente = Paciente;
    }
}
