package com.clinicaOdontologica.service.impl;

import com.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.clinicaOdontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.clinicaOdontologica.exepciones.ResourceNotFoundException;
import com.clinicaOdontologica.repository.OdontologoRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {


    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    void debeRegistrarOdontologoTomasYRetornarId() {
        OdontologoEntradaDto odontologoNuevo = new OdontologoEntradaDto("123456789", "Tomas", "Fernandez" );

        OdontologoSalidaDto odontologoRetorno = odontologoService.registrarOdontologo(odontologoNuevo);

        assertNotNull(odontologoRetorno.getId());
        assertEquals("Tomas", odontologoRetorno.getNombre());

    }




    @Test
    @Order(2)
    void debeRetornarListaVacia(){
        List<OdontologoSalidaDto> listaOdontologo = odontologoService.listarOdontologos();
        assertTrue(listaOdontologo.isEmpty());
    }

    @Test
    @Order(3)
    void debeArrojarException(){

        try {
            odontologoService.eliminarOdontologo(1L);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThrows(ResourceNotFoundException.class, () -> odontologoService.eliminarOdontologo(1L));

    }


}
