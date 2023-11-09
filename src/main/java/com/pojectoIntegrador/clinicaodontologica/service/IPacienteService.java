package com.pojectoIntegrador.clinicaodontologica.service;

import com.pojectoIntegrador.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.pojectoIntegrador.clinicaodontologica.model.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente registrarPaciente(PacienteEntradaDto paciente);

    List<Paciente> listarPacientes();

    Paciente buscarPacientePorId(int id);

    Paciente actualizarPaciente(Paciente paciente);
}
