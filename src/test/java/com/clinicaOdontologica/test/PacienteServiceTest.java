package com.clinicaOdontologica.test;

import com.clinicaOdontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.clinicaOdontologica.repository.PacienteRepository;
import com.clinicaOdontologica.service.impl.PacienteService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {}
    /*private PacienteRepository pacienteRepository;

    private ModelMapper modelMapper;

    public void PacienteService(PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }
    @Test
    void deberiaAgregarUnPaciente() {
        PacienteEntradaDto paciente = new PacienteEntradaDto("Jorge", "Doe", 12345678, LocalDate.of(2024, 01, 01), (new DomicilioEntradaDto("Calle", 123, "La Paz", "Bolivia")));
        PacienteService servicio = new PacienteService(pacienteRepository, modelMapper);

        PacienteSalidaDto pacienteRegistrado = servicio.registrarPaciente(paciente);

        assertTrue(pacienteRegistrado.getId() != 0);

    }
}












  *//*  @Test
    void noDebePermitirAgregarPacienteSinNombre(){

        LocalDate fechaIngreso = LocalDate.of(2024,01,01);
        DomicilioEntradaDto domicilio = new DomicilioEntradaDto("Calle", 123, "La Paz", "Bolivia");
        PacienteEntradaDto paciente = new PacienteEntradaDto("Jorge", "Doe", 12345678, fechaIngreso, (domicilio));

        Paciente pacienteEntidad = modelMapper.map(paciente, Paciente.class);
        Paciente pacienteGuardado = pacienteRepository.save(pacienteEntidad);




        LOGGER.info("Resultado1: " + paciente.toString());
        LOGGER.info("Resultado2: " + pacienteGuardado.toString());


    }*//*



*/