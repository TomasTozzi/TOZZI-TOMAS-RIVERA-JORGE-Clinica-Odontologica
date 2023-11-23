package com.clinicaOdontologica.service;

import com.clinicaOdontologica.dto.entrada.turno.TurnoEntradaDto;
import com.clinicaOdontologica.dto.modificacion.TurnoModificacionEntradaDto;
import com.clinicaOdontologica.dto.salida.turno.TurnoSalidaDto;
import com.clinicaOdontologica.exepciones.BadRequestException;
import com.clinicaOdontologica.exepciones.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {

    TurnoSalidaDto registrarTurno(TurnoEntradaDto turno) throws BadRequestException;

    List<TurnoSalidaDto> listarTurnos();

    TurnoSalidaDto buscarTurnoPorId(long id);

    TurnoSalidaDto actualizarTurno(TurnoModificacionEntradaDto turno);

    void eliminarTurno(Long id) throws ResourceNotFoundException;

    //metodo equivalente a busqueda por otro parametro.
    //TurnoSalidaDto buscarTurnoPorId(Long id);
}
