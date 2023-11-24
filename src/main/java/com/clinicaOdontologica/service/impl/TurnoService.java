package com.clinicaOdontologica.service.impl;

import com.clinicaOdontologica.dto.entrada.turno.TurnoEntradaDto;
import com.clinicaOdontologica.dto.modificacion.TurnoModificacionEntradaDto;
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
    public TurnoSalidaDto registrarTurno(TurnoEntradaDto turno) throws BadRequestException {
        TurnoSalidaDto turnoSalida = null;

        if (true) {
            //Tengo una fecha valida, la asigno a un variable.
            //tengo un id de paciente => findById(id de paciente) => asignas a la variable => pacienteSalidaDto
            //tengo un id de Odontologo => findById(id de odontologo) => asignas a la variable => OdontologoSalidaDto

            // fecha  + pacienteSalida + OdontologoSalida = registrarTurno

            LOGGER.info("TurnoEntradaDto: " + JsonPrinter.toString(turno));

            Turno turnoEntidad = modelMapper.map(turno, Turno.class);
            Turno turnoAPersistir = turnoRepository.save(turnoEntidad);
            turnoSalida = modelMapper.map(turnoAPersistir, TurnoSalidaDto.class);

        } else {
            LOGGER.info("Hubo un problema al registrar el turno: " + JsonPrinter.toString(turnoSalida));
            throw new BadRequestException("El paciento y/o el Odontologo no existen..");
        }

        return turnoSalida;
    }

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
