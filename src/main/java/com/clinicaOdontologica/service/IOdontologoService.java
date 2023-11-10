package com.clinicaOdontologica.service;

import com.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.clinicaOdontologica.model.Odontologo;

import java.util.List;

public interface IOdontologoService {
       OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);

        List<OdontologoSalidaDto> listarOdontologos();
        OdontologoSalidaDto buscarOdontologoPorId(int id);
        Odontologo actualizarOdontologo(Odontologo odontologo);
    }

