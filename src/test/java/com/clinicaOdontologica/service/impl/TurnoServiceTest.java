package com.clinicaOdontologica.service.impl;

import com.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.clinicaOdontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.clinicaOdontologica.dto.entrada.turno.TurnoEntradaDto;
import com.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.clinicaOdontologica.dto.salida.turno.TurnoSalidaDto;
import com.clinicaOdontologica.exepciones.BadRequestException;
import com.clinicaOdontologica.exepciones.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private  OdontologoService odontologoService;

    @Test
    void debeRegistrarTurnoYRetornarId() throws BadRequestException, ResourceNotFoundException {


        PacienteEntradaDto pacienteNuevo = new PacienteEntradaDto("Jorge", "Gonzalez", 123456789, LocalDate.of(2025, 12, 24), new DomicilioEntradaDto("Simpreviva", 1234, "Quilmes", "Bs.As."));
        PacienteSalidaDto pacienteRetorno = pacienteService.registrarPaciente(pacienteNuevo);


        OdontologoEntradaDto odontologoNuevo = new OdontologoEntradaDto("123456789", "Tomas", "Fernandez" );
        OdontologoSalidaDto odontologoRetorno = odontologoService.registrarOdontologo(odontologoNuevo);

        TurnoEntradaDto turnoNuevo = new TurnoEntradaDto(LocalDate.of(2025, 12,12), pacienteRetorno.getId(), odontologoRetorno.getId());
        TurnoSalidaDto turnoRetorno = turnoService.registrarTurno(turnoNuevo);

        assertNotNull(turnoRetorno.getId());

    }

    @Test
    void deberiaEliminarUnTurno() throws BadRequestException, ResourceNotFoundException {
        PacienteEntradaDto pacienteNuevo = new PacienteEntradaDto("Jorge", "Gonzalez", 123456789, LocalDate.of(2025, 12, 24), new DomicilioEntradaDto("Simpreviva", 1234, "Quilmes", "Bs.As."));
        PacienteSalidaDto pacienteRetorno = pacienteService.registrarPaciente(pacienteNuevo);


        OdontologoEntradaDto odontologoNuevo = new OdontologoEntradaDto("123456789", "Tomas", "Fernandez" );
        OdontologoSalidaDto odontologoRetorno = odontologoService.registrarOdontologo(odontologoNuevo);

        TurnoEntradaDto turnoNuevo = new TurnoEntradaDto(LocalDate.of(2025, 12,12), pacienteRetorno.getId(), odontologoRetorno.getId());
        TurnoSalidaDto turnoRetorno = turnoService.registrarTurno(turnoNuevo);

        turnoService.eliminarTurno(turnoRetorno.getId());

        assertTrue(turnoService.listarTurnos().isEmpty());

    }


    @Test
    void laListaDeberiaEstarLlena() throws BadRequestException, ResourceNotFoundException {
        PacienteEntradaDto pacienteNuevo = new PacienteEntradaDto("Jorge", "Gonzalez", 123456789, LocalDate.of(2025, 12, 24), new DomicilioEntradaDto("Simpreviva", 1234, "Quilmes", "Bs.As."));
        PacienteSalidaDto pacienteRetorno = pacienteService.registrarPaciente(pacienteNuevo);


        OdontologoEntradaDto odontologoNuevo = new OdontologoEntradaDto("123456789", "Tomas", "Fernandez" );
        OdontologoSalidaDto odontologoRetorno = odontologoService.registrarOdontologo(odontologoNuevo);

        TurnoEntradaDto turnoNuevo = new TurnoEntradaDto(LocalDate.of(2025, 12,12), pacienteRetorno.getId(), odontologoRetorno.getId());
        TurnoSalidaDto turnoRetorno = turnoService.registrarTurno(turnoNuevo);

        assertFalse(turnoService.listarTurnos().isEmpty());
    }

}