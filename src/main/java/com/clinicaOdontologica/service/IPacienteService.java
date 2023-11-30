package com.clinicaOdontologica.service;

import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.clinicaOdontologica.dto.modificacion.PacienteModificacionEntradaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.clinicaOdontologica.exepciones.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {
    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    List<PacienteSalidaDto> listarPacientes();

    PacienteSalidaDto buscarPacientePorId(Long id) throws ResourceNotFoundException;

    PacienteSalidaDto actualizarPaciente(PacienteModificacionEntradaDto paciente) throws ResourceNotFoundException;

    void eliminarPaciente(Long id) throws ResourceNotFoundException;

    PacienteSalidaDto buscarPacientePorDni(int dni);
}
