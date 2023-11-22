package com.clinicaOdontologica.service.impl;
import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.clinicaOdontologica.dto.entrada.turno.TurnoEntradaDto;
import com.clinicaOdontologica.dto.modificacion.PacienteModificacionEntradaDto;
import com.clinicaOdontologica.dto.modificacion.TurnoModificacionEntradaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.clinicaOdontologica.dto.salida.turno.TurnoSalidaDto;
import com.clinicaOdontologica.entity.Paciente;
import com.clinicaOdontologica.entity.Turno;
import com.clinicaOdontologica.repository.TurnoRepository;
import com.clinicaOdontologica.service.ITurnoService;
import com.clinicaOdontologica.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TurnoService implements ITurnoService {

    private final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);
    private final TurnoRepository turnoRepository;
    private final ModelMapper modelMapper;
    private final PacienteService pacienteService;
    private OdontologoService odontologoService;

    public TurnoService(TurnoRepository turnoRepository, ModelMapper modelMapper, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.modelMapper = modelMapper;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;

    }


    @Override
    public TurnoSalidaDto registrarTurno(TurnoEntradaDto turno) {
        LOGGER.info("TurnoEntradaDto: " + JsonPrinter.toString(turno));
        Turno turnoEntidad = modelMapper.map(turno, Turno.class);

        Turno turnoAPersistir = turnoRepository.save(turnoEntidad);
        TurnoSalidaDto turnoSalidaDto = modelMapper.map(turnoAPersistir, TurnoSalidaDto.class);
        LOGGER.info("TurnoSalidaDto: " + JsonPrinter.toString(turnoSalidaDto));
        return turnoSalidaDto;
    }

    @Override
    public List<TurnoSalidaDto> listarTurnos() {
        List<TurnoSalidaDto> turnosSalidaDto = turnoRepository.findAll()
                .stream()
                .map(turno -> modelMapper.map(turno, TurnoSalidaDto.class))
                .toList();

        if (LOGGER.isInfoEnabled())
            LOGGER.info("Listado de todos los pacientes: {}", JsonPrinter.toString(turnosSalidaDto));
        return turnosSalidaDto;
    }


    @Override
    public TurnoSalidaDto actualizarTurno(TurnoModificacionEntradaDto turno) {
        Turno turnoRecibido = modelMapper.map(turno, Turno.class);
        Turno turnoAModificar = turnoRepository.findById(turnoRecibido.getId()).orElse(null);

        TurnoSalidaDto turnoSalidaDto = null;


        if (turnoAModificar != null) {
            turnoAModificar = turnoRecibido;
            turnoRepository.save(turnoAModificar);
            turnoSalidaDto = modelMapper.map(turnoAModificar, TurnoSalidaDto.class);
            LOGGER.warn("Paciente actualizado: {}", JsonPrinter.toString(turnoSalidaDto));
        } else {
            LOGGER.error("No fue posible actualizar el paciente porque no se encuentra en nuestra base de datos.");
            //lanzar excepcion correspondiente
        }
        return turnoSalidaDto;
    }

    @Override
    public void eliminarTurno(Long id) {
        if (turnoRepository.findById(id).orElse(null) != null) {
            turnoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el paciente con id: {}.", id);
        } else {
            LOGGER.error("No se ha encontrado el paciente con id {}", id);
            //excepcion a lanzar aqui
        }
    }

    @Override
    public TurnoSalidaDto buscarTurnoPorId(long id) {
        Turno turnoBuscado = turnoRepository.findById(id).orElse(null);
        TurnoSalidaDto turnoEncontrado = null;

        if (turnoBuscado != null) {
            turnoEncontrado = modelMapper.map(turnoBuscado, TurnoSalidaDto.class);
            LOGGER.info("Turno encontrado: {}", JsonPrinter.toString(turnoEncontrado));
        } else LOGGER.error("El id no se encuentra registrado en la base de datos");

        return turnoEncontrado;
    }

    private void configureMapping() {
        modelMapper.typeMap(TurnoEntradaDto.class, Turno.class);
        // Es necesario agregar al mapping el paciente y el odontologo?
        //        .addMappings(mapper -> mapper.map(TurnoEntradaDto::getDomicilioEntradaDto, Paciente::setDomicilio));
        modelMapper.typeMap(Turno.class, TurnoSalidaDto.class);
        // Es necesario agregar al mapping el paciente y el odontologo?
        //         .addMappings(modelMapper -> modelMapper.map(Paciente::getDomicilio, PacienteSalidaDto::setDomicilioSalidaDto));
        modelMapper.typeMap(TurnoModificacionEntradaDto.class, Turno.class);
        // Es necesario agregar al mapping el paciente y el odontologo?
        //         .addMappings(mapper -> mapper.map(PacienteModificacionEntradaDto::getDomicilioEntradaDto, Paciente::setDomicilio));

    }








}
