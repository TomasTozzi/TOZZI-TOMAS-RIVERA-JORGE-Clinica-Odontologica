package com.clinicaOdontologica.service;

import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.clinicaOdontologica.model.Odontologo;
import com.clinicaOdontologica.model.Paciente;

import java.util.List;

public interface IOdontologoService {
       OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);

        List<OdontologoSalidaDto> listarOdontologos();
        OdontologoSalidaDto buscarOdontologoPorId(int id);
        Odontologo actualizarOdontologo(Odontologo odontologo);
    }
}
