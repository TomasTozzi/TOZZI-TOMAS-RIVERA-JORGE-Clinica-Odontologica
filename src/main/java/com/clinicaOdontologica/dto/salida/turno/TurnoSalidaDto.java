package com.clinicaOdontologica.dto.salida.turno;

import com.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TurnoSalidaDto {
    private Long id;

    private LocalDateTime fechaYHora;


    private Long odontologo;

    private Long paciente;

    public TurnoSalidaDto() {
    }

    public TurnoSalidaDto(LocalDateTime fechaYHora, Long odontologo, Long paciente) {

        this.fechaYHora = fechaYHora;
        this.odontologo = odontologo;
        this.paciente = paciente;
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
        return odontologo;
    }

    public void setOdontologo(Long odontologo) {
        this.odontologo = odontologo;
    }

    public Long getPaciente() {
        return paciente;
    }

    public void setPaciente(Long paciente) {
        this.paciente = paciente;
    }
}

