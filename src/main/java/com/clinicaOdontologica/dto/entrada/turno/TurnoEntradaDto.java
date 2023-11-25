package com.clinicaOdontologica.dto.entrada.turno;

import com.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TurnoEntradaDto {
    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @NotNull(message = "Debe especificarse la fecha de ingreso del paciente")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaYHora;

    @NotNull(message = "El id del paciente no puede ser nulo")
    @Valid
    private Long idPaciente;

    @NotNull(message = "El id del odontologo no puede ser nulo")
    @Valid
    private Long idOdontologo;

    public TurnoEntradaDto() {
    }


    public TurnoEntradaDto(LocalDate fechaYHora, Long idPaciente, Long idOdontologo) {
        this.fechaYHora = fechaYHora;
        this.idPaciente = idPaciente;
        this.idOdontologo = idOdontologo;
    }

    public LocalDate getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDate fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Long getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(Long idOdontologo) {
        this.idOdontologo = idOdontologo;
    }
}
