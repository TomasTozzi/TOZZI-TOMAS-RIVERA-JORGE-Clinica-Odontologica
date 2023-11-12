package com.clinicaOdontologica.service;

import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.clinicaOdontologica.model.Paciente;

import java.util.List;

public interface IPacienteService {

    //registrar paciente, ingresa paciente de tipo entrada y vuelve PacienteSalidaDto.
    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    //devuelve todos los pacientes en una lista con PacienteSalidaDto
    List<PacienteSalidaDto> listarPacientes();

    //busca paciente por id, y lo retorna en formato PacienteSalidaDto
    PacienteSalidaDto buscarPacientePorId(int id);

    //actualiza un paciente, con tipo de dato paciente, y vuelve paciente
    //aca deberia ser tambien entrada-salida
    Paciente actualizarPaciente(Paciente paciente);
}
