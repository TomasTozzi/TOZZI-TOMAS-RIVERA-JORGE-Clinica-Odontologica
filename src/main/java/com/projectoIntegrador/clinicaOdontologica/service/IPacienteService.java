package com.projectoIntegrador.clinicaOdontologica.service;

import com.projectoIntegrador.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.projectoIntegrador.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.projectoIntegrador.clinicaOdontologica.model.Paciente;

import java.util.List;

public interface IPacienteService {
    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    List<PacienteSalidaDto> listarPacientes();
    PacienteSalidaDto buscarPacientePorId(int id);
    Paciente actualizarPaciente(Paciente paciente);
}
