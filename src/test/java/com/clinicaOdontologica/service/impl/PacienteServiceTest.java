package com.clinicaOdontologica.service.impl;

import com.clinicaOdontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.clinicaOdontologica.exepciones.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    @Order(1)
    void debeRegistrarPacienteJorgeYRetornarId() {
        PacienteEntradaDto pacienteNuevo = new PacienteEntradaDto("Jorge", "Gonzalez", 123456789, LocalDate.of(2025, 12, 24), new DomicilioEntradaDto("Simpreviva", 1234, "Quilmes", "Bs.As."));

        PacienteSalidaDto pacienteRetorno = pacienteService.registrarPaciente(pacienteNuevo);

        assertNotNull(pacienteRetorno.getId());
        assertEquals("Jorge", pacienteRetorno.getNombre());

    }

    @Test
    @Order(2)
    void debeRetornarListaVacia(){
        List<PacienteSalidaDto> listaPacientes = pacienteService.listarPacientes();
        assertTrue(listaPacientes.isEmpty());
    }

    @Test
    @Order(3)
    void debeEliminarPacienteConId1(){

        try {
            pacienteService.eliminarPaciente(1L);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThrows(ResourceNotFoundException.class, () -> pacienteService.eliminarPaciente(1L));

    }








}

