package com.clinicaOdontologica.service.impl;

import com.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.clinicaOdontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.clinicaOdontologica.dto.entrada.turno.TurnoEntradaDto;
import com.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.clinicaOdontologica.dto.salida.turno.TurnoSalidaDto;
import com.clinicaOdontologica.exepciones.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;
    private PacienteService pacienteService;
    OdontologoService odontologoService;

    @Test
    void debeRegistrarTurnoYRetornarId() throws BadRequestException {

        OdontologoEntradaDto odontologoNuevo = new OdontologoEntradaDto("123456789", "Tomas", "Fernandez" );
        OdontologoSalidaDto odontologoRetorno = odontologoService.registrarOdontologo(odontologoNuevo);

        PacienteEntradaDto pacienteNuevo = new PacienteEntradaDto("Jorge", "Gonzalez", 123456789, LocalDate.of(2025, 12, 24), new DomicilioEntradaDto("Simpreviva", 1234, "Quilmes", "Bs.As."));
        PacienteSalidaDto pacienteRetorno = pacienteService.registrarPaciente(pacienteNuevo);


        TurnoEntradaDto turnoNuevo = new TurnoEntradaDto(LocalDate.of(2025, 12,12), 1L, 1L);
        TurnoSalidaDto turnoRetorno = turnoService.registrarTurno(turnoNuevo);

        assertNotNull(turnoRetorno.getId());










    }
}