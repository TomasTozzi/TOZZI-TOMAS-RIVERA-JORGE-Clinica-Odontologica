package com.clinicaOdontologica.test;

import com.clinicaOdontologica.controller.PacienteController;
import com.clinicaOdontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.clinicaOdontologica.service.IPacienteService;
import com.clinicaOdontologica.service.impl.PacienteService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {
    private final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);
/*
    //Test a realizar :
    // crear un paciente, => debe retornar el mismo paciente
    // Eliminar un paciente => debe retornar el string paciente eliminado
    // No deberia permitir agregar un paciente con nombre null
    private PacienteService pacienteService;
    @Test
    void noDebePermitirAgregarPacienteSinNombre(){
        LocalDate fechaIngreso = LocalDate.of(2024,01,01);
        DomicilioEntradaDto domicilio = new DomicilioEntradaDto("Calle", 123, "La Paz", "Bolivia");
        PacienteEntradaDto paciente = new PacienteEntradaDto("", "Doe", 12345678, fechaIngreso, (domicilio));

        PacienteSalidaDto resultado = pacienteService.registrarPaciente(paciente);
        LOGGER.info("Resultado: " + resultado);
        LOGGER.info("Resultado: " + resultado.toString());






    }

*/
}


