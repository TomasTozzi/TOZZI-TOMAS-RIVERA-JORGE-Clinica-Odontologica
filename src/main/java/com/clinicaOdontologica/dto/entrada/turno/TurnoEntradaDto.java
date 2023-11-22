package com.clinicaOdontologica.dto.entrada.turno;

import com.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TurnoEntradaDto {
    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @NotNull(message = "Debe especificarse la fecha de ingreso del paciente")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime fechaYHora;

    @NotNull(message = "El domicilio del paciente no puede ser nulo")
    @Valid
    private OdontologoEntradaDto odontologo;

    @NotNull(message = "El domicilio del paciente no puede ser nulo")
    @Valid
    private PacienteEntradaDto paciente;

    public TurnoEntradaDto() {
    }

    public TurnoEntradaDto(LocalDateTime fechaYHora, OdontologoEntradaDto odontologo, PacienteEntradaDto paciente) {
        this.fechaYHora = fechaYHora;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public OdontologoEntradaDto getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(OdontologoEntradaDto odontologo) {
        this.odontologo = odontologo;
    }

    public PacienteEntradaDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntradaDto paciente) {
        this.paciente = paciente;
    }
}
