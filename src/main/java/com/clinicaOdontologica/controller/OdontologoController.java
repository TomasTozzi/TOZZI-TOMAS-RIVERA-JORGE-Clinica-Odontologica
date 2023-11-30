package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.clinicaOdontologica.dto.modificacion.OdontologoModificacionEntradaDto;
import com.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.clinicaOdontologica.exepciones.ResourceNotFoundException;
import com.clinicaOdontologica.service.IOdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/odontologo")
public class OdontologoController {
    private IOdontologoService odontologoService;

    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<OdontologoSalidaDto> registrarOdontologo(@RequestBody @Valid OdontologoEntradaDto odontologo) {
        return new ResponseEntity<>(odontologoService.registrarOdontologo(odontologo), HttpStatus.CREATED);
    }


    //GET
    @GetMapping("{id}")
    public ResponseEntity<OdontologoSalidaDto> obtenerOdontologoPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(odontologoService.buscarOdontologoPorId(id), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<OdontologoSalidaDto>> listarOdontologos() {
        return new ResponseEntity<>(odontologoService.listarOdontologos(), HttpStatus.OK);
    }

    //PUT
    @PutMapping("/actualizar")
    public OdontologoSalidaDto actualizarOdontologo(@RequestBody OdontologoModificacionEntradaDto odontologo) throws ResourceNotFoundException {
        return odontologoService.actualizarOdontologo(odontologo);
    }


    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return new ResponseEntity<>("Odontologo eliminado correctamente", HttpStatus.OK);
    }





}