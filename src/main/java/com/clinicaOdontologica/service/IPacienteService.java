package com.clinicaOdontologica.service;

import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.clinicaOdontologica.dto.modificacion.PacienteModificacionEntradaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;

import java.util.List;

public interface IPacienteService {
    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    List<PacienteSalidaDto> listarPacientes();

    PacienteSalidaDto buscarPacientePorId(Long id);

    PacienteSalidaDto actualizarPaciente(PacienteModificacionEntradaDto paciente);

    void eliminarPaciente(Long id);

    PacienteSalidaDto buscarPacientePorDni(int dni);
}
