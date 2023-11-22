package com.clinicaOdontologica.service;

import com.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.clinicaOdontologica.dto.modificacion.OdontologoModificacionEntradaDto;
import com.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;

import java.util.List;

public interface IOdontologoService {
    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);

    List<OdontologoSalidaDto> listarOdontologos();

    OdontologoSalidaDto buscarOdontologoPorId(Long id);

    OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionEntradaDto odontologo);

    void eliminarOdontologo(Long id);

    OdontologoSalidaDto buscarOdontologoPorDni(int dni);
}

