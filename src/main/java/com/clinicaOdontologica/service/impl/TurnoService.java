package com.clinicaOdontologica.service.impl;

import com.clinicaOdontologica.dto.entrada.turno.TurnoEntradaDto;
import com.clinicaOdontologica.dto.modificacion.TurnoModificacionEntradaDto;
import com.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.clinicaOdontologica.dto.salida.turno.TurnoSalidaDto;
import com.clinicaOdontologica.entity.Turno;
import com.clinicaOdontologica.exepciones.BadRequestException;
import com.clinicaOdontologica.exepciones.ResourceNotFoundException;
import com.clinicaOdontologica.repository.TurnoRepository;
import com.clinicaOdontologica.service.ITurnoService;
import com.clinicaOdontologica.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto) throws BadRequestException {
            TurnoSalidaDto turnoSalidaDto;
            LOGGER.info("TurnoEntradaDto: " + JsonPrinter.toString(turnoEntradaDto));
            PacienteSalidaDto paciente = pacienteService.buscarPacientePorId(turnoEntradaDto.getIdPaciente());
            OdontologoSalidaDto odontologo = odontologoService.buscarOdontologoPorId(turnoEntradaDto.getIdOdontologo());

            String pacienteNoEnBdd = "El paciente no se encuentra en nuestra base de datos";
            String odontologoNoEnBdd = "El odontologo no se encuentra en nuestra base de datos";

            if (paciente == null || odontologo == null) {
               LOGGER.error("El paciente y/o el odontologo no se encuentran en nuestra base de datos");
               throw new BadRequestException("El paciente y/o el odontologo no se encuentran en nuestra base de datos");
            } else {
                Turno turnoEntidad = modelMapper.map(turnoEntradaDto, Turno.class);
                Turno turnoNuevo = turnoRepository.save(turnoEntidad);
                turnoSalidaDto = modelMapper.map(turnoNuevo, TurnoSalidaDto.class);

                LOGGER.info("Nuevo turno registrado con exito: {}", turnoSalidaDto);
            }

            return turnoSalidaDto;
        }





    //fin registrar turno

    @Override
    public List<TurnoSalidaDto> listarTurnos() {
        List<TurnoSalidaDto> turnosSalidaDto = turnoRepository.findAll()
                .stream()
                .map(turno -> modelMapper.map(turno, TurnoSalidaDto.class))
                .toList();

        if (LOGGER.isInfoEnabled())
            LOGGER.info("Listado de todos los turnos: {}", JsonPrinter.toString(turnosSalidaDto));
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
    public void eliminarTurno(Long id) throws ResourceNotFoundException {
        if (turnoRepository.findById(id).orElse(null) != null) {
            turnoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el paciente con id: {}.", id);
        } else {
            LOGGER.error("No se ha encontrado el paciente con id {}", id);
            throw new ResourceNotFoundException("No se ha encontrado el turno con id : " + id);
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
        modelMapper.typeMap(TurnoEntradaDto.class, Turno.class).addMappings(mapper -> mapper.map(TurnoEntradaDto::getIdPaciente, Turno::setIdPaciente)).addMappings(mapper -> mapper.map(TurnoEntradaDto::getIdOdontologo, Turno::setIdOdontologo));
        modelMapper.typeMap(Turno.class, TurnoSalidaDto.class).addMappings(mapper -> mapper.map(Turno::getIdPaciente, TurnoSalidaDto::setPaciente)).addMappings(mapper -> mapper.map(Turno::getIdOdontologo, TurnoSalidaDto::setOdontologo));
        modelMapper.typeMap(TurnoModificacionEntradaDto.class, Turno.class).addMappings(mapper -> mapper.map(TurnoModificacionEntradaDto::getIdPaciente, Turno::setIdPaciente)).addMappings(mapper -> mapper.map(TurnoModificacionEntradaDto::getIdOdontologo, Turno::setIdOdontologo));


    }


}
