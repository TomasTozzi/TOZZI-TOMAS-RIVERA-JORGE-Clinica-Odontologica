package com.clinicaOdontologica.dto.salida.turno;

import com.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;

import java.time.LocalDate;

public class TurnoSalidaDto {
    private Long id;

    private LocalDate fechaYHora;


    private Long odontologo;

    private Long paciente;

    public TurnoSalidaDto() {
    }

    public TurnoSalidaDto(LocalDate fechaYHora, Long odontologo, Long paciente) {

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

    public LocalDate getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDate fechaYHora) {
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

