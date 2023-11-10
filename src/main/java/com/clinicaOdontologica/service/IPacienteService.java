package com.clinicaOdontologica.service;

import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.clinicaOdontologica.model.Paciente;

import java.util.List;

public interface IPacienteService {
    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    List<PacienteSalidaDto> listarPacientes();
    PacienteSalidaDto buscarPacientePorId(int id);
    Paciente actualizarPaciente(Paciente paciente);
}
